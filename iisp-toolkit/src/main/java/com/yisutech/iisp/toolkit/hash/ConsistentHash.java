package com.yisutech.iisp.toolkit.hash;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.toolkit.hash.ConsistentHash
 * <p>
 * 描述：
 * 提供一致性hash算法
 *
 * @author guangzhong.wgz
 * @create 2018-03-18 下午5:10
 **/
public final class ConsistentHash<T extends Serializable> {

    private static int per_virtual_number = 160;

    private final ConcurrentSkipListMap<Long, VirtualNode> consistentNodes = new ConcurrentSkipListMap<>();

    public ConsistentHash() {
    }

    public ConsistentHash(Map<String, T> nodes) {
        if (nodes == null || nodes.size() == 0) {
            return;
        }
        nodes.forEach((k, v) -> {
            if (StringUtils.isBlank(k) || v == null) {
                return;
            }
            for (int i = 0; i < per_virtual_number; i++) {
                String key = k + "_" + i;
                long hashCode = hash(key);
                consistentNodes.put(hashCode, new VirtualNode().build(key, hashCode, v));
            }
        });
    }

    public T findNode(String key) {
        if (StringUtils.isBlank(key)) {
            return null;
        }
        Map.Entry<Long, VirtualNode> entry = consistentNodes.higherEntry(hash(key));
        return entry != null ? entry.getValue().getData() : null;
    }

    public boolean addNode(String key, T data) {

        if (StringUtils.isBlank(key) || data == null) {
            return false;
        }

        for (int i = 0; i < per_virtual_number; i++) {

            String virtualKey = key + "_" + i;
            long hashCode = hash(virtualKey);

            consistentNodes.put(hashCode, new VirtualNode().build(virtualKey, hashCode, data));
        }
        return true;
    }

    public boolean removeNode(String key) {

        if (StringUtils.isBlank(key)) {
            return false;
        }

        for (int i = 0; i < per_virtual_number; i++) {

            String virtualKey = key + "_" + i;
            long hashCode = hash(virtualKey);

            if (!consistentNodes.containsKey(hashCode)) {
                continue;
            }
            consistentNodes.remove(hashCode);
        }
        return true;
    }

    public String dumpAll() {
        return JSON.toJSONString(consistentNodes);
    }

    public long hash(String key) {
        return Math.abs(Hashing.murmur3_32().hashBytes(key.getBytes(Charsets.UTF_8)).asInt());
    }

    class VirtualNode {
        /**
         * 节点hash值
         */
        long hashCode;
        /**
         * 节点名称
         */
        String name;
        /**
         * 节点信息
         */
        T data;

        public VirtualNode build(String name, long hashCode, T data) {
            this.setName(name);
            this.setHashCode(hashCode);
            this.setData(data);
            return this;
        }

        public long getHashCode() {
            return hashCode;
        }

        public void setHashCode(long hashCode) {
            this.hashCode = hashCode;
        }

        public T getData() {
            return data;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
}

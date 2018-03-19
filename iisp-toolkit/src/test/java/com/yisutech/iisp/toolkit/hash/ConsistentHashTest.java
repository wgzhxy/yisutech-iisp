package com.yisutech.iisp.toolkit.hash;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import org.junit.Assert;
import org.junit.Test;

import java.io.Serializable;

public class ConsistentHashTest {

    @Test
    public void addNode() throws Exception {

        ConsistentHash<HostInfo> consistentHash = new ConsistentHash();

        HostInfo hostInfo = new HostInfo();
        hostInfo.setIp("127.0.0.1");
        hostInfo.setHostName("localhost");

        Assert.assertTrue(consistentHash.addNode(hostInfo.getIp(), hostInfo));

        hostInfo = new HostInfo();
        hostInfo.setIp("201.208.52.109");
        hostInfo.setHostName("localhost");
        Assert.assertTrue(consistentHash.addNode(hostInfo.getIp(), hostInfo));

        hostInfo = new HostInfo();
        hostInfo.setIp("201.208.52.110");
        hostInfo.setHostName("localhost");
        Assert.assertTrue(consistentHash.addNode(hostInfo.getIp(), hostInfo));

        hostInfo = new HostInfo();
        hostInfo.setIp("201.208.52.111");
        hostInfo.setHostName("localhost");
        Assert.assertTrue(consistentHash.addNode(hostInfo.getIp(), hostInfo));


    }

    @Test
    public void removeNode() throws Exception {

        ConsistentHash<HostInfo> consistentHash = new ConsistentHash();
        HostInfo hostInfo = new HostInfo();
        hostInfo.setIp("201.208.52.111");
        hostInfo.setHostName("localhost");
        Assert.assertTrue(consistentHash.addNode(hostInfo.getIp(), hostInfo));

        hostInfo = new HostInfo();
        hostInfo.setIp("201.208.52.110");
        hostInfo.setHostName("localhost");
        Assert.assertTrue(consistentHash.addNode(hostInfo.getIp(), hostInfo));

        consistentHash.removeNode(hostInfo.getIp());
    }

    @Test
    public void findNode() throws Exception {

        ConsistentHash<HostInfo> consistentHash = new ConsistentHash();
        HostInfo hostInfo = new HostInfo();
        hostInfo.setIp("201.208.52.111");
        hostInfo.setHostName("localhost");
        Assert.assertTrue(consistentHash.addNode(hostInfo.getIp(), hostInfo));

        hostInfo = new HostInfo();
        hostInfo.setIp("201.208.52.110");
        hostInfo.setHostName("localhost");
        Assert.assertTrue(consistentHash.addNode(hostInfo.getIp(), hostInfo));

        System.out.println(consistentHash.dumpAll());
        System.out.println("--------------------------------------");

        Assert.assertNotNull(consistentHash.findNode("test001"));
        System.out.println(JSON.toJSONString(consistentHash.findNode("test001")));

        Assert.assertNotNull(consistentHash.findNode("test002"));
        System.out.println(JSON.toJSONString(consistentHash.findNode("test002")));

        Assert.assertNotNull(consistentHash.findNode("test003"));
        System.out.println(JSON.toJSONString(consistentHash.findNode("test003")));
    }

    @Test
    public void testMurmurhash() {
        String key_1 = "test001";
        System.out.println(Math.abs(Hashing.murmur3_32().hashBytes(key_1.getBytes(Charsets.UTF_8)).asInt()));

         key_1 = "test002";
        System.out.println(Math.abs(Hashing.murmur3_32().hashBytes(key_1.getBytes(Charsets.UTF_8)).asInt()));

        key_1 = "test003";
        System.out.println(Math.abs(Hashing.murmur3_32().hashBytes(key_1.getBytes(Charsets.UTF_8)).asInt()));

        key_1 = "001";
        System.out.println(Math.abs(Hashing.murmur3_32().hashBytes(key_1.getBytes(Charsets.UTF_8)).asInt()));
    }

    class HostInfo implements Serializable {

        private static final long serialVersionUID = 4540828185386734088L;

        String ip;
        String hostName;

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getHostName() {
            return hostName;
        }

        public void setHostName(String hostName) {
            this.hostName = hostName;
        }
    }

}
package com.yisutech.iisp.toolkit.filter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.Funnels;
import com.google.common.hash.PrimitiveSink;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.toolkit.filter.TestBloomFilter
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-03-19 下午5:13
 **/
public class TestBloomFilter {

    @Test
    public void testBloomFilter() {
        int size = 1000000;
        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(), size);

        for (int i = 0; i < size; i++) {
            bloomFilter.put(i);
        }

        AtomicInteger notInBloom = new AtomicInteger();
        for (int i = 0; i < size; i++) {
            if (!bloomFilter.mightContain(i)) {
                notInBloom.incrementAndGet();
            }
        }

        List<Integer> list = new ArrayList<>(1000);
        for (int i = size + 10000; i < size + 20000; i++) {
            if (bloomFilter.mightContain(i)) {
                list.add(i);
            }
        }
        System.out.println("有误伤的数量：" + list.size());
    }
}

package com.yisutech.iisp.toolkit;

import org.junit.Test;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.toolkit.TestConcurrentSkipListMap
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-03-18 下午4:26
 **/
public class TestConcurrentSkipListMap {

    @Test
    public void testConcurrentSkipList() {
        ConcurrentSkipListMap<Long, String> skipListMap = new ConcurrentSkipListMap<>();

        skipListMap.put(3L, "疯狂java讲义");
        skipListMap.put(-5L, "andior教程");
        skipListMap.put(9L, "平凡的世界");
        System.out.println("完整treemap:" + skipListMap);
        System.out.println("firstEntry:" + skipListMap.firstEntry());
        System.out.println("firstKey:" + skipListMap.firstKey());
        System.out.println("headMap:" + skipListMap.headMap(2L));
        System.out.println("lowerEntry:" + skipListMap.lowerEntry(12L));
        System.out.println("higherEntry:" + skipListMap.higherEntry(2L));
    }

}

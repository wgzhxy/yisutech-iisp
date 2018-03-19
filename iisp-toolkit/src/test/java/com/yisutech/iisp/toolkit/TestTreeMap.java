package com.yisutech.iisp.toolkit;

import org.junit.Test;

import java.util.TreeMap;

/**
 * @author guangzhong.wgz
 */
public class TestTreeMap {

    @Test
    public void testTailMap() {

        TreeMap<Long, String> treemap = new TreeMap();
        treemap.put(3L, "疯狂java讲义");
        treemap.put(-5L, "andior教程");
        treemap.put(9L, "平凡的世界");
        System.out.println("完整treemap:" + treemap);
        System.out.println("firstEntry:" + treemap.firstEntry());
        System.out.println("firstKey:" + treemap.firstKey());
        System.out.println("headMap:" + treemap.headMap(2L));
        System.out.println("lowerEntry:" + treemap.lowerEntry(12L));
        System.out.println("higherEntry:" + treemap.higherEntry(2L));
    }
}

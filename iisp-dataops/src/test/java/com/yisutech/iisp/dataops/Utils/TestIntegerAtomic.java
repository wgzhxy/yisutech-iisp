package com.yisutech.iisp.dataops.Utils;

import com.alibaba.fastjson.JSON;
import com.yisutech.iisp.dataops.engine.adapter.dtsource.DataSourceConfig;
import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.dataops.Utils.TestIntegerAtomic
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-03-23 下午5:27
 **/
public class TestIntegerAtomic {

    @Test
    public void testIntegerAtomicCompare() {

        final AtomicInteger total = new AtomicInteger();
        final AtomicBoolean comp = new AtomicBoolean(Boolean.FALSE);

        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (comp.compareAndSet(Boolean.FALSE, Boolean.TRUE)) {
                    total.incrementAndGet();
                }

            }).start();
        }
        try {
            Thread.sleep(2000);
            Assert.assertTrue(total.get() == 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void generateDataSourceConfig() {

        DataSourceConfig sourceConfig = new DataSourceConfig();

        sourceConfig.setDbUrl("jdbc:mysql://localhost:3306/yisuyun_console?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        sourceConfig.setName("testDB");
        sourceConfig.setUsername("yisuyun_admin");
        sourceConfig.setPassword("wgzhxy119@");

        Assert.assertNotNull(JSON.toJSONString(sourceConfig));
    }
}

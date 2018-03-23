package com.yisutech.iisp.dataops.adapter.impl;

import com.yisutech.iisp.dataops.StarterApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StarterApplication.class)
public class MysqlOpsTemplateImplTest {

    @Resource
    DataSource dataSource;

    @Test
    public void query() throws Exception {
        MysqlOpsTemplateImpl template = new MysqlOpsTemplateImpl(dataSource);
        List<Map<String, Object>> list = template.query("select * from ops_data_source", null);
        Assert.assertNotNull(list);
    }

    @Test
    public void query1() throws Exception {
    }

    @Test
    public void query2() throws Exception {
    }

    @Test
    public void query3() throws Exception {
    }

}
package com.yisutech.iisp.dataops.engine.template.impl;

import com.google.common.collect.Lists;
import com.yisutech.iisp.dataops.StarterApplication;
import com.yisutech.iisp.dataops.engine.template.DataOpsTemplate;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StarterApplication.class)
public class MysqlOpsTemplateImplTest {

    @Resource
    private DataSource dataSource;

    private DataOpsTemplate dataOpsTemplate;

    @Before
    public void init() {
        dataOpsTemplate = new MysqlOpsTemplateImpl(dataSource);
    }

    @Test
    public void query() throws Exception {

        String sqlTemplate = "select * from ops_data_source";
        List<Pair<String, Object>> values = Lists.newArrayList();
        List<Map<String, Object>> result = dataOpsTemplate.query(sqlTemplate, values);

        Assert.assertNotNull(result);
    }

    @Test
    public void queryByPageSize() throws Exception {

        String sqlTemplate = "select * from ops_data_source";
        List<Pair<String, Object>> values = Lists.newArrayList();
        List<Map<String, Object>> result = dataOpsTemplate.query(sqlTemplate, values, 0, 2);

        Assert.assertTrue(result.size() == 2);
    }

    @Test
    public void query2() throws Exception {

    }

    @Test
    public void query3() throws Exception {
    }

    @Test
    public void insert() throws Exception {

        String sqlTemplate = "insert ops_data_source(ds_url, ds_user, ds_password, ds_name, ds_desc) value(?,?,?,?,?)";

        List<Pair<String, Object>> values = Lists.newArrayList();
        values.add(Pair.of("ds_url", "ds_url1"));
        values.add(Pair.of("ds_user", "admin"));
        values.add(Pair.of("ds_password", "wgzhxy119@"));
        values.add(Pair.of("ds_name", "test"));
        values.add(Pair.of("ds_desc", "test is simple"));

        int count = dataOpsTemplate.insert(sqlTemplate, values);

        Assert.assertNotNull(count);
    }

    @Test
    public void insert1() throws Exception {
    }

    @Test
    public void batchInsert() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void update1() throws Exception {
    }

    @Test
    public void batchUpdate() throws Exception {
    }

    @Test
    public void createTable() throws Exception {
    }

    @Test
    public void dropTable() throws Exception {
    }

    @Test
    public void alterTable() throws Exception {
    }
}
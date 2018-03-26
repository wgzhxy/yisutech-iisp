package com.yisutech.iisp.dataops.adapter.impl;

import com.yisutech.iisp.dataops.StarterApplication;
import com.yisutech.iisp.dataops.engine.DataOpsEngine;
import com.yisutech.iisp.dataops.engine.template.DataOpsTemplate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StarterApplication.class)
public class MysqlOpsTemplateImplTest {

    @Resource
    DataOpsEngine dataOpsEngine;

    @Test
    public void query() throws Exception {
        DataOpsTemplate dataOpsTemplate = (DataOpsTemplate) dataOpsEngine.getInstance(DataOpsEngine.DataOpsTplType.MYSQL);

        List<Map<String, Object>> list = dataOpsTemplate.query("select * from ops_data_source", null);
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
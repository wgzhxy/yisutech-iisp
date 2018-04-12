package com.yisutech.iisp.dataops.service.impl;

import com.alibaba.fastjson.JSON;
import com.yisutech.iisp.dataops.StarterApplication;
import com.yisutech.iisp.dataops.engine.adapter.dtsource.DataSourceConfig;
import com.yisutech.iisp.dataops.engine.template.model.DataSourceMeta;
import com.yisutech.iisp.dataops.repository.pojo.OpsDataSource;
import com.yisutech.iisp.dataops.service.DataMetaService;
import com.yisutech.iisp.dataops.service.model.DataOpsResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StarterApplication.class)
public class DataMetaServiceImplTest {

    @Resource
    private DataMetaService dataMetaService;

    @Test
    public void addDataSource() throws Exception {

        OpsDataSource opsDataSource = new OpsDataSource();
        opsDataSource.setDsName("test_10000");
        opsDataSource.setDsUser("root");
        opsDataSource.setDsPassword("wgzhxy119@");
        opsDataSource.setDsUrl("test:///");
        opsDataSource.setDsExtParam(JSON.toJSONString(new DataSourceConfig()));
        opsDataSource.setDsType(DataSourceMeta.DataOpsType.MYSQL.name());
        opsDataSource.setDsDesc("test_10000");

        DataOpsResponse<Integer> rsp = dataMetaService.addDataSource(opsDataSource);
        Assert.assertTrue(rsp.getModel() > 0);
    }

    @Test
    public void updateDataSource() throws Exception {
    }

    @Test
    public void addTable() throws Exception {
    }

    @Test
    public void updateTable() throws Exception {
    }

    @Test
    public void addTableColumn() throws Exception {
    }

    @Test
    public void updateTableColumn() throws Exception {
    }

    @Test
    public void addLogicTable() throws Exception {
    }

    @Test
    public void updateLogicTable() throws Exception {
    }

    @Test
    public void addLogicTableColumn() throws Exception {
    }

    @Test
    public void updateLogicTableColumn() throws Exception {
    }

    @Test
    public void deleteTable() throws Exception {
    }

    @Test
    public void deleteLogicTable() throws Exception {
    }

}
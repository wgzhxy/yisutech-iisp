package com.yisutech.iisp.dataops.engine;

import com.yisutech.iisp.dataops.StarterApplication;
import com.yisutech.iisp.dataops.engine.template.impl.MysqlOpsTemplateImpl;
import com.yisutech.iisp.dataops.engine.template.model.DataSourceMeta;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author guangzhong.wgz
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StarterApplication.class)
public class DataOpsEngineTest {

    @Resource
    private DataOpsEngine<MysqlOpsTemplateImpl> dataOpsEngine;

    @Test
    public void getDataOpsTemplate() throws Exception {

        DataOpsContext dataOpsContext = new DataOpsContext();
        dataOpsContext.setDataOpsType(DataSourceMeta.DataOpsType.MYSQL);

        MysqlOpsTemplateImpl mysqlOpsTemplate = dataOpsEngine.getDataOpsTemplate(dataOpsContext);

        Assert.assertNotNull(mysqlOpsTemplate);
    }

    @Test
    public void getDefaultDataOpsTemplate() throws Exception {
    }

}
package com.yisutech.iisp.dataops;

import com.yisutech.iisp.dataops.repository.mapper.OpsDataSourceMapper;
import com.yisutech.iisp.dataops.repository.pojo.OpsDataSource;
import com.yisutech.iisp.toolkit.utils.ValidUtil;
import org.apache.commons.lang3.tuple.MutablePair;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.ConstraintViolation;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StarterApplication.class)
public class YisutechCoreEngineApplicationTests {

    @Autowired
    private OpsDataSourceMapper opsDataSourceMapper;

    @Test
    @Transactional
    public void test3() {

        OpsDataSource opsDataSource = new OpsDataSource();
        opsDataSource.setDsDesc("测试数据库");
        opsDataSource.setDsName("yisuyun_admin");
        opsDataSource.setDsPassword("");

        Map<String, MutablePair> message = ValidUtil.allValid(opsDataSource);

        opsDataSourceMapper.insert(opsDataSource);

        OpsDataSource opsDataSourceDo = opsDataSourceMapper.selectByPrimaryKey(1);

        Assert.assertEquals(null, opsDataSourceDo);
    }

}

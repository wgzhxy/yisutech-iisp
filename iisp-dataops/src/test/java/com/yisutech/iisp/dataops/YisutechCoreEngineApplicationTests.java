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

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StarterApplication.class)
public class YisutechCoreEngineApplicationTests {

    @Autowired
    private OpsDataSourceMapper opsDataSourceMapper;

    @Test
    public void testDataSourceMapperInsert() {

        OpsDataSource opsDataSource = new OpsDataSource();
        opsDataSource.setDsUser("yisuyun_admin");
        opsDataSource.setDsPassword("wgzhxy119@");
        opsDataSource.setDsUrl("jdbc:mysql://localhost:3306/yisuyun_console?useUnicode=true&characterEncoding=UTF-8" +
                "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        opsDataSource.setDsName("yisuyun_console");

        Map<String, String> message = ValidUtil.allValid(opsDataSource);
        if(message.size() > 0) {
            throw new NullPointerException("error");
        }

        OpsDataSource opsDataSourceDo = opsDataSourceMapper.selectByPrimaryKey(1);
        if(opsDataSourceDo == null) {
            opsDataSourceMapper.insert(opsDataSource);
        }

        Assert.assertNotNull(opsDataSource);
    }

    @Test
    @Transactional
    public void testDataSourceMapperSelect() {
        OpsDataSource opsDataSourceDo = opsDataSourceMapper.selectByPrimaryKey(4);
        Assert.assertNotNull(opsDataSourceDo);
    }

}

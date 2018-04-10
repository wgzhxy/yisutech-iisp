package com.yisutech.iisp.dataops.service;

import com.yisutech.iisp.dataops.StarterApplication;
import com.yisutech.iisp.dataops.service.model.DataOpsRequest;
import com.yisutech.iisp.dataops.service.model.DataOpsResponse;
import com.yisutech.iisp.toolkit.utils.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StarterApplication.class)
public class DataOpsServiceTest {

    @Resource
    private DataOpsService dataOpsService;

    @Test
    public void add() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void update() throws Exception {
    }

    @Test
    public void query() throws Exception {
        DataOpsRequest dataOpsRequest = new DataOpsRequest();
        // dataOpsRequest.setTableCode();

        DataOpsResponse<PageInfo<List<Map<String, Object>>>> response = dataOpsService.query(dataOpsRequest);
    }

}
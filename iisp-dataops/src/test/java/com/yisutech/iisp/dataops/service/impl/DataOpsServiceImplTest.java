package com.yisutech.iisp.dataops.service.impl;

import com.google.common.collect.Lists;
import com.yisutech.iisp.dataops.StarterApplication;
import com.yisutech.iisp.dataops.service.DataOpsService;
import com.yisutech.iisp.dataops.service.model.DataOpsRequest;
import com.yisutech.iisp.dataops.service.model.DataOpsResponse;
import com.yisutech.iisp.toolkit.utils.PageInfo;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
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
public class DataOpsServiceImplTest {

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
    public void query_byPage() throws Exception {

        DataOpsRequest dataOpsRequest = new DataOpsRequest();
        dataOpsRequest.setTableCode("2");
        DataOpsResponse<PageInfo<List<Map<String, Object>>>> dataOpsResponse = dataOpsService.query(dataOpsRequest);

        Assert.assertNotNull(dataOpsResponse);
        Assert.assertTrue(dataOpsResponse.getModel() != null && dataOpsResponse.getModel().getList().size() > 0);
    }

    @Test
    public void query_where_columns_byPage() throws Exception {

        DataOpsRequest dataOpsRequest = new DataOpsRequest();
        dataOpsRequest.setTableCode("1");
        dataOpsRequest.setCurrentPage(1);
        dataOpsRequest.setPageSize(20);

        List<Pair<String, Object>> whereColumnValues = Lists.newArrayList();
        whereColumnValues.add(MutablePair.of("id", 9));
        whereColumnValues.add(MutablePair.of("ds_user", "root"));
        dataOpsRequest.setWhereColumnValues(whereColumnValues);

        DataOpsResponse<PageInfo<List<Map<String, Object>>>> dataOpsResponse = dataOpsService.query(dataOpsRequest);

        Assert.assertNotNull(dataOpsResponse);
        Assert.assertTrue(dataOpsResponse.getModel() != null && dataOpsResponse.getModel().getList().size() > 0);
    }

}
package com.yisutech.iisp.dataops.service.impl;

import com.yisutech.iisp.dataops.engine.DataOpsContext;
import com.yisutech.iisp.dataops.engine.DataOpsEngine;
import com.yisutech.iisp.dataops.engine.template.DataOpsTemplate;
import com.yisutech.iisp.dataops.engine.template.model.DataSourceMeta;
import com.yisutech.iisp.dataops.service.DataOpsService;
import com.yisutech.iisp.dataops.service.model.DataOpsRequest;
import com.yisutech.iisp.dataops.service.model.DataOpsResponse;
import com.yisutech.iisp.toolkit.utils.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.dataops.service.impl.DataOpsServiceImpl
 * 描述：
 * 数据操作服务接口实现
 *
 * @author guangzhong.wgz
 * @create 2018-03-28 下午2:21
 **/
@Service
public class DataOpsServiceImpl implements DataOpsService {


    @Override
    public DataOpsResponse<Map<String, Object>> save(DataOpsRequest dataOpsRequest) {


        return null;
    }

    @Override
    public DataOpsResponse<PageInfo<Map<String, Object>>> query(DataOpsRequest dataOpsRequest) {

        return null;
    }

    @Override
    public DataOpsResponse<Integer> delete(DataOpsRequest dataOpsRequest) {

        return null;
    }

    private DataOpsTemplate getTemplate() {
        DataOpsContext dataOpsContext = new DataOpsContext();
        dataOpsContext.setDataOpsType(DataSourceMeta.DataOpsType.MYSQL);
        dataOpsContext.setDataSourceConfig("");
        return dataOpsEngine.getDataOpsTemplate(dataOpsContext);
    }

    @Resource
    private DataOpsEngine<DataOpsTemplate> dataOpsEngine;

    private Logger FLUSH_DATAOPS_ENGINE = LoggerFactory.getLogger("flush_dataops_engine");
}

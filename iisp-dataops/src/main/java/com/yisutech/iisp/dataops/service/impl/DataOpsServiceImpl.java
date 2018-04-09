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
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

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
    public DataOpsResponse<Map<String, Object>> add(DataOpsRequest dataOpsRequest) {

        DataOpsTemplate opsTemplate = getTemplate("");
        PlatformTransactionManager txManager = opsTemplate.getTransactionManager();
        TransactionStatus status = txManager.getTransaction(definition);
        try {


            txManager.commit(status);
        } catch (Throwable e) {
            txManager.rollback(status);
            FLUSH_DATAOPS_ENGINE.error("save_error", e);
        }
        return null;
    }

    @Override
    public DataOpsResponse<Integer> delete(DataOpsRequest dataOpsRequest) {

        return null;
    }

    @Override
    public DataOpsResponse<Map<String, Object>> update(DataOpsRequest dataOpsRequest) {
        return null;
    }

    @Override
    public DataOpsResponse<PageInfo<Map<String, Object>>> query(DataOpsRequest dataOpsRequest) {

        return null;
    }

    private DataOpsTemplate getTemplate(String dataSourceConfig) {
        DataOpsContext dataOpsContext = new DataOpsContext();
        dataOpsContext.setDataOpsType(DataSourceMeta.DataOpsType.MYSQL);
        dataOpsContext.setDataSourceConfig(dataSourceConfig);
        dataOpsTemplate = dataOpsEngine.getDataOpsTemplate(dataOpsContext);
        return dataOpsTemplate;
    }

    @PostConstruct
    public void init() {
        if (initComp.compareAndSet(Boolean.FALSE, Boolean.TRUE)) {
            definition = new DefaultTransactionDefinition();
            definition.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
            definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        }
    }

    @Resource
    private DataOpsEngine<DataOpsTemplate> dataOpsEngine;

    private DataOpsTemplate dataOpsTemplate;
    private DefaultTransactionDefinition definition;

    private AtomicBoolean initComp = new AtomicBoolean(Boolean.FALSE);
    private Logger FLUSH_DATAOPS_ENGINE = LoggerFactory.getLogger("flush_dataops_engine");
}

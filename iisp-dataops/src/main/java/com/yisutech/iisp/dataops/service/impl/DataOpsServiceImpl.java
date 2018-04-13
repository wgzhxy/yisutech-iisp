package com.yisutech.iisp.dataops.service.impl;

import com.google.common.collect.Lists;
import com.yisutech.iisp.dataops.config.DataOpsConfigService;
import com.yisutech.iisp.dataops.config.DbConfigEnum;
import com.yisutech.iisp.dataops.engine.DataOpsContext;
import com.yisutech.iisp.dataops.engine.DataOpsEngine;
import com.yisutech.iisp.dataops.engine.template.DataOpsTemplate;
import com.yisutech.iisp.dataops.engine.template.model.ColumnMeta;
import com.yisutech.iisp.dataops.engine.template.model.DataSourceMeta;
import com.yisutech.iisp.dataops.engine.template.model.TableMeta;
import com.yisutech.iisp.dataops.service.DataOpsService;
import com.yisutech.iisp.dataops.service.model.DataOpsRequest;
import com.yisutech.iisp.dataops.service.model.DataOpsResponse;
import com.yisutech.iisp.toolkit.utils.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
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
    public DataOpsResponse<Integer> add(DataOpsRequest dataOpsRequest) {

        DataOpsResponse<Integer> result = new DataOpsResponse<>();

        // 字段写入参数检查
        Assert.notNull(dataOpsRequest.getColumnValues(), String.format("columnVales is empty"));

        Integer count = operation((meta, template) -> {

            TableMeta tpMeta = (TableMeta) meta;

            if (tpMeta.getTableType() == DbConfigEnum.TableType.LOGIC_TABLE) {
                return ((DataOpsTemplate) template).insert(tpMeta.getUdSql(), dataOpsRequest.getColumnValues());

            } else if(tpMeta.getTableType() == DbConfigEnum.TableType.TABLE) {
                return ((DataOpsTemplate) template).insert(tpMeta, dataOpsRequest.getColumnValues());

            } else {
                throw new RuntimeException("TableType error");
            }
        }, dataOpsRequest);

        result.setModel(count);
        return result;
    }

    @Override
    public DataOpsResponse<Integer> delete(DataOpsRequest dataOpsRequest) {

        DataOpsResponse<Integer> result = new DataOpsResponse<>();

        // 字段写入参数检查
        Assert.notNull(dataOpsRequest.getWhereColumnValues(), String.format("whereColumnValues is empty"));

        // 拼装参数
        List<ColumnMeta> whereColumns = Lists.newArrayList();

        dataOpsRequest.getWhereColumnValues().forEach(pair -> {

            ColumnMeta columnMeta = new ColumnMeta();
            columnMeta.setColumnName(pair.getKey());

            whereColumns.add(columnMeta);
        });

        Integer count = operation((meta, template) -> {

            TableMeta tpMeta = (TableMeta) meta;

            if (tpMeta.getTableType() == DbConfigEnum.TableType.LOGIC_TABLE) {
                return ((DataOpsTemplate) template).delete(tpMeta.getUdSql(), dataOpsRequest.getWhereColumnValues());

            } else if(tpMeta.getTableType() == DbConfigEnum.TableType.TABLE) {
                return ((DataOpsTemplate) template).delete(tpMeta, whereColumns, dataOpsRequest.getWhereColumnValues());

            } else {
                throw new RuntimeException("TableType error");
            }
        }, dataOpsRequest);

        result.setModel(count);
        return result;
    }

    @Override
    public DataOpsResponse<Integer> update(DataOpsRequest dataOpsRequest) {

        DataOpsResponse<Integer> result = new DataOpsResponse<>();

        // 字段写入参数检查
        Assert.notNull(dataOpsRequest.getWhereColumnValues(), String.format("whereColumnValues is empty"));

        Integer count = operation((meta, template) -> {

            TableMeta tpMeta = (TableMeta) meta;

            if (tpMeta.getTableType() == DbConfigEnum.TableType.LOGIC_TABLE) {
                return ((DataOpsTemplate) template).update(tpMeta.getUdSql(), dataOpsRequest.getWhereColumnValues());

            } else if(tpMeta.getTableType() == DbConfigEnum.TableType.TABLE) {
                return ((DataOpsTemplate) template).update(tpMeta, dataOpsRequest.getColumnValues(), dataOpsRequest.getWhereColumnValues());

            } else {
                throw new RuntimeException("TableType error");
            }
        }, dataOpsRequest);

        result.setModel(count);
        return result;
    }

    @Override
    public DataOpsResponse<PageInfo<List<Map<String, Object>>>> query(DataOpsRequest dataOpsRequest) {

        DataOpsResponse<PageInfo<List<Map<String, Object>>>> result = new DataOpsResponse<>();

        int pageSize = dataOpsRequest.getPageSize();
        if (pageSize <= 0) {
            pageSize = 20;
        }
        int currentPage = dataOpsRequest.getCurrentPage();
        if (currentPage <= 0) {
            currentPage = 1;
        }

        final int offset = (currentPage - 1) * pageSize;
        final int size = pageSize;

        // 字段写入参数检查
        List<ColumnMeta> columnMetas = Lists.newArrayList();
        dataOpsRequest.getWhereColumnValues().forEach(pair -> {

            ColumnMeta columnMeta = new ColumnMeta();
            columnMeta.setColumnName(pair.getKey());

            columnMetas.add(columnMeta);
        });

        List<Map<String, Object>> resultMap = operation((meta, template) -> {

            TableMeta tpMeta = (TableMeta) meta;

            if (tpMeta.getTableType() == DbConfigEnum.TableType.LOGIC_TABLE) {
                return ((DataOpsTemplate) template).query(tpMeta.getUdSql(), dataOpsRequest.getWhereColumnValues(), dataOpsRequest.getColumnValues(),
                        offset, size);

            } else if (tpMeta.getTableType() == DbConfigEnum.TableType.TABLE) {
                return ((DataOpsTemplate) template).query(tpMeta, columnMetas, dataOpsRequest.getWhereColumnValues(), offset, size);

            } else {
                throw new RuntimeException("TableType error");
            }
        }, dataOpsRequest);

        PageInfo<List<Map<String, Object>>> pageInfo = new PageInfo(resultMap, currentPage);
        result.setModel(pageInfo);

        return result;
    }

    private DataOpsTemplate getTemplate(String dataSourceConfig) {
        DataOpsContext dataOpsContext = new DataOpsContext();
        dataOpsContext.setDataOpsType(DataSourceMeta.DataOpsType.MYSQL);
        dataOpsContext.setDataSourceConfig(dataSourceConfig);
        dataOpsTemplate = dataOpsEngine.getDataOpsTemplate(dataOpsContext);
        return dataOpsTemplate;
    }

    @PostConstruct
    private void init() {
        if (initComp.compareAndSet(Boolean.FALSE, Boolean.TRUE)) {
            definition = new DefaultTransactionDefinition();
            definition.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
            definition.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        }
    }

    private <T, U, R> R operation(Processor<T, U, R> processor, DataOpsRequest dataOpsRequest) {

        // 参数检查
        Assert.notNull(dataOpsRequest, String.format("dataOpsRequest is empty"));

        // 表信息检查
        final TableMeta tableMeta = dataOpsConfigService.getTableMeta(dataOpsRequest.getTableCode());
        final DataOpsTemplate opsTemplate = getTemplate(tableMeta.getDataSourceMeta().getDataSourceConfig());

        Assert.notNull(tableMeta, String.format("tableMeta is null"));
        Assert.notNull(opsTemplate, String.format("opsTemplate is null"));

        PlatformTransactionManager txManager = opsTemplate.getTransactionManager();
        TransactionStatus status = txManager.getTransaction(definition);

        R r = null;
        try {
            r = processor.call((T) tableMeta, (U) opsTemplate);
            txManager.commit(status);
        } catch (Throwable e) {
            txManager.rollback(status);
            throw new RuntimeException(e.getCause());
        }
        return r;
    }

    @FunctionalInterface
    private interface Processor<T, U, R> {
        R call(T t, U u);
    }

    @Resource
    private DataOpsConfigService dataOpsConfigService;
    @Resource
    private DataOpsEngine<DataOpsTemplate> dataOpsEngine;

    private DataOpsTemplate dataOpsTemplate;
    private DefaultTransactionDefinition definition;

    private AtomicBoolean initComp = new AtomicBoolean(Boolean.FALSE);
    private Logger FLUSH_DATAOPS_ENGINE = LoggerFactory.getLogger("flush_dataops_engine");
}

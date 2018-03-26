package com.yisutech.iisp.dataops.engine.adapter.impl;

import com.google.common.collect.Maps;
import com.yisutech.iisp.dataops.engine.DataOps;
import com.yisutech.iisp.dataops.engine.DataOpsContext;
import com.yisutech.iisp.dataops.engine.DataOpsEngine;
import com.yisutech.iisp.dataops.engine.adapter.dtsource.MysqlDataSource;
import com.yisutech.iisp.dataops.engine.template.impl.MysqlOpsTemplateImpl;
import com.yisutech.iisp.toolkit.utils.SpringHelper;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.dataops.engine.adapter.impl.MysqlAdapter
 * 描述：
 * <p>
 * MySql适配器
 *
 * @author guangzhong.wgz
 * @create 2018-03-26 上午11:04
 **/
@Component
public class MySqlAdapter implements DataOpsEngine.DataOpsSourceAdapter {

    @Resource
    private MysqlDataSource mysqlDataSource;

    @Override
    public DataOps build(DataOpsContext dataOpsContext) {

        // 根据参数构建数据源
        String dbUrl = mysqlDataSource.buildDataSource(dataOpsContext.getDataSourceConfig());
        Assert.notNull(dbUrl, "buildDataSource fail");

        DataOps dataOps;
        if ((dataOps = dataOpsMap.get(dbUrl)) != null) {
            return dataOps;
        }
        dataOps = new MysqlOpsTemplateImpl(mysqlDataSource.getDataSource(dbUrl));
        dataOpsMap.putIfAbsent(dbUrl, dataOps);
        return dataOps;
    }

    @Override
    public DataOps getDataOps(DataOpsContext dataOpsContext) {

        DataSource dataSource = SpringHelper.getBean(DataSource.class);
        Assert.notNull(dataSource, "dataSource is null");

        // 保证只初始化一次
        if (comp.compareAndSet(Boolean.TRUE, Boolean.FALSE)) {
            dataOpsMap.putIfAbsent(dataOpsContext.getDataOpsType().name(), new MysqlOpsTemplateImpl(dataSource));
        }

        return dataOpsMap.get(dataOpsContext.getDataOpsType().name());
    }

    public DataOpsContext.DataOpsType getDataOpsType() {
        return DataOpsContext.DataOpsType.MYSQL;
    }

    /**
     * mysql操作模板实现
     */
    private Map<String, DataOps> dataOpsMap = Maps.newConcurrentMap();
    /**
     * case开关
     */
    private AtomicBoolean comp = new AtomicBoolean(Boolean.TRUE);
}

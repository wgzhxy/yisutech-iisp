package com.yisutech.iisp.dataops.engine.adapter.impl;

import com.yisutech.iisp.dataops.engine.DataOpsEngine;
import com.yisutech.iisp.dataops.engine.template.DataOpsTemplate;
import com.yisutech.iisp.dataops.engine.template.impl.MysqlOpsTemplateImpl;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.dataops.engine.adapter.impl.MysqlAdapter
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-03-26 上午11:04
 **/
@Component
public class MysqlAdapter implements DataOpsEngine.DataOpsSourceAdapter {

    @Override
    public DataOpsTemplate getDataOps() {
        Assert.notNull(dataSource, "dataSource is null");
        // 保证只初始化一次
        if (mysqlOpsTemplate == null
                && comp.compareAndSet(Boolean.TRUE, Boolean.FALSE)) {
            mysqlOpsTemplate = new MysqlOpsTemplateImpl(dataSource);
        }
        return mysqlOpsTemplate;
    }

    public DataOpsEngine.DataOpsTplType getDataOpsTplType() {
        return DataOpsEngine.DataOpsTplType.MYSQL;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 数据原对象
     */
    private DataSource dataSource;
    /**
     * mysql操作模板实现
     */
    private MysqlOpsTemplateImpl mysqlOpsTemplate;
    /**
     * case开关
     */
    private AtomicBoolean comp = new AtomicBoolean(Boolean.TRUE);
}

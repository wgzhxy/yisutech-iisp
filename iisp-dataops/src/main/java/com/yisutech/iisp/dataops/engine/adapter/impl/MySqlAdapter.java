package com.yisutech.iisp.dataops.engine.adapter.impl;

import com.yisutech.iisp.dataops.engine.DataOpsEngine;
import com.yisutech.iisp.dataops.engine.adapter.DataOpsSource;
import com.yisutech.iisp.dataops.engine.template.DataOpsTemplate;
import com.yisutech.iisp.dataops.engine.template.impl.MysqlOpsTemplateImpl;
import com.yisutech.iisp.toolkit.utils.SpringHelper;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.sql.DataSource;
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

    @Override
    public void initDataSource(DataOpsSource dtSource) {
        throw new RuntimeException("not support!");
    }

    @Override
    public DataOpsTemplate getDataOps() {

        DataSource dataSource = SpringHelper.getBean(DataSource.class);
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

    private DataOpsSource dtSource;
    /**
     * mysql操作模板实现
     */
    private MysqlOpsTemplateImpl mysqlOpsTemplate;
    /**
     * case开关
     */
    private AtomicBoolean comp = new AtomicBoolean(Boolean.TRUE);
}

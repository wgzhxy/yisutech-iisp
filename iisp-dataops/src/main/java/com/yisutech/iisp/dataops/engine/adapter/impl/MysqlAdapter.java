package com.yisutech.iisp.dataops.engine.adapter.impl;

import com.yisutech.iisp.dataops.engine.DataOpsEngine;
import com.yisutech.iisp.dataops.engine.DtSource;
import com.yisutech.iisp.dataops.engine.dtsource.MysqlDataSource;
import com.yisutech.iisp.dataops.engine.template.DataOpsTemplate;
import com.yisutech.iisp.dataops.engine.template.impl.MysqlOpsTemplateImpl;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

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
    public void initDataSource(DtSource dtSource) {
        Assert.notNull(dtSource, "DtSource is null");
        this.dtSource = dtSource;
    }

    @Override
    public DataOpsTemplate getDataOps() {
        Assert.notNull(dtSource, "dataSource is null");
        // 保证只初始化一次
        if (mysqlOpsTemplate == null
                && comp.compareAndSet(Boolean.TRUE, Boolean.FALSE)) {
            mysqlOpsTemplate = new MysqlOpsTemplateImpl(((MysqlDataSource) dtSource).getDataSource());
        }
        return mysqlOpsTemplate;
    }

    public DataOpsEngine.DataOpsTplType getDataOpsTplType() {
        return DataOpsEngine.DataOpsTplType.MYSQL;
    }

    private DtSource dtSource;
    /**
     * mysql操作模板实现
     */
    private MysqlOpsTemplateImpl mysqlOpsTemplate;
    /**
     * case开关
     */
    private AtomicBoolean comp = new AtomicBoolean(Boolean.TRUE);
}

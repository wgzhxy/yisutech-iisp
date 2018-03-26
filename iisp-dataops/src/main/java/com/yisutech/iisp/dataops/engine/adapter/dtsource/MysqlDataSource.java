package com.yisutech.iisp.dataops.engine.adapter.dtsource;

import com.yisutech.iisp.dataops.engine.adapter.DataOpsSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.dataops.engine.adapter.dtsource.MysqlDataSource
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-03-26 上午11:52
 **/
@Component
public class MysqlDataSource implements DataOpsSource {

    /**
     * 数据源
     */
    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}

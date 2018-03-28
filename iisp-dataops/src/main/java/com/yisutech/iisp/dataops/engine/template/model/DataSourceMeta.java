package com.yisutech.iisp.dataops.engine.template.model;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.dataops.engine.template.model.DataSourceMeta
 * 描述：
 * 数据源元信息
 *
 * @author guangzhong.wgz
 * @create 2018-03-28 下午8:31
 **/
public class DataSourceMeta {

    /**
     * 数据源配置信息
     */
    String dataSourceConfig;
    /**
     * 数据源类型
     */
    DataOpsType dataOpsType;

    public String getDataSourceConfig() {
        return dataSourceConfig;
    }

    public void setDataSourceConfig(String dataSourceConfig) {
        this.dataSourceConfig = dataSourceConfig;
    }

    public DataOpsType getDataOpsType() {
        return dataOpsType;
    }

    public void setDataOpsType(DataOpsType dataOpsType) {
        this.dataOpsType = dataOpsType;
    }

    public enum DataOpsType {
        MYSQL, REDIS, MONGODB;
    }
}

package com.yisutech.iisp.dataops.engine;

import com.yisutech.iisp.dataops.engine.template.model.DataSourceMeta;

import java.io.Serializable;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.dataops.engine.DataOpsContext
 * 描述：
 * <p>
 * Engine上下文，提供必要参数，构建数据引擎操作模板
 *
 * @author guangzhong.wgz
 * @create 2018-03-26 下午2:52
 **/
public class DataOpsContext implements Serializable {

    private static final long serialVersionUID = -9188557590042912955L;

    /**
     * 数据操作类型
     * {@link DataSourceMeta.DataOpsType}
     */
    private DataSourceMeta.DataOpsType dataOpsType;
    /**
     * 数据源配置参数
     */
    private String dataSourceConfig;

    public DataSourceMeta.DataOpsType getDataOpsType() {
        return dataOpsType;
    }

    public void setDataOpsType(DataSourceMeta.DataOpsType dataOpsType) {
        this.dataOpsType = dataOpsType;
    }

    public String getDataSourceConfig() {
        return dataSourceConfig;
    }

    public void setDataSourceConfig(String dataSourceConfig) {
        this.dataSourceConfig = dataSourceConfig;
    }
}

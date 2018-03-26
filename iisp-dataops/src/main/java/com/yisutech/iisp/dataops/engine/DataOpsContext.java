package com.yisutech.iisp.dataops.engine;

import lombok.Getter;
import lombok.Setter;

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
     * {@link DataOpsType}
     */
    @Getter
    @Setter
    private DataOpsType dataOpsType;

    /**
     * 数据源配置参数
     */
    @Getter
    @Setter
    private String dataSourceConfig;

    public DataOpsType getDataOpsType() {
        return dataOpsType;
    }

    public void setDataOpsType(DataOpsType dataOpsType) {
        this.dataOpsType = dataOpsType;
    }

    public String getDataSourceConfig() {
        return dataSourceConfig;
    }

    public void setDataSourceConfig(String dataSourceConfig) {
        this.dataSourceConfig = dataSourceConfig;
    }

    public enum DataOpsType {
        MYSQL, REDIS, MONGODB;
    }


}

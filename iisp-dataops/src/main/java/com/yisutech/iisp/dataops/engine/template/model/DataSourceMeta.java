package com.yisutech.iisp.dataops.engine.template.model;

import com.yisutech.iisp.toolkit.utils.ValidUtil;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Map;

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
    @NotEmpty
    String dataSourceConfig;
    /**
     * 数据源类型
     */
    @NotNull
    DataOpsType dataOpsType;

    /**
     * 验证对象是否有效
     */
    public Map<String, String> valid() {
        return ValidUtil.allValid(this);
    }

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

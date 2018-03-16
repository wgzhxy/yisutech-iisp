package com.yisutech.iisp.toolkit.data_source;

/**
 * @author guangzhong.wgz
 */
public enum DataSourceEnum {

    PROFIT_DATA_SOURCE("mysqlDataSource");

    private String source;

    DataSourceEnum(String source) {
        this.source = source;
    }

    public String source() {
        return this.source;
    }
}

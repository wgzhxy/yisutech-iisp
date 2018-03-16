package com.yisutech.iisp.toolkit.data_source;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author guangzhong.wgz
 */
public class MultiDataSource extends AbstractRoutingDataSource {

    private static ThreadLocal<String> dataSourceKey = new ThreadLocal<>();

    public static void setDataSourceKey(String dataSource) {
        dataSourceKey.set(dataSource);
    }

    public static void remove() {
        dataSourceKey.remove();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return dataSourceKey.get();
    }
}

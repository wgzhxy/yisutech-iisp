package com.yisutech.iisp.dataops.engine.adapter.dtsource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.yisutech.iisp.dataops.engine.adapter.DataOpsSource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.util.Map;

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

    public DataSource getDataSource(String dbUrl) {
        return dataSourceMap.get(dbUrl);
    }

    @Override
    public String buildDataSource(String config) {
        try {

            // 数据源配置信息
            Assert.isTrue(StringUtils.isNotBlank(config), "config is empty");

            DataSourceConfig dataSourceConfig = JSON.parseObject(config, DataSourceConfig.class);
            Assert.notNull(dataSourceConfig, String.format("dataSourceConfig is null"));

            String dbUrl = dataSourceConfig.getDbUrl();
            Assert.isTrue(StringUtils.isNotBlank(dbUrl), "dbUrl is empty");

            // dbUrl映射数据源已存在, 返回
            if (dataSourceMap.get(dbUrl) != null) {
                return dbUrl;
            }

            // 生成新数据源
            DruidDataSource datasource = new DruidDataSource();

            datasource.setName(dataSourceConfig.getName());
            datasource.setUrl(dbUrl);
            datasource.setUsername(dataSourceConfig.getUsername());
            datasource.setPassword(dataSourceConfig.getPassword());
            datasource.setDriverClassName(dataSourceConfig.getDriverClassName());

            //configuration
            datasource.setInitialSize(dataSourceConfig.getInitialSize());
            datasource.setMinIdle(dataSourceConfig.getMinIdle());
            datasource.setMaxActive(dataSourceConfig.getMaxActive());
            datasource.setMaxWait(dataSourceConfig.getMaxWait());
            datasource.setTimeBetweenEvictionRunsMillis(dataSourceConfig.getTimeBetweenEvictionRunsMillis());
            datasource.setMinEvictableIdleTimeMillis(dataSourceConfig.getMinEvictableIdleTimeMillis());
            datasource.setValidationQuery(dataSourceConfig.getValidationQuery());
            datasource.setTestWhileIdle(dataSourceConfig.testWhileIdle);
            datasource.setTestOnBorrow(dataSourceConfig.testOnBorrow);
            datasource.setTestOnReturn(dataSourceConfig.testOnReturn);
            datasource.setPoolPreparedStatements(dataSourceConfig.poolPreparedStatements);
            datasource.setMaxPoolPreparedStatementPerConnectionSize(dataSourceConfig.getMaxPoolPreparedStatementPerConnectionSize());
            datasource.setUseGlobalDataSourceStat(dataSourceConfig.useGlobalDataSourceStat);
            datasource.setFilters(dataSourceConfig.getFilters());
            datasource.setConnectionProperties(dataSourceConfig.getConnectionProperties());

            dataSourceMap.putIfAbsent(datasource.getUrl(), datasource);
            return datasource.getUrl();

        } catch (Throwable e) {
            throw new RuntimeException(e.getCause());
        }

    }

    /**
     * 数据源
     */
    private Map<String, DataSource> dataSourceMap = Maps.newConcurrentMap();
}

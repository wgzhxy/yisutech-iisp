package com.yisutech.iisp.dataops.engine.adapter.dtsource;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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

            Assert.isTrue(StringUtils.isNotBlank(config), "config is empty");

            // 数据源配置信息
            JSONObject dbConf = JSON.parseObject(config);
            String dbUrl = dbConf.getString("dbUrl");
            Assert.isTrue(StringUtils.isNotBlank(dbUrl), "dbUrl is empty");

            // dbUrl映射数据源已存在, 返回
            if (dataSourceMap.get(dbUrl) != null) {
                return dbUrl;
            }

            // 生成新数据源
            DruidDataSource datasource = new DruidDataSource();

            datasource.setUrl(dbConf.getString("dbUrl"));
            datasource.setUsername(dbConf.getString("username"));
            datasource.setPassword(dbConf.getString("password)"));
            datasource.setDriverClassName(dbConf.getString("driverClassName"));

            //configuration
            datasource.setInitialSize(dbConf.getInteger("initialSize"));
            datasource.setMinIdle(dbConf.getInteger("minIdle"));
            datasource.setMaxActive(dbConf.getInteger("maxActive"));
            datasource.setMaxWait(dbConf.getInteger("maxWait"));
            datasource.setTimeBetweenEvictionRunsMillis(dbConf.getInteger("timeBetweenEvictionRunsMillis"));
            datasource.setMinEvictableIdleTimeMillis(dbConf.getInteger("minEvictableIdleTimeMillis)"));
            datasource.setValidationQuery(dbConf.getString("validationQuery"));
            datasource.setTestWhileIdle(dbConf.getBoolean("testWhileIdle"));
            datasource.setTestOnBorrow(dbConf.getBoolean("testOnBorrow"));
            datasource.setTestOnReturn(dbConf.getBoolean("testOnReturn"));
            datasource.setPoolPreparedStatements(dbConf.getBoolean("poolPreparedStatements"));
            datasource.setMaxPoolPreparedStatementPerConnectionSize(dbConf.getInteger("maxPoolPreparedStatementPerConnectionSize)"));
            datasource.setUseGlobalDataSourceStat(dbConf.getBoolean("useGlobalDataSourceStat"));
            datasource.setFilters(dbConf.getString("filters"));
            datasource.setConnectionProperties(dbConf.getString("connectionProperties"));
            dataSourceMap.putIfAbsent(datasource.getUrl(), datasource);

            return datasource.getUrl();

        } catch (Throwable e) {
            e.printStackTrace();
            throw new RuntimeException(e.getCause());
        }

    }

    /**
     * 数据源
     */
    private Map<String, DataSource> dataSourceMap = Maps.newConcurrentMap();
}

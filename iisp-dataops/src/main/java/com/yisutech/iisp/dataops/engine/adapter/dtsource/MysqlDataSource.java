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

    @Override
    public void createDataSource() {
        /**try {
         DruidDataSource datasource = new DruidDataSource();
         datasource.setUrl(this.dbUrl);
         datasource.setUsername(username);
         datasource.setPassword(password);
         datasource.setDriverClassName(driverClassName);

         //configuration
         datasource.setInitialSize(initialSize);
         datasource.setMinIdle(minIdle);
         datasource.setMaxActive(maxActive);
         datasource.setMaxWait(maxWait);
         datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
         datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
         datasource.setValidationQuery(validationQuery);
         datasource.setTestWhileIdle(testWhileIdle);
         datasource.setTestOnBorrow(testOnBorrow);
         datasource.setTestOnReturn(testOnReturn);
         datasource.setPoolPreparedStatements(poolPreparedStatements);
         datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
         datasource.setUseGlobalDataSourceStat(useGlobalDataSourceStat);
         try {
         datasource.setFilters(filters);
         } catch (SQLException e) {
         System.err.println("druid configuration initialization filter: " + e);
         }
         datasource.setConnectionProperties(connectionProperties);
         this.dataSource = datasource;
         } catch (Throwable e) {
         e.printStackTrace();
         throw e;
         }
         **/
    }
}

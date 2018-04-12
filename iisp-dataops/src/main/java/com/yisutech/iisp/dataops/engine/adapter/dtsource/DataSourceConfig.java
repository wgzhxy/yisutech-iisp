package com.yisutech.iisp.dataops.engine.adapter.dtsource;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.dataops.engine.adapter.dtsource.DataSourceConfig
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-04-12 下午2:08
 **/
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class DataSourceConfig {
    /**
     * 数据源名称
     */
    String name;
    /**
     * 连接数据库的url
     */
    String dbUrl;
    /**
     * 连接数据库的用户名
     */
    String username;
    /**
     * 连接数据库的密码
     */
    String password;
    /**
     * 数据库驱动类名称
     */
    String driverClassName = "com.mysql.jdbc.Driver";
    /**
     * 初始化时建立物理连接的个数
     */
    int initialSize = 5;
    /**
     * 最小连接池数量
     */
    int minIdle = 5;
    /**
     * 最大连接池数量
     */
    int maxActive = 20;
    /**
     * 获取连接时最大等待时间，单位毫秒
     */
    int maxWait = 60000;
    /**
     * 60秒运行一次空闲连接回收器
     */
    int timeBetweenEvictionRunsMillis = 60000;
    /**
     * 池中的连接空闲5分钟后被回收
     */
    int minEvictableIdleTimeMillis = 300000;
    /**
     * 用来检测连接是否有效的sql，要求是一个查询语句
     */
    String validationQuery = "SELECT 1 FROM DUAL";
    /**
     * 建议配置为true，不影响性能，并且保证安全性
     */
    boolean testWhileIdle = true;
    /**
     * 申请连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能
     */
    boolean testOnBorrow = false;
    /**
     * 归还连接时执行validationQuery检测连接是否有效，做了这个配置会降低性能
     */
    boolean testOnReturn = false;
    /**
     * 是否缓存preparedStatement，也就是PSCache。
     * PSCache对支持游标的数据库性能提升巨大，比如说oracle。
     * 在mysql5.5以下的版本中没有PSCache功能，建议关闭掉。
     * 作者在5.5版本中使用PSCache，通过监控界面发现PSCache有缓存命中率记录，
     * 该应该是支持PSCache
     */
    boolean poolPreparedStatements = true;
    /**
     * 最大PoolPreparedStatementPerConnection
     */
    int maxPoolPreparedStatementPerConnectionSize = 20;
    /**
     * 全局统计开关
     */
    boolean useGlobalDataSourceStat = true;
    /**
     * 属性类型是字符串，通过别名的方式配置扩展插件，
     * 常用的插件有：
     * 监控统计用的filter:stat
     * 日志用的filter:log4j
     * 防御sql注入的filter:wall
     */
    String filters = "stat,wall,log4j";
    /**
     * 连拉属性
     */
    String connectionProperties = "druid.stat.mergeSql=true;druid.stat.slowSqlMillis=500";

}

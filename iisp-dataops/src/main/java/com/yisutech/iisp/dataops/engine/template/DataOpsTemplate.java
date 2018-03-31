package com.yisutech.iisp.dataops.engine.template;

import com.yisutech.iisp.dataops.engine.DataOps;
import com.yisutech.iisp.dataops.engine.template.model.ColumnMeta;
import com.yisutech.iisp.dataops.engine.template.model.TableMeta;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;
import java.util.Map;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.dataops.engine.template.DataOpsTemplate
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-03-23 下午4:48
 **/
public interface DataOpsTemplate extends DataOps {

    /**
     * 创建表
     *
     * @param tableMeta {@link TableMeta}
     * @return true, 成功; false, 失败
     */
    boolean createTable(TableMeta tableMeta);

    /**
     * 删除表
     *
     * @param tableMeta {@link TableMeta}
     * @return true, 成功; false, 失败
     */
    boolean dropTable(TableMeta tableMeta);

    /**
     * 变更新
     *
     * @param tableMeta {@link TableMeta}
     * @return true, 成功; false, 失败
     */
    boolean alterTable(TableMeta tableMeta, Map<String, ColumnMeta> columnMetas, ColumnMeta.ColumnOps columnOps);

    /**
     * 查询表
     *
     * @param tableMeta {@link TableMeta}
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> query(TableMeta tableMeta, Map<String, ColumnMeta> whereColumns);

    /**
     * 查询表
     *
     * @param tableMeta {@link TableMeta}
     * @param offset    开始记录
     * @param size      记录数
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> query(TableMeta tableMeta, Map<String, ColumnMeta> whereColumns, int offset, int size);

    /**
     * 查询表
     *
     * @param sqlTemplate sql模板(freemarker模板)
     * @param values      Map<String, Object> 模板内动态变量
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> query(String sqlTemplate, List<Pair<String, Object>> values);

    /**
     * 查询表
     *
     * @param sqlTemplate sql模板(freemarker模板)
     * @param values      Map<String, Object> 模板内动态变量
     * @param offset      记录开始位置
     * @param size        记录数
     * @return List<Map<String, Object>>
     */
    List<Map<String, Object>> query(String sqlTemplate, List<Pair<String, Object>> values, int offset, int
            size);

    /**
     * 写入记录
     *
     * @param tableMeta 表元信息
     * @param values    值集合
     * @return 主键ID
     */
    int insert(TableMeta tableMeta, List<Pair<String, Object>> values);

    /**
     * 写入记录
     *
     * @param sqlTemplate sql模板(freemarker)
     * @param values      值集合
     * @return 主键ID
     */
    int insert(String sqlTemplate, List<Pair<String, Object>> values);

    /**
     * 批量写入记录
     *
     * @param sqlTemplate sql模板
     * @param values      值集合
     * @return 主键集合
     */
    int[] batchInsert(String sqlTemplate, List<List<Pair<String, Object>>> values);

    /**
     * 更新记录
     *
     * @param tableMeta 表元信息
     * @param values    值集合
     * @return 记录数
     */
    int update(TableMeta tableMeta, Map<String, ColumnMeta> whereColumns, List<Pair<String, Object>> values);

    /**
     * 更新记录
     *
     * @param sqlTemplate sql模板
     * @param values      值集合
     * @return 记录数
     */
    int update(String sqlTemplate, List<Pair<String, Object>> values);

    /**
     * 批量更新记录
     *
     * @param sqlTemplate sql模板
     * @param values      值集合
     * @return 记录数
     */
    int[] batchUpdate(String sqlTemplate, List<List<Pair<String, Object>>> values);

    /**
     * 批量删除记录
     *
     * @param sqlTemplate sql模板
     * @param values      值集合
     * @return 记录数
     */
    int delete(String sqlTemplate, List<Pair<String, Object>> values);

    /**
     * 批量删除记录
     *
     * @param tableMeta 表元信息
     * @param values    值集合
     * @return 记录数
     */
    int delete(TableMeta tableMeta, Map<String, ColumnMeta> whereColumns, List<Pair<String, Object>> values);

    /**
     * 获取事务
     */
    PlatformTransactionManager getTransactionManager();
}

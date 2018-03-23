package com.yisutech.iisp.dataops.engine;

import com.yisutech.iisp.dataops.engine.model.ColumnMeta;
import com.yisutech.iisp.dataops.engine.model.TableMeta;

import java.util.List;
import java.util.Map;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.dataops.engine.DataOpsTemplate
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-03-23 下午4:48
 **/
public interface DataOpsTemplate {

    /**
     * 创建表
     */
    boolean createTable(TableMeta tableMeta);

    /**
     * 删除表
     */
    boolean dropTable(TableMeta tableMeta);

    /**
     * 变更新
     */
    boolean alterTable(TableMeta tableMeta, Map<String, ColumnMeta> columnMetas);

    /**
     * 查询表
     *
     * @return
     */
    List<Map<String, Object>> query(List<TableMeta> tableMetas);

    /**
     * 查询表
     *
     * @return
     */
    List<Map<String, Object>> query(List<TableMeta> tableMetas, int offset, int size);

    /**
     * 查询表
     *
     * @return
     */
    List<Map<String, Object>> query(String sqlTemplate, Map<String, Object> values);

    /**
     * 查询表
     *
     * @return
     */
    List<Map<String, Object>> query(String sqlTemplate, Map<String, Object> values, int offset, int size);

    /**
     * 写入记录
     */
    int insert(TableMeta tableMeta, Map<String, Object> values);

    /**
     * 写入记录
     */
    int insert(String sqlTemplate, Map<String, Object> values);

    /**
     * 写入记录
     */
    List<Integer> batchInsert(String sqlTemplate, List<Map<String, Object>> values);

    /**
     * 更新记录
     */
    int update(TableMeta tableMeta, Map<String, Object> values);

    /**
     * 更新记录
     */
    int update(String sqlTemplate, Map<String, Object> values);

    /**
     * 更新记录
     */
    List<Integer> batchUpdate(String sqlTemplate, List<Map<String, Object>> values);
}

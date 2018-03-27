package com.yisutech.iisp.dataops.engine.template.model;

import com.yisutech.iisp.dataops.engine.template.SqlBuilder;
import com.yisutech.iisp.dataops.engine.template.SqlConstant;
import com.yisutech.iisp.toolkit.utils.ValidUtil;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.tuple.MutablePair;
import org.springframework.util.Assert;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Map;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.dataops.engine.template.model.TableMeta
 * <p>
 * 描述：
 * 数据表元信息
 *
 * @author guangzhong.wgz
 * @create 2018-03-23 下午4:26
 **/
public class TableMeta implements Serializable {

    private static final long serialVersionUID = -3736347964219313753L;

    /**
     * 表名
     */
    @Getter
    @Setter
    @NotEmpty(message = "表名不能为空")
    String tableName;
    /**
     * 表字段meta信息
     */
    @Getter
    @Setter
    @NotNull(message = "属性信息不能为空")
    Map<String, ColumnMeta> columnsMeta;

    /**
     * 获取查询全部表信息接口
     * ps :
     * select * from tableA;
     */
    public String getFullSelectSql(Map<String, ColumnMeta> whereColumns) {

        StringBuilder sql = new StringBuilder();
        sql.append(SqlConstant.SELECT_ALL).append(SqlConstant.BLANK).append(this.tableName);

        // 拼装条件
        if (whereColumns != null && whereColumns.size() > 0) {
            sql.append(SqlConstant.WHERE);
            whereColumns.forEach((k, v) -> {
                sql.append(v.columnName).append("=?").append(" and");
            });
            sql.setLength(sql.length() - 3);
        }

        return sql.toString();
    }

    /**
     * 获取查询全部表信息接口
     * ps :
     * select column1,column2...columnN from tableA;
     */
    public String getFullSelectSqlByColumns(Map<String, ColumnMeta> whereColumns) {

        // 参数检查
        Assert.notNull(tableName, "table is empty");
        Assert.notNull(columnsMeta, "columnsMeta is null");

        // 组装sql
        StringBuilder sql = new StringBuilder();
        SqlBuilder.builderSelect(sql, this.tableName, this.columnsMeta);

        // 拼装条件
        SqlBuilder.builderWhere(sql, whereColumns);

        return sql.toString();
    }

    /**
     * 获取查询全部表信息接口
     * ps :
     * select column1,column2...columnN from tableA;
     */
    public String getSelectSqlByColumns(Map<String, ColumnMeta> columnMetas, Map<String, ColumnMeta> whereColumns) {

        // 参数检查
        Assert.notNull(tableName, "table is empty");
        Assert.notNull(columnMetas, "columnMetas is null");

        // 拼装sql
        StringBuilder sql = new StringBuilder();
        SqlBuilder.builderSelect(sql, this.tableName, columnMetas);

        // 拼装条件
        SqlBuilder.builderWhere(sql, whereColumns);

        return sql.toString();
    }

    /**
     * 全属性插入sql语句
     * <p>
     * ps:
     * insert into tableB(column1,column2, column3, column4 ...) value(value1, value2, value3, value4 ...)
     */
    public String getFullInsertSql() {

        // 参数检查
        Assert.notNull(tableName, "table is empty");
        Assert.notNull(columnsMeta, "columnMetas is null");

        // 拼装sql
        StringBuilder sql = new StringBuilder();
        SqlBuilder.builderInsert(sql, this.tableName, this.columnsMeta);

        return sql.toString();
    }

    /**
     * 全属性插入sql语句
     * <p>
     * ps:
     * insert into tableB(column1,column2, column3, column4 ...) value(value1, value2, value3, value4 ...)
     */
    public String getInsertSqlByColumns(Map<String, ColumnMeta> columnMetas) {

        // 参数检查
        Assert.notNull(tableName, "table is empty");
        Assert.notNull(columnMetas, "columnMetas is null");

        // 拼装sql
        StringBuilder sql = new StringBuilder();
        SqlBuilder.builderInsert(sql, this.tableName, columnMetas);

        return sql.toString();
    }

    /**
     * 全属性更新语句
     * ps :
     * update table1 set
     */
    public String getFullUpdateSql() {

        // 参数检查
        Assert.notNull(tableName, "table is empty");
        Assert.notNull(columnsMeta, "columnsMeta is null");

        // 组装sql
        StringBuilder sql = new StringBuilder();
        SqlBuilder.builderUpdate(sql, this.tableName, this.columnsMeta);

        // 拼装条件
        sql.append(SqlConstant.WHERE)
                .append(columnsMeta.get("id").columnName)
                .append(" = ")
                .append(" ? ");

        return sql.toString();
    }

    /**
     * 全属性更新语句
     * ps :
     * update table1 set column1=?, clumn2=?... where id=?
     */
    public String getUpdateSqlByColumns(Map<String, ColumnMeta> updateColumns, Map<String, ColumnMeta> whereColumns) {

        // 参数检查
        Assert.notNull(tableName, "table is empty");
        Assert.notNull(updateColumns, "updateColumns is null");

        // 组装sql
        StringBuilder sql = new StringBuilder();
        SqlBuilder.builderUpdate(sql, this.tableName, updateColumns);

        // 拼装条件
        SqlBuilder.builderWhere(sql, whereColumns);

        return sql.toString();
    }

    public String getDeleteSql(Map<String, ColumnMeta> whereColumns) {

        // 参数检查
        Assert.notNull(tableName, "table is empty");
        Assert.notNull(whereColumns, "whereColumns is null");

        // 组装sql
        StringBuilder sql = new StringBuilder();
        SqlBuilder.builderDelete(sql, this.tableName);

        // 拼装条件
        SqlBuilder.builderWhere(sql, whereColumns);

        return sql.toString();
    }

    public boolean valid() {
        MutablePair pair = ValidUtil.fastValid(this);
        if (pair == null) {
            return true;
        } else {
            return false;
        }
    }
}

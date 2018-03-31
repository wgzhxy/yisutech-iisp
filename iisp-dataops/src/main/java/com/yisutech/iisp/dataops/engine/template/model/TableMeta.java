package com.yisutech.iisp.dataops.engine.template.model;

import com.yisutech.iisp.dataops.engine.template.SqlBuilder;
import com.yisutech.iisp.dataops.engine.template.SqlConstant;
import com.yisutech.iisp.toolkit.utils.ValidUtil;
import org.apache.commons.lang3.StringUtils;
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
    @NotEmpty(message = "表名不能为空")
    String tableName;
    /**
     * 数据源信息
     */
    DataSourceMeta dataSourceMeta;
    /**
     * 表字段meta信息
     */
    @NotNull(message = "属性信息不能为空")
    Map<String, ColumnMeta> columnsMeta;

    /**
     * 变更表sql语句
     */
    public String getAlterTableSql(Map<String, ColumnMeta> columnsMetas, ColumnMeta.ColumnOps columnOps) {

        Assert.notNull(columnsMetas, "columnsMetas is null");
        Assert.notNull(columnOps, "columnOps is null");

        StringBuilder sql = new StringBuilder(); // ALTER TABLE table_name ADD column_name datatype
        columnsMetas.forEach((k, v) -> {

            Assert.isTrue(v.valid(), "columnMeta is null");

            if (ColumnMeta.ColumnOps.add == columnOps) {
                sql.append(SqlConstant.ALTER_TABLE)
                        .append(this.tableName).append(SqlConstant.BLANK)
                        .append(columnOps.name()).append(SqlConstant.BLANK)
                        .append(v.getColumnName()).append(SqlConstant.BLANK).append(v.getType());
                if (v.getSize() != 0) {
                    sql.append("(").append(v.getSize()).append(")");
                }
                sql.append(";");

            } else if (ColumnMeta.ColumnOps.drop == columnOps) {
                sql.append(SqlConstant.ALTER_TABLE)
                        .append(this.tableName).append(SqlConstant.BLANK)
                        .append(columnOps.name()).append(SqlConstant.BLANK)
                        .append(SqlConstant.COLUMN)
                        .append(v.getColumnName()).append(SqlConstant.BLANK)
                        .append(";");

            } else if (ColumnMeta.ColumnOps.alter == columnOps) {
                sql.append(SqlConstant.ALTER_TABLE)
                        .append(this.tableName).append(SqlConstant.BLANK)
                        .append(columnOps.name()).append(SqlConstant.BLANK)
                        .append(SqlConstant.COLUMN)
                        .append(v.getColumnName()).append(SqlConstant.BLANK)
                        .append(v.getType());
                if (v.getSize() != 0) {
                    sql.append("(").append(v.getSize()).append(")");
                }
                sql.append(";");

            }
        });
        return sql.toString();
    }

    /**
     * 删除表
     */
    public String getDropTableSql() {

        Assert.notNull(this.tableName, "columnMetaOne is null");

        StringBuilder sql = new StringBuilder(); // ALTER TABLE table_name ADD column_name datatype
        sql.append(SqlConstant.DROP_TABLE).append(this.tableName).append(";");

        return sql.toString();
    }

    /**
     * 表字段重命名
     */
    public String getRenameTableSql(ColumnMeta columnMetaOne, ColumnMeta columnMetaTwo) {

        Assert.notNull(columnMetaOne, "columnMetaOne is null");
        Assert.notNull(columnMetaTwo, "columnMetaTwo is null");

        StringBuilder sql = new StringBuilder(); // ALTER TABLE table_name ADD column_name datatype

        sql.append(SqlConstant.ALTER_TABLE)
                .append(this.tableName).append(SqlConstant.BLANK)
                .append(ColumnMeta.ColumnOps.rename.name()).append(SqlConstant.BLANK)
                .append(columnMetaOne.getColumnName()).append(" to ")
                .append(columnMetaTwo.getColumnName());

        return sql.toString();
    }

    /**
     * 拼装创建表sql语句
     */
    public String getCreateTableSql() {

        // 拼装表创建sql
        StringBuilder sql = new StringBuilder();
        sql.append(SqlConstant.CREATE_TABLE).append(SqlConstant.SPECIAL_CHAR).append(this.tableName).append(SqlConstant.SPECIAL_CHAR).append(" (");

        StringBuilder primaryKey = new StringBuilder();
        columnsMeta.forEach((k, v) -> {
            // 字段
            sql.append(SqlConstant.SPECIAL_CHAR).append(v.getColumnName()).append(SqlConstant.SPECIAL_CHAR).append(SqlConstant.BLANK);
            // 类型及长度
            sql.append(v.getType().getValue()).append("(").append(v.getSize()).append(")").append(SqlConstant.BLANK);
            // 约束
            if (v.isTagNull()) {
                sql.append("default null").append(SqlConstant.BLANK);
            } else {
                sql.append("not null").append(SqlConstant.BLANK);
            }
            if (v.isPrimaryKey()) {
                primaryKey.append(" primary key (")
                        .append(SqlConstant.SPECIAL_CHAR).append(v.getColumnName()).append(SqlConstant.SPECIAL_CHAR)
                        .append(")");
                sql.append("auto_increment").append(SqlConstant.BLANK);
            }
            // 注释
            if (StringUtils.isNotBlank(v.getComment())) {
                sql.append("comment").append(SqlConstant.BLANK)
                        .append(SqlConstant.S_QUOTATION).append(v.getComment()).append(SqlConstant.S_QUOTATION)
                        .append(",");
            }
            sql.append(",");
        });

        sql.append(primaryKey.toString());
        sql.append(")");
        sql.append(" DEFAULT CHARSET=utf8mb4");

        return sql.toString();
    }

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
                sql.append(v.columnName).append(" = ? ").append(" and ");
            });
            sql.setLength(sql.length() - 4);
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

    public DataSourceMeta getDataSourceMeta() {
        return dataSourceMeta;
    }

    public void setDataSourceMeta(DataSourceMeta dataSourceMeta) {
        this.dataSourceMeta = dataSourceMeta;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Map<String, ColumnMeta> getColumnsMeta() {
        return columnsMeta;
    }

    public void setColumnsMeta(Map<String, ColumnMeta> columnsMeta) {
        this.columnsMeta = columnsMeta;
    }
}

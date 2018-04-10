package com.yisutech.iisp.dataops.engine.template;

import com.google.common.collect.Lists;
import com.yisutech.iisp.dataops.engine.template.model.ColumnMeta;

import java.util.List;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.dataops.engine.template.SqlBuilder
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-03-27 上午10:55
 **/
public class SqlBuilder {

    public static void builderSelect(StringBuilder sql, String tableName, List<ColumnMeta> columnMetas) {

        // 拼装sql
        sql.append(SqlConstant.SELECT);

        // 拼装字段列表
        columnMetas.forEach(v -> {
            sql.append(v.getColumnName()).append(",");
        });
        sql.setLength(sql.length() - 1);

        sql.append(SqlConstant.BLANK).append(SqlConstant.FROM).append(tableName);
    }

    public static void builderInsert(StringBuilder sql, String tableName, List<ColumnMeta> columnMetas) {

        // 组装sql
        sql.append(SqlConstant.INSERT_INTO).append(tableName).append("(");

        // 拼装字段列表
        List<String> specialChars = Lists.newArrayList();
        columnMetas.forEach(v -> {
            if (v.isPrimaryKey()) {
                return;
            }
            sql.append(v.getColumnName()).append(",");
            specialChars.add("?");
        });

        sql.setLength(sql.length() - 1);
        sql.append(")").append(SqlConstant.BLANK);
        sql.append(SqlConstant.VALUE).append("(");

        // 占位符
        specialChars.forEach(special -> {
            sql.append(special).append(",");
        });
        sql.setLength(sql.length() - 1);
        sql.append(")");
    }


    public static void builderUpdate(StringBuilder sql, String tableName, List<ColumnMeta> updateColumns) {

        sql.append(SqlConstant.UPDATE).append(tableName).append(SqlConstant.BLANK).append(SqlConstant.SET);

        // 拼装字段列表
        updateColumns.forEach(v -> {
            if (v.isPrimaryKey()) {
                return;
            }
            sql.append(v.getColumnName()).append(" = ").append(" ? ").append(",");
        });
        sql.setLength(sql.length() - 1);
    }

    public static void builderDelete(StringBuilder sql, String tableName) {
        sql.append(SqlConstant.DELETE).append(SqlConstant.FROM).append(tableName);
    }

    public static void builderWhere(StringBuilder sql, List<ColumnMeta> whereColumns) {
        // 拼装条件
        if (whereColumns != null && whereColumns.size() > 0) {
            sql.append(SqlConstant.WHERE);
            whereColumns.forEach(v -> {
                sql.append(v.getColumnName()).append(" = ? ").append(" and ");
            });
            sql.setLength(sql.length() - 4);
        }
    }
}

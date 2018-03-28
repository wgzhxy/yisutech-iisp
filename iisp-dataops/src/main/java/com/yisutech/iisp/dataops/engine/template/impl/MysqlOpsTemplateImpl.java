package com.yisutech.iisp.dataops.engine.template.impl;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.hash.Hashing;
import com.yisutech.iisp.dataops.engine.template.DataOpsTemplate;
import com.yisutech.iisp.dataops.engine.template.model.ColumnMeta;
import com.yisutech.iisp.dataops.engine.template.model.TableMeta;
import com.yisutech.iisp.toolkit.freemarker.FmTemplateEngine;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.dataops.engine.template.impl.MysqlOpsTemplateImpl
 * 描述：
 * <p>
 * MySql 模板实现
 *
 * @author guangzhong.wgz
 * @create 2018-03-23 下午4:56
 **/
public class MysqlOpsTemplateImpl implements DataOpsTemplate {

    @Override
    public boolean createTable(TableMeta tableMeta) {
        String createTableSql = tableMeta.getCreateTableSql();
        jdbcTemplate.execute(createTableSql);
        return true;
    }

    @Override
    public boolean dropTable(TableMeta tableMeta) {
        String dropTableSql = tableMeta.getDropTableSql();
        jdbcTemplate.execute(dropTableSql);
        return true;
    }

    @Override
    public boolean alterTable(TableMeta tableMeta, Map<String, ColumnMeta> columnMetas, ColumnMeta.ColumnOps columnOps) {
        String alterTableSql = tableMeta.getAlterTableSql(columnMetas, columnOps);
        jdbcTemplate.execute(alterTableSql);
        return false;
    }

    @Override
    public List<Map<String, Object>> query(TableMeta tableMeta, Map<String, ColumnMeta> whereColumns) {
        Assert.notNull(tableMeta, "tableMeta is null");
        return jdbcTemplate.queryForList(tableMeta.getFullSelectSql(whereColumns));
    }

    @Override
    public List<Map<String, Object>> query(TableMeta tableMeta, Map<String, ColumnMeta> whereColumns, int offset, int size) {
        String sql = tableMeta.getFullSelectSql(whereColumns);
        sql += " limit ?, ?";
        return jdbcTemplate.queryForList(sql, offset, size);
    }

    @Override
    public List<Map<String, Object>> query(String sqlTemplate, List<Pair<String, Object>> values) {

        // 参数转换
        Map<String, Object> params = Maps.newHashMap();
        values.forEach(pair -> {
            params.putIfAbsent(pair.getKey(), pair.getValue());
        });

        // 生成sql语句
        String sql = FmTemplateEngine.process(md5(sqlTemplate), sqlTemplate, params);

        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public List<Map<String, Object>> query(String sqlTemplate, List<Pair<String, Object>> values, int offset, int size) {

        // 参数转换
        Map<String, Object> params = Maps.newHashMap();
        values.forEach(pair -> {
            params.putIfAbsent(pair.getKey(), pair.getValue());
        });

        // 生成sql语句
        String sql = FmTemplateEngine.process(md5(sqlTemplate), sqlTemplate, params);
        if (offset <= 0) {
            offset = 0;
        }
        if (size <= 0) {
            size = 10;
        }
        sql += " limit " + offset + ", " + size;
        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public int insert(TableMeta tableMeta, List<Pair<String, Object>> values) {

        String sqlTemplate = tableMeta.getFullInsertSql();
        return this.insert(sqlTemplate, values);
    }

    @Override
    public int insert(String sqlTemplate, List<Pair<String, Object>> values) {

        // 生成sql
        String sql = FmTemplateEngine.process(md5(sqlTemplate), sqlTemplate, null);

        // 生成主键
        KeyHolder keyHolder = new GeneratedKeyHolder();

        // 写入记录
        jdbcTemplate.update((conn) -> {
            final PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            initPreparedStatement(ps, values);
            return ps;
        }, keyHolder);

        return keyHolder.getKey().intValue();
    }

    @Override
    public int[] batchInsert(String sqlTemplate, List<List<Pair<String, Object>>> values) {

        // 生成sql
        String sql = FmTemplateEngine.process(md5(sqlTemplate), sqlTemplate, null);

        // 拼装参数
        List<Object[]> objects = Lists.newArrayList();
        values.forEach(objs -> {
            List<Object> tpArray = Lists.newArrayList();
            objs.forEach(pair -> {
                tpArray.add(pair.getValue());
            });
            objects.add(tpArray.toArray());
        });
        return jdbcTemplate.batchUpdate(sql, objects);
    }

    @Override
    public int update(TableMeta tableMeta, Map<String, ColumnMeta> whereColumns, List<Pair<String, Object>> values) {

        String sql = tableMeta.getUpdateSqlByColumns(tableMeta.getColumnsMeta(), whereColumns);
        return this.update(sql, values);
    }

    @Override
    public int update(String sqlTemplate, List<Pair<String, Object>> values) {

        // 生成sql
        String sql = FmTemplateEngine.process(md5(sqlTemplate), sqlTemplate, null);

        // 更新记录
        return jdbcTemplate.update((conn) -> {
            final PreparedStatement ps = conn.prepareStatement(sql, Statement.NO_GENERATED_KEYS);
            initPreparedStatement(ps, values);
            return ps;
        });
    }

    @Override
    public int[] batchUpdate(String sqlTemplate, List<List<Pair<String, Object>>> values) {

        // 生成sql
        String sql = FmTemplateEngine.process(md5(sqlTemplate), sqlTemplate, null);

        // 拼装参数
        List<Object[]> objects = Lists.newArrayList();
        values.forEach(value -> {
            List<Object> array = Lists.newArrayList();
            value.forEach(pair -> {
                array.add(pair.getValue());
            });
            objects.add(array.toArray());
        });
        return jdbcTemplate.batchUpdate(sql, objects);
    }

    @Override
    public int delete(String sqlTemplate, List<Pair<String, Object>> values) {

        // 生成sql
        String sql = FmTemplateEngine.process(md5(sqlTemplate), sqlTemplate, null);

        // 拼装参数
        List<Object> objects = Lists.newArrayList();

        values.forEach(pair -> {
            objects.add(pair.getValue());
        });

        // 更新记录
        return jdbcTemplate.update(sql, objects.toArray());
    }

    @Override
    public int delete(TableMeta tableMeta, Map<String, ColumnMeta> whereColumns, List<Pair<String, Object>> values) {
        String sql = tableMeta.getDeleteSql(whereColumns);
        return this.delete(sql, values);
    }

    public MysqlOpsTemplateImpl() {
        Assert.notNull(jdbcTemplate, "IllegalAccessException, jdbcTemplate is null");
    }

    public MysqlOpsTemplateImpl(DataSource dataSource) {
        Assert.notNull(dataSource, "dataSource is null");
        if (comp.compareAndSet(Boolean.FALSE, Boolean.TRUE)) {
            this.jdbcTemplate = new JdbcTemplate(dataSource);
        }
    }

    /**
     * md5方法
     *
     * @param cotnent
     * @return
     */
    private String md5(String cotnent) {
        return Hashing.md5().hashBytes(cotnent.getBytes(Charsets.UTF_8)).toString();
    }

    /**
     * 初始人ps参数
     *
     * @param ps
     * @param values
     */
    private void initPreparedStatement(PreparedStatement ps, List<Pair<String, Object>> values) {
        AtomicInteger index = new AtomicInteger(0);
        values.forEach(pair -> {
            try {
                Object v = pair.getValue();
                if (v instanceof String) {
                    ps.setString(index.incrementAndGet(), (String) v);

                } else if (v instanceof Integer) {
                    ps.setInt(index.incrementAndGet(), (Integer) v);

                } else if (v instanceof Array) {
                    ps.setArray(index.incrementAndGet(), (Array) v);

                } else if (v instanceof BigDecimal) {
                    ps.setBigDecimal(index.incrementAndGet(), (BigDecimal) v);

                } else if (v instanceof Blob) {
                    ps.setBlob(index.incrementAndGet(), (Blob) v);

                } else if (v instanceof Boolean) {
                    ps.setBoolean(index.incrementAndGet(), (Boolean) v);

                } else if (v instanceof Byte) {
                    ps.setByte(index.incrementAndGet(), (Byte) v);

                } else if (v instanceof byte[]) {
                    ps.setBytes(index.incrementAndGet(), (byte[]) v);

                } else if (v instanceof Clob) {
                    ps.setClob(index.incrementAndGet(), (Clob) v);

                } else if (v instanceof Date) {
                    ps.setDate(index.incrementAndGet(), (Date) v);

                } else if (v instanceof Double) {
                    ps.setDouble(index.incrementAndGet(), (Double) v);

                } else if (v instanceof Float) {
                    ps.setFloat(index.incrementAndGet(), (Float) v);

                } else if (v instanceof Time) {
                    ps.setTime(index.incrementAndGet(), (Time) v);

                } else if (v instanceof Timestamp) {
                    ps.setTimestamp(index.incrementAndGet(), (Timestamp) v);

                } else if (v instanceof Short) {
                    ps.setShort(index.incrementAndGet(), (Short) v);

                } else if (v instanceof Object) {
                    ps.setObject(index.incrementAndGet(), v);
                }
            } catch (Throwable e) {
                throw new RuntimeException(e.getCause());
            }
        });
    }

    private JdbcTemplate jdbcTemplate;
    private AtomicBoolean comp = new AtomicBoolean(Boolean.FALSE);
}

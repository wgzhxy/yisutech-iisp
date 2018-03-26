package com.yisutech.iisp.dataops.engine.template.impl;

import com.yisutech.iisp.dataops.engine.template.DataOpsTemplate;
import com.yisutech.iisp.dataops.engine.template.model.ColumnMeta;
import com.yisutech.iisp.dataops.engine.template.model.TableMeta;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

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

        return false;
    }

    @Override
    public boolean dropTable(TableMeta tableMeta) {
        return false;
    }

    @Override
    public boolean alterTable(TableMeta tableMeta, Map<String, ColumnMeta> columnMetas) {
        return false;
    }

    @Override
    public List<Map<String, Object>> query(List<TableMeta> tableMetas) {
        return null;
    }

    @Override
    public List<Map<String, Object>> query(List<TableMeta> tableMetas, int offset, int size) {
        return null;
    }

    @Override
    public List<Map<String, Object>> query(String sqlTemplate, Map<String, Object> values) {
        return jdbcTemplate.queryForList(sqlTemplate);
    }

    @Override
    public List<Map<String, Object>> query(String sqlTemplate, Map<String, Object> values, int offset, int size) {
        return null;
    }

    @Override
    public int insert(TableMeta tableMeta, Map<String, Object> values) {
        return 0;
    }

    @Override
    public int insert(String sqlTemplate, Map<String, Object> values) {
        return 0;
    }

    @Override
    public List<Integer> batchInsert(String sqlTemplate, List<Map<String, Object>> values) {
        return null;
    }

    @Override
    public int update(TableMeta tableMeta, Map<String, Object> values) {
        return 0;
    }

    @Override
    public int update(String sqlTemplate, Map<String, Object> values) {
        return 0;
    }

    @Override
    public List<Integer> batchUpdate(String sqlTemplate, List<Map<String, Object>> values) {
        return null;
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

    private JdbcTemplate jdbcTemplate;
    private AtomicBoolean comp = new AtomicBoolean(Boolean.FALSE);
}

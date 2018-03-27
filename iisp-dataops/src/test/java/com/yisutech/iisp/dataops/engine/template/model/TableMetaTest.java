package com.yisutech.iisp.dataops.engine.template.model;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.hash.Hashing;
import com.yisutech.iisp.dataops.StarterApplication;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StarterApplication.class)
public class TableMetaTest {

    private TableMeta tableMeta;

    @Before
    public void init() {
        tableMeta = new TableMeta();
        tableMeta.setTableName("ops_data_source");
        tableMeta.setColumnsMeta(Maps.newHashMap());

        List<String> columInfo = Lists.newArrayList();
        columInfo.add("id,true,11,false,Int");
        columInfo.add("ds_url,false,256,false,String");
        columInfo.add("ds_user,false,64,false,String");
        columInfo.add("ds_password,false,64,false,String");
        columInfo.add("ds_name,false,128,false,String");
        columInfo.add("ds_ext_param,false,512,false,String");
        columInfo.add("ds_desc,false,256,false,String");

        columInfo.forEach(colum -> {
            String[] tpArray = colum.split(",");
            ColumnMeta columnMeta = new ColumnMeta();
            columnMeta.setColumnName(tpArray[0]);
            columnMeta.setPrimaryKey(Boolean.valueOf(tpArray[1]));
            columnMeta.setSize(Integer.valueOf(tpArray[2]));
            columnMeta.setTagNull(Boolean.valueOf(tpArray[3]));
            columnMeta.setType(ColumnMeta.ColumnType.valueOf(tpArray[4]));
            tableMeta.getColumnsMeta().putIfAbsent(columnMeta.getColumnName(), columnMeta);
        });


    }

    @Test
    public void getFullSelectSql() throws Exception {
        String fullSql = tableMeta.getFullSelectSql(null);
        Assert.assertNotNull(fullSql);
    }

    @Test
    public void getFullSelectSqlByColumns() throws Exception {

        Map<String, ColumnMeta> whereColumns = getColumnMeta(2);
        String fullSql = tableMeta.getFullSelectSql(whereColumns);

        Assert.assertNotNull(fullSql);
    }

    @Test
    public void getSelectSqlByColumns() throws Exception {

        Map<String, ColumnMeta> columnMeta = getColumnMeta(1);
        Map<String, ColumnMeta> whereColumns = getColumnMeta(2);

        String fullSql = tableMeta.getSelectSqlByColumns(columnMeta, whereColumns);
        Assert.assertNotNull(fullSql);
    }

    @Test
    public void getFullInsertSql() throws Exception {
        String fullSql = tableMeta.getFullInsertSql();
        Assert.assertNotNull(fullSql);
    }

    @Test
    public void getInsertSqlByColumns() throws Exception {
        Map<String, ColumnMeta> columnMeta = getColumnMeta(1);
        String fullSql = tableMeta.getInsertSqlByColumns(columnMeta);
        Assert.assertNotNull(fullSql);
    }

    @Test
    public void getFullUpdateSql() throws Exception {
        String fullSql = tableMeta.getFullUpdateSql();
        Assert.assertNotNull(fullSql);
    }

    @Test
    public void getUpdateSqlByColumns() throws Exception {

        Map<String, ColumnMeta> columnMeta = getColumnMeta(1);
        Map<String, ColumnMeta> whereColumns = getColumnMeta(2);

        String fullSql = tableMeta.getUpdateSqlByColumns(columnMeta, whereColumns);
        Assert.assertNotNull(fullSql);
    }

    @Test
    public void getDeleteSql() throws Exception {
        Map<String, ColumnMeta> whereColumns = getColumnMeta(2);
        String deleteSql = tableMeta.getDeleteSql(whereColumns);
        Assert.assertNotNull(deleteSql);
    }

    @Test
    public void valid() throws Exception {
        boolean check = tableMeta.valid();
        Assert.assertTrue(check);
    }

    @Test
    public void valid_false() throws Exception {
        TableMeta tableMeta = new TableMeta();
        boolean check = tableMeta.valid();
        Assert.assertFalse(check);
    }

    private Map<String, ColumnMeta> getColumnMeta(final int bucket) {

        List<String> columInfo = Lists.newArrayList();
        columInfo.add("id,true,11,false,Int");
        columInfo.add("ds_url,false,256,false,String");
        columInfo.add("ds_user,false,64,false,String");
        columInfo.add("ds_password,false,64,false,String");
        columInfo.add("ds_name,false,128,false,String");
        columInfo.add("ds_ext_param,false,512,false,String");
        columInfo.add("ds_desc,false,256,false,String");

        Map<String, ColumnMeta> ret = Maps.newHashMap();
        columInfo.forEach(colum -> {
            String[] tpArray = colum.split(",");
            int hashCode = Math.abs(Hashing.md5().hashBytes(tpArray[0].getBytes()).asInt());
            if (hashCode % bucket == 0) {
                ColumnMeta columnMeta = new ColumnMeta();
                columnMeta.setColumnName(tpArray[0]);
                columnMeta.setPrimaryKey(Boolean.valueOf(tpArray[1]));
                columnMeta.setSize(Integer.valueOf(tpArray[2]));
                columnMeta.setTagNull(Boolean.valueOf(tpArray[3]));
                columnMeta.setType(ColumnMeta.ColumnType.valueOf(tpArray[4]));
                ret.putIfAbsent(columnMeta.getColumnName(), columnMeta);
            }
        });
        return ret;
    }
}
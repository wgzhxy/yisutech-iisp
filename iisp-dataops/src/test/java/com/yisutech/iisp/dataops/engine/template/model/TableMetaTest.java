package com.yisutech.iisp.dataops.engine.template.model;

import com.yisutech.iisp.dataops.StarterApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StarterApplication.class)
public class TableMetaTest {

    private TableMeta tableMeta;

    @Before
    public void init() {
        tableMeta = new TableMeta();
    }

    @Test
    public void getFullSelectSql() throws Exception {
        TableMeta tableMeta = new TableMeta();
    }

    @Test
    public void getFullSelectSqlByColumns() throws Exception {
    }

    @Test
    public void getSelectSqlByColumns() throws Exception {
    }

    @Test
    public void getFullInsertSql() throws Exception {
    }

    @Test
    public void getInsertSqlByColumns() throws Exception {
    }

    @Test
    public void getFullUpdateSql() throws Exception {
    }

    @Test
    public void getUpdateSqlByColumns() throws Exception {
    }

    @Test
    public void getDeleteSql() throws Exception {
    }

    @Test
    public void valid() throws Exception {
    }

}
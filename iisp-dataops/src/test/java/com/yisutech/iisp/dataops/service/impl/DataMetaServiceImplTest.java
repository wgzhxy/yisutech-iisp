package com.yisutech.iisp.dataops.service.impl;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.yisutech.iisp.dataops.StarterApplication;
import com.yisutech.iisp.dataops.config.DbConfigEnum;
import com.yisutech.iisp.dataops.engine.adapter.dtsource.DataSourceConfig;
import com.yisutech.iisp.dataops.engine.template.model.ColumnMeta;
import com.yisutech.iisp.dataops.engine.template.model.DataSourceMeta;
import com.yisutech.iisp.dataops.repository.pojo.OpsDataSource;
import com.yisutech.iisp.dataops.repository.pojo.OpsLogicTable;
import com.yisutech.iisp.dataops.repository.pojo.OpsTable;
import com.yisutech.iisp.dataops.repository.pojo.OpsTableColumn;
import com.yisutech.iisp.dataops.service.DataMetaService;
import com.yisutech.iisp.dataops.service.model.DataOpsResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StarterApplication.class)
public class DataMetaServiceImplTest {

    @Resource
    private DataMetaService dataMetaService;

    private final String dbUrl = "jdbc:mysql://localhost:3306/yisuyun_console?useUnicode=true&characterEncoding=UTF-8&useJDBCCompliantTimezoneShift" +
            "=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    @Test
    public void addDataSource() throws Exception {

        OpsDataSource opsDataSource = new OpsDataSource();
        opsDataSource.setDsName("test_10000");
        opsDataSource.setDsUser("root");
        opsDataSource.setDsPassword("wgzhxy119@");
        opsDataSource.setDsUrl("test:///");
        opsDataSource.setDsExtParam(JSON.toJSONString(new DataSourceConfig()));
        opsDataSource.setDsType(DataSourceMeta.DataOpsType.MYSQL.name());
        opsDataSource.setDsDesc("test_10000");

        DataOpsResponse<Integer> rsp = dataMetaService.addDataSource(opsDataSource);
        Assert.assertTrue(rsp.getModel() > 0);
    }

    @Test
    public void updateDataSource() throws Exception {

        OpsDataSource opsDataSource = new OpsDataSource();
        opsDataSource.setId(9);
        opsDataSource.setDsName("test_wgz");
        opsDataSource.setDsUser("root");
        opsDataSource.setDsPassword("wgzhxy119@");
        opsDataSource.setDsUrl(dbUrl);

        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbUrl(dbUrl);

        DataSourceConfig sourceConfig = new DataSourceConfig();
        sourceConfig.setDbUrl(dbUrl);
        sourceConfig.setName(opsDataSource.getDsName());
        sourceConfig.setUsername(opsDataSource.getDsUser());
        sourceConfig.setPassword(opsDataSource.getDsPassword());
        opsDataSource.setDsExtParam(JSON.toJSONString(sourceConfig));
        opsDataSource.setDsType(DataSourceMeta.DataOpsType.MYSQL.name());
        opsDataSource.setDsDesc("test_10000");

        DataOpsResponse<Boolean> rsp = dataMetaService.updateDataSource(opsDataSource);
        Assert.assertTrue(rsp.getModel());
    }

    @Test
    public void addTable() throws Exception {

        OpsTable opsTable = new OpsTable();
        opsTable.setTbName("ops_data_source");
        opsTable.setTbDesc("数据源表");

        List<OpsTableColumn> opsTableColumns = Lists.newArrayList();

        OpsTableColumn column = new OpsTableColumn();
        column.setFdName("id");
        column.setFdType(ColumnMeta.ColumnType.Int.getValue());
        column.setFdLength(11);
        column.setFdDesc("主键ID");
        column.setFdPrimaryKey(true);
        column.setFdTagNull(false);
        opsTableColumns.add(column);

        column = new OpsTableColumn();
        column.setFdName("ds_url");
        column.setFdType(ColumnMeta.ColumnType.String.getValue());
        column.setFdLength(256);
        column.setFdDesc("数据库访问url");
        column.setFdPrimaryKey(false);
        column.setFdTagNull(false);
        opsTableColumns.add(column);

        column = new OpsTableColumn();
        column.setFdName("ds_user");
        column.setFdType(ColumnMeta.ColumnType.String.getValue());
        column.setFdLength(64);
        column.setFdDesc("数据库用户名称");
        column.setFdPrimaryKey(false);
        column.setFdTagNull(false);
        opsTableColumns.add(column);

        column = new OpsTableColumn();
        column.setFdName("ds_password");
        column.setFdType(ColumnMeta.ColumnType.String.getValue());
        column.setFdLength(64);
        column.setFdDesc("数据库用户密码");
        column.setFdPrimaryKey(false);
        column.setFdTagNull(false);
        opsTableColumns.add(column);

        column = new OpsTableColumn();
        column.setFdName("ds_name");
        column.setFdType(ColumnMeta.ColumnType.String.getValue());
        column.setFdLength(128);
        column.setFdDesc("数据库名称");
        column.setFdPrimaryKey(false);
        column.setFdTagNull(false);
        opsTableColumns.add(column);

        column = new OpsTableColumn();
        column.setFdName("ds_ext_param");
        column.setFdType(ColumnMeta.ColumnType.Text.getValue());
        column.setFdDesc("数据源生成配置");
        column.setFdPrimaryKey(false);
        column.setFdTagNull(false);
        opsTableColumns.add(column);

        column = new OpsTableColumn();
        column.setFdName("ds_desc");
        column.setFdType(ColumnMeta.ColumnType.String.getValue());
        column.setFdLength(256);
        column.setFdDesc("表描述");
        column.setFdPrimaryKey(false);
        column.setFdTagNull(true);
        opsTableColumns.add(column);

        column = new OpsTableColumn();
        column.setFdName("ds_type");
        column.setFdType(ColumnMeta.ColumnType.String.getValue());
        column.setFdLength(10);
        column.setFdDesc("表类型");
        column.setFdPrimaryKey(false);
        column.setFdTagNull(false);
        opsTableColumns.add(column);

        DataOpsResponse<Integer> result = dataMetaService.addTable(opsTable, opsTableColumns);
        Assert.assertTrue(result.getModel() >= 1);
    }

    @Test
    public void updateTable() throws Exception {
        OpsTable opsTable = new OpsTable();
        opsTable.setId(2);
        opsTable.setTbDesc("数据源表");
        DataOpsResponse<Boolean> result = dataMetaService.updateTable(opsTable);
        Assert.assertTrue(result.getModel());
    }

    @Test
    public void updateTableColumn() throws Exception {

        List<OpsTableColumn> columns = Lists.newArrayList();

        OpsTableColumn column = new OpsTableColumn();
        column.setId(6);
        column.setFdTagNull(false);
        columns.add(column);

        column = new OpsTableColumn();
        column.setId(7);
        column.setFdTagNull(false);
        columns.add(column);

        column = new OpsTableColumn();
        column.setId(8);
        column.setFdTagNull(false);
        columns.add(column);

        column = new OpsTableColumn();
        column.setId(9);
        column.setFdTagNull(false);
        columns.add(column);

        column = new OpsTableColumn();
        column.setId(10);
        column.setFdTagNull(false);
        columns.add(column);

        column = new OpsTableColumn();
        column.setId(11);
        column.setFdTagNull(false);
        columns.add(column);

        column = new OpsTableColumn();
        column.setId(12);
        column.setFdTagNull(true);
        columns.add(column);

        column = new OpsTableColumn();
        column.setId(13);
        column.setFdTagNull(false);
        columns.add(column);

        columns.forEach(col -> {
            DataOpsResponse<Boolean> result = dataMetaService.updateTableColumn(col);
            Assert.assertTrue(result.getModel());
        });

    }

    @Test
    public void addLogicTable() throws Exception {

        OpsLogicTable opsLogicTable = new OpsLogicTable();
        opsLogicTable.setLtbSourceId(9);
        opsLogicTable.setLtbTables("test_data_source_query");
        opsLogicTable.setLtbSqlExpress("select * from ops_data_source");
        opsLogicTable.setLtbType(DbConfigEnum.TableType.LOGIC_TABLE.getValue());

        DataOpsResponse<String> dataOpsResponse = dataMetaService.addLogicTable(opsLogicTable);
        Assert.assertTrue(Integer.parseInt(dataOpsResponse.getModel()) >= 1);
    }

    @Test
    public void updateLogicTable() throws Exception {

        String logicTable = "test_data_source_query";

        OpsLogicTable opsLogicTable = new OpsLogicTable();
        opsLogicTable.setId(1);
        opsLogicTable.setLtbSourceId(9);
        opsLogicTable.setLtbTables(logicTable);
        opsLogicTable.setLtbSqlExpress("select * from ops_data_source where id = ? and ds_user = ?");
        opsLogicTable.setLtbType(2);

        DataOpsResponse<String> dataOpsResponse = dataMetaService.updateLogicTable(opsLogicTable);
        Assert.assertTrue(Integer.parseInt(dataOpsResponse.getModel()) >= 1);
    }

    @Test
    public void addLogicTableColumn() throws Exception {
    }

    @Test
    public void updateLogicTableColumn() throws Exception {
    }

    @Test
    public void deleteTable() throws Exception {
    }

    @Test
    public void deleteLogicTable() throws Exception {
    }

}
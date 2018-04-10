package com.yisutech.iisp.dataops.config.impl;

import com.google.common.collect.Lists;
import com.yisutech.iisp.dataops.config.ConfigEnum;
import com.yisutech.iisp.dataops.config.DataOpsConfigService;
import com.yisutech.iisp.dataops.engine.template.model.ColumnMeta;
import com.yisutech.iisp.dataops.engine.template.model.DataSourceMeta;
import com.yisutech.iisp.dataops.engine.template.model.TableMeta;
import com.yisutech.iisp.dataops.repository.TableConfigRepository;
import com.yisutech.iisp.dataops.repository.pojo.OpsDataSource;
import com.yisutech.iisp.dataops.repository.pojo.OpsLogicTable;
import com.yisutech.iisp.dataops.repository.pojo.OpsLogicTableColumn;
import com.yisutech.iisp.dataops.repository.pojo.OpsTable;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.dataops.config.impl.DataOpsConfigServiceImpl
 * 描述：
 * 数据操作基础配置服务
 *
 * @author guangzhong.wgz
 * @create 2018-03-28 下午7:38
 **/
@Service
public class DataOpsConfigServiceImpl implements DataOpsConfigService {

    @Resource
    private TableConfigRepository tableConfigRepository;

    @Override
    public TableMeta getTableMeta(String tableCode) {

        // 定义tableMeta
        TableMeta tableMeta;

        // 查逻辑表
        OpsLogicTable opsLogicTable = tableConfigRepository.queryLogicTable(tableCode);
        Assert.notNull(opsLogicTable, String.format("LogicTable is not exists"));

        if (ConfigEnum.LogicTableType.config.getValue() == opsLogicTable.getLtbType()) {

            tableMeta = new TableMeta();

            // 当前只支持单表操作，以后再考虑实验多表
            String tables = opsLogicTable.getLtbTables();
            Assert.isTrue(StringUtils.isNotBlank(tables), String.format("table is empty"));

            OpsTable opsTable = tableConfigRepository.queryTable(tables.split(",")[0]);
            tableMeta.setTableName(opsTable.getTbName());

            // dataSource 查询
            Assert.notNull(opsLogicTable.getLtbSourceId(), String.format("dataSource is empty"));
            OpsDataSource opsDataSource = tableConfigRepository.queryDataSource(String.valueOf(opsLogicTable.getLtbSourceId()));

            DataSourceMeta dataSourceMeta = new DataSourceMeta();
            dataSourceMeta.setDataOpsType(DataSourceMeta.DataOpsType.valueOf(opsDataSource.getDsType()));
            dataSourceMeta.setDataSourceConfig(opsDataSource.getDsExtParam());
            tableMeta.setDataSourceMeta(dataSourceMeta);

            // 查逻辑字段
            List<OpsLogicTableColumn> tbColumns = tableConfigRepository.queryLogicTableColumn(String.valueOf(opsTable.getId()));
            Assert.isTrue(!CollectionUtils.isEmpty(tbColumns), String.format("LogicTableColumn is null"));

            List<ColumnMeta> columnMap = Lists.newArrayList();
            tbColumns.forEach(tbColumn -> {
                ColumnMeta columnMeta = new ColumnMeta();
                columnMeta.setType(ColumnMeta.ColumnType.valueOf(tbColumn.getLfdType()));
                columnMeta.setSize(tbColumn.getLfdLength());
                columnMeta.setColumnName(tbColumn.getLfdName());
                columnMeta.setPrimaryKey(tbColumn.getLfdPrimaryKey());
                columnMeta.setDefaultValue(tbColumn.getLfdDefaultValue());
                columnMeta.setTagNull(tbColumn.getLfdTagNull());
                columnMap.add(columnMeta);
            });
            tableMeta.setColumnsMeta(columnMap);

        } else if (ConfigEnum.LogicTableType.config.getValue() == opsLogicTable.getLtbType()) {
            tableMeta = new TableMeta();
            tableMeta.setTableName(opsLogicTable.getLtbTables());
            tableMeta.setUdSql(opsLogicTable.getLtbSqlExpress());

        } else {
            throw new IllegalArgumentException(String.format("LogicTableType not support"));
        }
        return tableMeta;
    }
}

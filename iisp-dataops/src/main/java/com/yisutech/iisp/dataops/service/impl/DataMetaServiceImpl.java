package com.yisutech.iisp.dataops.service.impl;

import com.yisutech.iisp.dataops.repository.mapper.*;
import com.yisutech.iisp.dataops.repository.pojo.*;
import com.yisutech.iisp.dataops.service.DataMetaService;
import com.yisutech.iisp.dataops.service.model.DataOpsResponse;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.dataops.service.impl.DataMetaServiceImpl
 * <p>
 * 描述：
 * 基础元信息管理
 *
 * @author guangzhong.wgz
 * @create 2018-03-28 下午3:03
 **/
@Service
public class DataMetaServiceImpl implements DataMetaService {

    @Override
    public DataOpsResponse<Integer> addDataSource(OpsDataSource opsDataSource) {

        // 参数检查
        Assert.notNull(opsDataSource, String.format("opsDataSource is null"));

        Integer id = opsDataSourceMapper.insert(opsDataSource);

        DataOpsResponse<Integer> response = new DataOpsResponse<>();
        response.setModel(id);

        return response;
    }

    @Override
    public DataOpsResponse<Boolean> updateDataSource(OpsDataSource opsDataSource) {
        // 参数检查
        Assert.notNull(opsDataSource, String.format("opsDataSource is null"));

        opsDataSourceMapper.updateByPrimaryKeyWithBLOBs(opsDataSource);

        DataOpsResponse<Boolean> response = new DataOpsResponse<>();
        response.setModel(true);

        return response;
    }

    @Override
    public DataOpsResponse<Integer> addTable(OpsTable opsTable) {
        // 参数检查
        Assert.notNull(opsTable, String.format("opsTable is null"));

        Integer id = opsTableMapper.insert(opsTable);

        DataOpsResponse<Integer> response = new DataOpsResponse<>();
        response.setModel(id);

        return response;
    }

    @Override
    public DataOpsResponse<Boolean> updateTable(OpsTable opsTable) {
        // 参数检查
        Assert.notNull(opsTable, String.format("opsTable is null"));

        opsTableMapper.updateByPrimaryKey(opsTable);

        DataOpsResponse<Boolean> response = new DataOpsResponse<>();
        response.setModel(true);

        return response;
    }

    @Override
    public DataOpsResponse<Boolean> addTableColumn(List<OpsTableColumn> opsTableColumns) {
        // 参数检查
        Assert.notNull(opsTableColumns, String.format("opsTable is null"));

        opsTableColumns.forEach(opsTableColumn -> {
            opsTableColumnMapper.insert(opsTableColumn);
        });

        DataOpsResponse<Boolean> response = new DataOpsResponse<>();
        response.setModel(true);
        return response;
    }

    @Override
    public DataOpsResponse<Boolean> updateTableColumn(OpsTableColumn opsTableColumn) {
        // 参数检查
        Assert.notNull(opsTableColumn, String.format("opsTable is null"));

        opsTableColumnMapper.updateByPrimaryKeySelective(opsTableColumn);

        DataOpsResponse<Boolean> response = new DataOpsResponse<>();
        response.setModel(true);
        return response;
    }

    @Override
    public DataOpsResponse<String> addLogicTable(OpsLogicTable opsLogicTable) {
        // 参数检查
        Assert.notNull(opsLogicTable, String.format("opsTable is null"));

        Integer id = opsLogicTableMapper.insert(opsLogicTable);

        DataOpsResponse<String> response = new DataOpsResponse<>();
        response.setModel(id + "");

        return response;
    }

    @Override
    public DataOpsResponse<String> updateLogicTable(OpsLogicTable opsLogicTable) {
        // 参数检查
        Assert.notNull(opsLogicTable, String.format("opsTable is null"));

        Integer id = opsLogicTableMapper.updateByPrimaryKeySelective(opsLogicTable);

        DataOpsResponse<String> response = new DataOpsResponse<>();
        response.setModel(opsLogicTable.getId() + "");

        return response;
    }

    @Override
    public DataOpsResponse<Boolean> addLogicTableColumn(List<OpsLogicTableColumn> opsLogicTableColumns) {
        // 参数检查
        Assert.notNull(opsLogicTableColumns, String.format("opsLogicTableColumns is null"));

        opsLogicTableColumns.forEach(opsLogicTableColumn -> {
            opsLogicTableColumnMapper.insert(opsLogicTableColumn);
        });

        DataOpsResponse<Boolean> response = new DataOpsResponse<>();
        response.setModel(true);

        return response;
    }

    @Override
    public DataOpsResponse<Boolean> updateLogicTableColumn(OpsLogicTableColumn opsLogicTableColumn) {
        // 参数检查
        Assert.notNull(opsLogicTableColumn, String.format("opsLogicTableColumn is null"));

        opsLogicTableColumnMapper.updateByPrimaryKeySelective(opsLogicTableColumn);

        DataOpsResponse<Boolean> response = new DataOpsResponse<>();
        response.setModel(true);

        return response;
    }

    @Override
    public DataOpsResponse<Integer> deleteTable(String tableCode) {

        int count = opsTableMapper.deleteByPrimaryKey(Integer.valueOf(tableCode));

        if (count >= 0) {
            OpsTableColumnExample example = new OpsTableColumnExample();
            example.createCriteria().andTbIdEqualTo(Integer.valueOf(tableCode));
            opsTableColumnMapper.deleteByExample(example);
        }

        DataOpsResponse<Integer> response = new DataOpsResponse<>();
        response.setModel(1);

        return response;
    }

    @Override
    public DataOpsResponse<Boolean> deleteLogicTable(String tableCode) {

        int count = opsLogicTableMapper.deleteByPrimaryKey(Integer.valueOf(tableCode));

        if (count >= 0) {
            OpsLogicTableColumnExample example = new OpsLogicTableColumnExample();
            example.createCriteria().andLfdTbIdNotEqualTo(tableCode);
            opsLogicTableColumnMapper.deleteByExample(example);
        }

        DataOpsResponse<Boolean> response = new DataOpsResponse<>();
        response.setModel(true);

        return response;
    }


    @Resource
    private OpsTableMapper opsTableMapper;
    @Resource
    private OpsDataSourceMapper opsDataSourceMapper;
    @Resource
    private OpsLogicTableMapper opsLogicTableMapper;
    @Resource
    private OpsTableColumnMapper opsTableColumnMapper;
    @Resource
    private OpsLogicTableColumnMapper opsLogicTableColumnMapper;
}

package com.yisutech.iisp.dataops.service.impl;

import com.yisutech.iisp.dataops.repository.mapper.*;
import com.yisutech.iisp.dataops.repository.pojo.*;
import com.yisutech.iisp.dataops.service.DataMetaService;
import com.yisutech.iisp.dataops.service.model.DataOpsResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.dataops.service.impl.DataMetaServiceImpl
 * <p>
 * 描述：
 * <p>
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
        opsDataSourceMapper.insert(opsDataSource);

        DataOpsResponse<Integer> response = new DataOpsResponse<>();
        response.setModel(opsDataSource.getId());

        return response;
    }

    @Override
    public DataOpsResponse<Boolean> updateDataSource(OpsDataSource opsDataSource) {

        // 参数检查
        Assert.notNull(opsDataSource, String.format("opsDataSource is null"));
        int count = opsDataSourceMapper.updateByPrimaryKeyWithBLOBs(opsDataSource);

        DataOpsResponse<Boolean> response = new DataOpsResponse<>();
        response.setModel(count > 0 ? true : false);

        return response;
    }

    @Override
    @Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, timeout = 5000)
    public DataOpsResponse<Integer> addTable(OpsTable opsTable, List<OpsTableColumn> opsTableColumns) {

        // 参数检查
        Assert.notNull(opsTable, String.format("opsTable is null"));
        Assert.notNull(opsTableColumns, String.format("opsTableColumns is null"));

        // 创建表
        opsTable.setTbFiledsNum(opsTableColumns.size());
        int count = opsTableMapper.insert(opsTable);

        // 创建字段
        if (count > 0) {
            // 参数检查
            Assert.notNull(opsTableColumns, String.format("opsTable is null"));

            opsTableColumns.forEach(opsTableColumn -> {
                opsTableColumn.setTbId(opsTable.getId());
                int columCount = opsTableColumnMapper.insert(opsTableColumn);
                if (columCount <= 0) {
                    throw new RuntimeException("addTableColumn is null");
                }
            });
        }

        // 返回tableID
        DataOpsResponse<Integer> response = new DataOpsResponse<>();
        response.setModel(opsTable.getId());

        return response;
    }

    @Override
    public DataOpsResponse<Boolean> updateTable(OpsTable opsTable) {
        // 参数检查
        Assert.notNull(opsTable, String.format("opsTable is null"));
        int count = opsTableMapper.updateByPrimaryKeySelective(opsTable);

        DataOpsResponse<Boolean> response = new DataOpsResponse<>();
        response.setModel(count > 0 ? true : false);
        return response;
    }

    @Override
    public DataOpsResponse<Boolean> updateTableColumn(OpsTableColumn opsTableColumn) {

        // 参数检查
        Assert.notNull(opsTableColumn, String.format("opsTable is null"));
        int cout = opsTableColumnMapper.updateByPrimaryKeySelective(opsTableColumn);

        DataOpsResponse<Boolean> response = new DataOpsResponse<>();
        response.setModel(cout > 0 ? true : false);
        return response;
    }

    @Override
    public DataOpsResponse<String> addLogicTable(OpsLogicTable opsLogicTable) {
        // 参数检查
        Assert.notNull(opsLogicTable, String.format("opsTable is null"));
        opsLogicTableMapper.insert(opsLogicTable);

        DataOpsResponse<String> response = new DataOpsResponse<>();
        response.setModel(opsLogicTable.getId() + "");

        return response;
    }

    @Override
    public DataOpsResponse<String> updateLogicTable(OpsLogicTable opsLogicTable) {
        // 参数检查
        Assert.notNull(opsLogicTable, String.format("opsTable is null"));
        opsLogicTableMapper.updateByPrimaryKeySelective(opsLogicTable);

        DataOpsResponse<String> response = new DataOpsResponse<>();
        response.setModel(opsLogicTable.getId() + "");

        return response;
    }

    @Override
    @Transactional
    public DataOpsResponse<Boolean> addLogicTableColumn(List<OpsLogicTableColumn> opsLogicTableColumns) {
        // 参数检查
        Assert.notNull(opsLogicTableColumns, String.format("opsLogicTableColumns is null"));

        opsLogicTableColumns.forEach(opsLogicTableColumn -> {
            opsLogicTableColumnMapper.insert(opsLogicTableColumn);
            if (opsLogicTableColumn.getId() <= 0) {
                throw new RuntimeException("opsLogicTableColumnMapper.insert fail");
            }
        });

        DataOpsResponse<Boolean> response = new DataOpsResponse<>();
        response.setModel(true);

        return response;
    }

    @Override
    public DataOpsResponse<Boolean> updateLogicTableColumn(OpsLogicTableColumn opsLogicTableColumn) {
        // 参数检查
        Assert.notNull(opsLogicTableColumn, String.format("opsLogicTableColumn is null"));
        int count = opsLogicTableColumnMapper.updateByPrimaryKeySelective(opsLogicTableColumn);

        DataOpsResponse<Boolean> response = new DataOpsResponse<>();
        response.setModel(count > 0 ? true : false);

        return response;
    }

    @Override
    @Transactional
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
    @Transactional
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

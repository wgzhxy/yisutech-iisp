package com.yisutech.iisp.dataops.service;

import com.yisutech.iisp.dataops.repository.pojo.*;
import com.yisutech.iisp.dataops.service.model.DataOpsResponse;

import java.util.List;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.dataops.service.DataMetaService
 * 描述：
 * 基础元信息管理
 *
 * @author guangzhong.wgz
 * @create 2018-03-28 下午2:50
 **/
public interface DataMetaService {

    /**
     * 新增数据源
     *
     * @param opsDataSource
     * @return
     */
    DataOpsResponse<Integer> addDataSource(OpsDataSource opsDataSource);

    /**
     * 修改数据源
     *
     * @param opsDataSource
     * @return
     */
    DataOpsResponse<Boolean> updateDataSource(OpsDataSource opsDataSource);

    /**
     * 新增物理表
     *
     * @return
     */
    DataOpsResponse<Integer> addTable(OpsTable opsTable, List<OpsTableColumn> opsTableColumn);

    /**
     * 更新物理表
     *
     * @return
     */
    DataOpsResponse<Boolean> updateTable(OpsTable opsTable);

    /**
     * 更新物理表字段
     *
     * @return
     */
    DataOpsResponse<Boolean> updateTableColumn(OpsTableColumn opsTableColumn);

    /**
     * 新增逻辑表
     *
     * @return
     */
    DataOpsResponse<String> addLogicTable(OpsLogicTable opsLogicTable);

    /**
     * 更新逻辑表
     *
     * @return
     */
    DataOpsResponse<String> updateLogicTable(OpsLogicTable opsLogicTable);

    /**
     * 新增逻辑表字段
     *
     * @return
     */
    DataOpsResponse<Boolean> addLogicTableColumn(List<OpsLogicTableColumn> opsLogicTableColumn);

    /**
     * 更新逻辑表字段
     *
     * @return
     */
    DataOpsResponse<Boolean> updateLogicTableColumn(OpsLogicTableColumn opsLogicTableColumn);

    /**
     * 删除物理表
     *
     * @param tableCode
     * @return
     */
    DataOpsResponse<Integer> deleteTable(String tableCode);
    
    /**
     * 删除逻辑表
     *
     * @return
     */
    DataOpsResponse<Boolean> deleteLogicTable(String tableCode);
}

package com.yisutech.iisp.dataops.repository;

import com.yisutech.iisp.dataops.repository.pojo.*;

import java.util.List;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.dataops.repository.TableConfigRepository
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-04-08 下午7:09
 **/
public interface TableConfigRepository {

    /**
     * @param tableCode
     * @return
     */
    List<OpsLogicTable> queryLogicTable(String tableCode);

    /**
     * @param tableCode
     * @return
     */
    List<OpsLogicTableColumn> queryLogicTableColumn(String tableCode);

    /**
     * @param tableCode
     * @return
     */
    List<OpsTable> queryTable(String tableCode);

    /**
     * @param tableCode
     * @return
     */
    List<OpsTableColumn> queryTableColumn(String tableCode);

    /**
     * 查询数据源配置
     *
     * @param dataSourceId 数据源ID
     * @return {@link List<OpsDataSource>}
     */
    List<OpsDataSource> queryDataSource(String dataSourceId);

}

package com.yisutech.iisp.dataops.service;

import com.yisutech.iisp.dataops.service.model.DataOpsResponse;

import java.util.List;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.dataops.service.DataMetaService
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-03-28 下午2:50
 **/
public interface DataMetaService {

    /**
     * 创建表
     *
     * @return
     */
    DataOpsResponse createTable(String tableCode);

    /**
     * 更改表
     *
     * @return
     */
    DataOpsResponse alterTableColumns(String tableCode, List<String> orginColumns, List<String> newColumns);
}

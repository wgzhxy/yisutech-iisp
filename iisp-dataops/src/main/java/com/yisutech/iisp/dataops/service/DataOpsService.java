package com.yisutech.iisp.dataops.service;

import com.yisutech.iisp.dataops.service.model.DataOpsRequest;
import com.yisutech.iisp.dataops.service.model.DataOpsResponse;
import com.yisutech.iisp.toolkit.utils.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.dataops.service.DataOpsService
 * 描述：
 * <p>
 * 数据操作服务接口
 *
 * @author guangzhong.wgz
 * @create 2018-03-28 上午11:01
 **/
public interface DataOpsService {

    /**
     * 新增数据对象
     *
     * @param dataOpsRequest {@link DataOpsRequest}
     * @return {@link DataOpsResponse}
     */
    DataOpsResponse<Integer> add(DataOpsRequest dataOpsRequest);

    /**
     * 删除数据对象
     *
     * @param dataOpsRequest {@link DataOpsRequest}
     * @return {@link DataOpsResponse}
     */
    DataOpsResponse<Integer> delete(DataOpsRequest dataOpsRequest);

    /**
     * 更新数据对象
     *
     * @param dataOpsRequest {@link DataOpsRequest}
     * @return {@link DataOpsResponse}
     */
    DataOpsResponse<Integer> update(DataOpsRequest dataOpsRequest);

    /**
     * 查询数据
     *
     * @param dataOpsRequest {@link DataOpsRequest}
     * @return {@link DataOpsResponse}
     */
    DataOpsResponse<PageInfo<List<Map<String, Object>>>> query(DataOpsRequest dataOpsRequest);
}

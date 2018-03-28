package com.yisutech.iisp.dataops.service;

import com.yisutech.iisp.dataops.service.model.DataOpsRequest;
import com.yisutech.iisp.dataops.service.model.DataOpsResponse;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.dataops.service.DataOpsService
 * 描述：
 * <p>
 * DB数据操作接口
 *
 * @author guangzhong.wgz
 * @create 2018-03-28 上午11:01
 **/
public interface DataOpsService {

    /**
     * 存储数据对象
     *
     * @param dataOpsRequest {@link DataOpsRequest}
     * @return {@link DataOpsResponse}
     */
    DataOpsResponse save(DataOpsRequest dataOpsRequest);

    /**
     * 查询数据
     *
     * @param dataOpsRequest {@link DataOpsRequest}
     * @return {@link DataOpsResponse}
     */
    DataOpsResponse query(DataOpsRequest dataOpsRequest);

    /**
     * 删除数据记录
     *
     * @param dataOpsRequest {@link DataOpsRequest}
     * @return {@link DataOpsResponse}
     */
    DataOpsResponse delete(DataOpsRequest dataOpsRequest);
}

package com.yisutech.iisp.dataops.service.model;

import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.dataops.service.model.DataOpsResponse
 * 描述：
 * <p>
 * 数据操作返回
 *
 * @author guangzhong.wgz
 * @create 2018-03-28 下午2:20
 **/
public class DataOpsResponse implements Serializable {

    private static final long serialVersionUID = 3835693824958520585L;

    /**
     * 返回数据对象
     */
    List<Map<String, Object>> data = Lists.newArrayList();
    /**
     * 请求处理信息
     */
    String messageInfo;
    /**
     * 请求处理编码
     */
    String code;
    /**
     * 请求状态
     */
    boolean success;


}

package com.yisutech.iisp.dataops.config;

import com.yisutech.iisp.dataops.engine.template.model.TableMeta;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.dataops.config.DataOpsConfigService
 * 描述：
 * 数据操作基础配置
 *
 * @author guangzhong.wgz
 * @create 2018-03-28 下午7:37
 **/
public interface DataOpsConfigService {

    /**
     * 获取表元信息
     *
     * @param tableCode 表编码
     * @return
     */
    TableMeta getTableMeta(String tableCode);
}

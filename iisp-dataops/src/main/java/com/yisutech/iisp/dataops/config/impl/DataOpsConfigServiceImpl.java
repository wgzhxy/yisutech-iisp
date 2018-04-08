package com.yisutech.iisp.dataops.config.impl;

import com.yisutech.iisp.dataops.config.DataOpsConfigService;
import com.yisutech.iisp.dataops.engine.template.model.TableMeta;
import com.yisutech.iisp.dataops.repository.mapper.*;
import org.springframework.stereotype.Service;

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
    private OpsTableMapper opsTableMapper;
    @Resource
    private OpsDataSourceMapper opsDataSourceMapper;
    @Resource
    private OpsLogicTableMapper opsLogicTableMapper;
    @Resource
    private OpsTableColumnMapper opsTableColumnMapper;

    @Resource
    private OpsLogicTableColumnMapper opsLogicTableColumnMapper;

    @Override
    public TableMeta getTableMeta(String tableCode) {
        // 查逻辑表
        // 查逻辑字段
        // 查物理表
        // 查物理字段
        // 拼装 TableMeta对象
        return null;
    }

    @Override
    public TableMeta getTableMetas(List<String> tableCodes) {
        return null;
    }


}

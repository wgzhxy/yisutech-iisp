package com.yisutech.iisp.dataops.engine;

import com.google.common.collect.Maps;
import com.yisutech.iisp.dataops.engine.template.model.DataSourceMeta;
import com.yisutech.iisp.toolkit.utils.SpringHelper;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.dataops.engine.DataOpsEngine
 * 描述：
 * <p>
 * 数据操作引擎
 *
 * @author guangzhong.wgz
 * @create 2018-03-22 下午5:17
 **/
@Component
public class DataOpsEngine<T extends DataOps> {

    /**
     * 获取DataOps实例
     */
    public T getDataOpsTemplate(DataOpsContext dataOpsContext) {

        Assert.notNull(dataOpsContext, "dataOpsContext is null");
        Assert.notNull(dataOpsContext.getDataOpsType(), "dataOpsType is null");

        DataOpsSourceAdapter adapter = engineAdapters.get(dataOpsContext.getDataOpsType());
        Assert.notNull(adapter, "adapter not exists");
        
        return (T) adapter.build(dataOpsContext);
    }

    /**
     * 获取DataOps实例
     */
    public T getDefaultDataOpsTemplate(DataOpsContext dataOpsContext) {

        Assert.notNull(dataOpsContext, "dataOpsContext is null");
        Assert.notNull(dataOpsContext.getDataOpsType(), "dataOpsType is null");

        DataOpsSourceAdapter adapter = engineAdapters.get(dataOpsContext.getDataOpsType());
        return (T) adapter.getDataOps(dataOpsContext);
    }

    @PostConstruct
    private void init() {
        Map<String, DataOpsSourceAdapter> opsSourceAdapters = SpringHelper.getBeansOfType(DataOpsSourceAdapter.class);
        Assert.notNull(opsSourceAdapters, "no DataOpsSourceAdapter init");
        opsSourceAdapters.forEach((k, v) -> {
            engineAdapters.put(v.getDataOpsType(), v);
        });
    }

    public interface DataOpsSourceAdapter {

        /**
         * 初始化数据源
         */
        DataOps build(DataOpsContext dataOpsContext);

        /**
         * 获取操作模板
         *
         * @return {@link DataOps}
         */
        DataOps getDataOps(DataOpsContext dataOpsContext);

        /**
         * 获取模板类型，跟dataOps是对应关系
         *
         * @return
         */
        DataSourceMeta.DataOpsType getDataOpsType();
    }

    /**
     * 引擎缓存
     */
    private Map<DataSourceMeta.DataOpsType, DataOpsSourceAdapter> engineAdapters = Maps.newConcurrentMap();
}

package com.yisutech.iisp.dataops.engine;

import com.google.common.collect.Maps;
import com.yisutech.iisp.dataops.engine.adapter.DataOpsSource;
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
    public T getDefaultInstance(DataOpsContext.DataOpsType dataOpsType) {
        return (T) engineAdapters.get(dataOpsType);
    }

    /**
     * 获取DataOps实例
     */
    public T getDefaultInstance(DataOpsContext dataOpsContext) {
        return null;
    }


    @PostConstruct
    public void init() {
        Map<String, DataOpsSourceAdapter> adapterMap = SpringHelper.getBeansOfType(DataOpsSourceAdapter.class);
        Assert.notNull(adapterMap, "DataOpsSourceAdapter is Null, need to init");
        adapterMap.forEach((k, v) -> {
            engineAdapters.put(v.getDataOpsType(), v.getDataOps());
        });
    }

    public interface DataOpsSourceAdapter {

        /**
         * 初始化数据源
         */
        void initDataSource(DataOpsSource dtSource);

        /**
         * 获取操作模板
         *
         * @return {@link DataOps}
         */
        DataOps getDataOps();

        /**
         * 获取模板类型，跟dataOps是对应关系
         *
         * @return
         */
        DataOpsContext.DataOpsType getDataOpsType();
    }

    /**
     * 引擎缓存块
     */
    private Map<DataOpsContext.DataOpsType, DataOps> engineAdapters = Maps.newConcurrentMap();
}

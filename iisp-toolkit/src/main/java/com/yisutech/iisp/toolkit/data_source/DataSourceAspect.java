package com.yisutech.iisp.toolkit.data_source;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author guangzhong.wgz
 */
public class DataSourceAspect {

    public Object around(ProceedingJoinPoint point) throws Throwable {
        try {
            MultiDataSource.setDataSourceKey(DataSourceEnum.PROFIT_DATA_SOURCE.source());
            return point.proceed();
        } finally {
            MultiDataSource.remove();
        }
    }

}

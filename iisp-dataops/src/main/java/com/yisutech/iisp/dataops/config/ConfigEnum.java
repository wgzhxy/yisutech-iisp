package com.yisutech.iisp.dataops.config;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.dataops.config.ConfigEnum
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-04-09 上午10:43
 **/
public enum ConfigEnum {
    ;

    public enum LogicTableType {
        config(1)/**table**/
        , udSQl(2)/**用户自定义sql**/
        ;

        LogicTableType(Integer value) {
            this.value = value;
        }

        int value;

        public Integer getValue() {
            return this.value;
        }
    }
}

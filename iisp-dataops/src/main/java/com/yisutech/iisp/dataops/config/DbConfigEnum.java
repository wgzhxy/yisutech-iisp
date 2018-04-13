package com.yisutech.iisp.dataops.config;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.dataops.config.DbConfigEnum
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-04-09 上午10:43
 **/
public enum DbConfigEnum {
    ;

    public enum TableType {
        TABLE(1), LOGIC_TABLE(2);
        int value;

        TableType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}

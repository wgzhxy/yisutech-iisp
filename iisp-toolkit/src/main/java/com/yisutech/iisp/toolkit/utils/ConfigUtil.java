package com.yisutech.iisp.toolkit.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author guangzhong.wgz
 */
public class ConfigUtil {

    private static final Logger LOG = LoggerFactory.getLogger(ConfigUtil.class);
    private static String CONFIG_NAME = "placeholder";
    private static PropertiesUtil res = null;

    static {
        try {
            res = new PropertiesUtil(CONFIG_NAME);
        } catch (Throwable e) {
            LOG.error("load Properties error", e);
        }
    }

    public static String getString(String key, String defaulValue) {
        String value = "";
        try {
            value = res.get(key);
            if (StringUtils.isBlank(value)) {
                return defaulValue;
            }
            return value;
        } catch (Throwable e) {
            LOG.error("ConfigUtil getString error", e);
        }
        return defaulValue;
    }

    public static String getString(String key) {
        String value = "";
        try {
            value = res.get(key);
        } catch (Throwable e) {
            LOG.error("ConfigUtil getString error", e);
        }
        return value;
    }

    public static void main(String args[]) {
        System.out.println(ConfigUtil.getString("ant.deployEnv", "test"));
    }
}

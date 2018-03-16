package com.yisutech.iisp.toolkit.utils;

/**
 * 发布环境
 *
 * @author ding.lid
 */
public class PubEnvUtil {

    public static final String ENV_PRE = "pre";
    public static final String ENV_DEV = "daily";
    public static final String ENV_ONLINE = "online";
    public static final String ANT_PUB_DEV_KEY = "ant.deployEnv";

    /**
     * 获取当前环境
     */
    public static String getPubEnv() {
        return ConfigUtil.getString(ANT_PUB_DEV_KEY, ENV_DEV);
    }

    public static boolean isDevEnv() {
        return ENV_DEV.equalsIgnoreCase(getPubEnv());
    }

    public static boolean isOnlineEnv() {
        return ENV_ONLINE.equalsIgnoreCase(getPubEnv());
    }

    public static boolean isPreEnv() {
        return ENV_PRE.equalsIgnoreCase(getPubEnv());
    }
}

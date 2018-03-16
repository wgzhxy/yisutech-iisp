package com.yisutech.iisp.toolkit.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;

public class NetworkUtils {

    private static final Logger LOG = LoggerFactory.getLogger(NetworkUtils.class);

    public static String getIp() {
        try {
            InetAddress inetAddress = InetAddress.getLocalHost();
            if (null == inetAddress) {
                return "";
            }
            return inetAddress.getHostAddress();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(getIp());
    }
}

/*
 * Copyright 2012 Alibaba.com All right reserved. This software is the
 * confidential and proprietary information of Alibaba.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with Alibaba.com.
 */
package com.yisutech.iisp.toolkit.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * 配置加载
 * 
 * @author guangzhong.wgz
 */
public class PropertiesUtil {

    protected static final Logger log = LoggerFactory.getLogger(PropertiesUtil.class);

    private ResourceBundle        res = null;

    public PropertiesUtil(String bundleName) {
        try {
            res = (PropertyResourceBundle) ResourceBundle.getBundle(bundleName);
        } catch (Throwable e) {
            log.error(String.format("## load bundleName=%s error !!!!)", bundleName), e);
            throw new RuntimeException("The properties-file<" + bundleName + "> maybe not exist!", e);
        }

    }

    public String get(String key) {
        try {
            return res.getString(key);
        } catch (Exception e) {
            log.error("get error", e);
        }
        return "";
    }

    public PropertyResourceBundle getBundle() {
        return (PropertyResourceBundle) res;
    }
}

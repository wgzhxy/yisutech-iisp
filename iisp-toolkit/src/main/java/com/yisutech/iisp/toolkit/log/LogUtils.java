package com.yisutech.iisp.toolkit.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Supplier;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.toolkit.log.LogUtils
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-04-12 下午2:52
 **/
public class LogUtils {

    /**
     * 获取logger
     *
     * @param logName
     * @return
     */
    public static Logger getLog(String logName) {
        return LoggerFactory.getLogger(logName);
    }

    /**
     * 获取logger
     *
     * @param defineClass
     * @return
     */
    public static Logger getLog(Class<?> defineClass) {
        return LoggerFactory.getLogger(defineClass);
    }

    /**
     * 获取logger
     *
     * @param log     日志打印对象
     * @param message 日志内容
     * @return
     */
    public static void info(Logger log, Supplier<String> message) {
        if (log.isInfoEnabled()) {
            log.info(message.get());
        }
    }

    /**
     * 获取logger
     *
     * @param log     日志打印对象
     * @param message 日志内容
     * @return
     */
    public static void debug(Logger log, Supplier<String> message) {
        if (log.isDebugEnabled()) {
            log.debug(message.get());
        }
    }

    /**
     * 获取logger
     *
     * @param log     日志打印对象
     * @param message 日志内容
     * @return
     */
    public static void warn(Logger log, Supplier<String> message) {
        if (log.isWarnEnabled()) {
            log.warn(message.get());
        }
    }

    /**
     * 获取logger
     *
     * @param log     日志打印对象
     * @param message 日志内容
     * @return
     */
    public static void error(Logger log, Supplier<String> message) {
        if (log.isErrorEnabled()) {
            log.error(message.get());
        }
    }
}

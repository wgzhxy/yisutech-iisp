package com.yisutech.iisp.toolkit.result;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 */
public class Result<T> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1905775611728626568L;

    /**
     * 执行结果，默认为true
     */
    protected boolean success = true;

    /**
     * 返回的对象
     */
    protected T model;
    /**
     * 错误码
     * 错误码规则：应用名_错误信息的英文描述
     * 如WASS_USER_NOT_FOUND
     */
    protected String msgCode;

    /**
     * httpStatusCode
     */
    protected int httpStatusCode = 200;
    /**
     * 错误信息
     * 错误信息的业务描述
     * 如：当前商品五件起售
     */
    protected String msgInfo;


    protected Map<String, String> headers = new HashMap<String, String>();

    /**
     * 业务方扩展字段
     */
    protected Map bizExtMap;

    public Map getBizExtMap() {
        return bizExtMap;
    }

    public void setBizExtMap(Map bizExtMap) {
        this.bizExtMap = bizExtMap;
    }

    /**
     * 设置302跳转输出
     *
     * @param url，跳转的url地址
     */
    public void set302Jump(String url) {
        httpStatusCode = 302;
        // headers.put(CacheHeaderConstant.LOCALTION, url);
    }

    /**
     * 透传http cache control header(200-304)
     *
     * @param maxAge       单位是秒
     * @param lastModified
     */
    public void setCacheControl(int maxAge, Date lastModified, String cacheKey) {
        setLastModified(lastModified);
        setCacheKey(cacheKey);
    }

    /**
     * 设置HttpStatusCode
     */
    public void setCachedHttpStatusCode() {
        httpStatusCode = 304;
    }


    /**
     * 设置HttpStatusCode,进行限流降级，输出给客户端进行api调用控制
     */
    public void setLimitHttpStatusCode() {
        httpStatusCode = 420;
    }

    public void setCacheKey(String cacheKey) {
        if (cacheKey != null) {
        }
    }

    /**
     * @param lastModified
     */
    public void setLastModified(Date lastModified) {
        Date d = null;
        if (lastModified != null) {
            d = lastModified;
        } else {
            d = new Date();
        }
    }

    /**
     * 自定义cachecontrol，可public、private、no-cache等
     *
     * @param cacheControl
     */
    public void setCacheControl(String cacheControl, Date lastModified, String cacheKey) {
        setLastModified(lastModified);
        setCacheKey(cacheKey);
    }

    /**
     * 告知mtop进行api缓存
     */
    public void isCached(boolean isCached) {
        // headers.put(CacheHeaderConstant.ISCACHED, isCached + "");
    }

    /**
     * 告知mtop是否进行缓存，并设置缓存内容过期时间
     * (如果不进行设置，默认情况下会根据mtop设置的API缓存策略进行缓存，如果设置以应用方缓存设置优先级高)
     *
     * @param isCached
     */
    public void isCached(boolean isCached, int mtopCachedMaxAge) {
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void addHeader(String key, String value) {
        this.headers.put(key, value);
    }

    @Deprecated
    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Result(T model) {
        this.model = model;
    }

    public Result(boolean success, String msgCode, String msgInfo) {
        this.success = success;
        this.msgCode = msgCode;
        this.msgInfo = msgInfo;
    }

    public Result(boolean success, String msgCode, String msgInfo, T model) {
        this.success = success;
        this.msgCode = msgCode;
        this.msgInfo = msgInfo;
        this.model = model;
    }

    public Result() {

    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public String getMsgInfo() {
        return msgInfo;
    }

    public void setMsgInfo(String msgInfo) {
        this.msgInfo = msgInfo;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


    public int getHttpStatusCode() {
        return httpStatusCode;
    }
}

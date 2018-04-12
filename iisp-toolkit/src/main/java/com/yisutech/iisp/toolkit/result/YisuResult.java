package com.yisutech.iisp.toolkit.result;

import java.io.Serializable;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.toolkit.result.YisuResult
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-03-28 下午3:02
 **/
public class YisuResult<T> implements Serializable {

    private static final long serialVersionUID = 5536332498957162424L;

    /**
     * 返回数据
     */
    protected T model;
    /**
     * 请求处理消息编码
     */
    protected String msgCode;
    /**
     * 请求处理消息
     */
    protected String msgInfo;
    /**
     * 是否成功
     */
    protected boolean success = true;

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
}

package com.yisutech.iisp.toolkit.express.expr.compare;


import org.apache.commons.lang3.StringUtils;

public class RegexCompareNode extends CompareNode {

    public RegexCompareNode(String fieldName, Object fieldValue) {
        super(fieldName, fieldValue);
    }

    @Override
    public String doToString() {
        fieldValue = StringUtils.replace(fieldValue.toString(), "/", "\\/"); // aviator内部使用/分割，需要转义
        return fieldName + "=~/" + fieldValue + "/";
    }

    @Override
    protected boolean needCheckFieldValueIsNull() {
        return true;
    }

}

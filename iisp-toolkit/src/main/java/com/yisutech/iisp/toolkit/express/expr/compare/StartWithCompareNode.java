package com.yisutech.iisp.toolkit.express.expr.compare;

public class StartWithCompareNode extends CompareNode {

    public StartWithCompareNode(String fieldName, Object fieldValue) {
        super(fieldName, fieldValue);
    }

    @Override
    public String doToString() {
        return "string.startsWith(" + fieldName + ",'" + fieldValue + "')";
    }

    @Override
    protected boolean needCheckFieldValueIsNull() {
        return true;
    }

}

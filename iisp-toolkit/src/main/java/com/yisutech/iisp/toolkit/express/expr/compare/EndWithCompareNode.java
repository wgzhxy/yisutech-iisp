package com.yisutech.iisp.toolkit.express.expr.compare;

public class EndWithCompareNode extends CompareNode {

    public EndWithCompareNode(String fieldName, Object fieldValue) {
        super(fieldName, fieldValue);
    }

    @Override
    public String doToString() {
        return "string.endsWith(" + fieldName + ",'" + fieldValue + "')";
    }

    @Override
    protected boolean needCheckFieldValueIsNull() {
        return true;
    }

}

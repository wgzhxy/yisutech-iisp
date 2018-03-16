package com.yisutech.iisp.toolkit.express.expr.compare;

public class ContainsCompareNode extends CompareNode {

    public ContainsCompareNode(String fieldName, Object fieldValue) {
        super(fieldName, fieldValue);
    }

    @Override
    public String doToString() {
        return "string.contains(" + fieldName + ",'" + fieldValue.toString() + "')";
    }

    @Override
    protected boolean needCheckFieldValueIsNull() {
        return true;
    }

}

package com.yisutech.iisp.toolkit.express.expr.compare;

public class GtCompareNode extends CompareNode {

    public GtCompareNode(String fieldName, Object fieldValue) {
        super(fieldName, fieldValue);
    }

    @Override
    protected boolean needCheckFieldValueIsNull() {
        return false;
    }

    @Override
    protected String doToString() {
        return fieldName + ">" + fieldValue;
    }

}

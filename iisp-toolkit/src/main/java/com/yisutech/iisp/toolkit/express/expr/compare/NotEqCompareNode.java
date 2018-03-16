package com.yisutech.iisp.toolkit.express.expr.compare;

public class NotEqCompareNode extends CompareNode {

    public NotEqCompareNode(String fieldName, Object filedValue) {
        super(fieldName, filedValue);
    }

    @Override
    public String doToString() {
        return fieldName + "!=" + "'" + fieldValue + "'";
    }

    @Override
    protected boolean needCheckFieldValueIsNull() {
        return false;
    }

}

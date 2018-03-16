package com.yisutech.iisp.toolkit.express.expr.compare;

public class EqCompareNode extends CompareNode {

    public EqCompareNode(String fieldName, Object filedValue) {
        super(fieldName, filedValue);
    }

    @Override
    public String doToString() {
        return fieldName + "==" + "'" + fieldValue + "'";
    }

    @Override
    protected boolean needCheckFieldValueIsNull() {
        return false;
    }

}

package com.yisutech.iisp.toolkit.express.expr.compare;

public class BetweenCompareNode extends MultiValueCompareNode {

    public BetweenCompareNode(String fieldName, Object min, Object max) {
        super(fieldName, min, max);
    }

    @Override
    public String doToString() {
        return fieldName + ">=" + fieldValue + " && " + fieldName + "<=" + fieldValue2;
    }

    @Override
    protected boolean needCheckFieldValueIsNull() {
        return false;
    }

}

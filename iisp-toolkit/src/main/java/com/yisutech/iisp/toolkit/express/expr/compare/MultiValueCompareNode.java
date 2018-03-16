package com.yisutech.iisp.toolkit.express.expr.compare;

public abstract class MultiValueCompareNode extends CompareNode {

    protected Object fieldValue2;

    public MultiValueCompareNode(String fieldName, Object filedValue, Object filedValue2) {
        super(fieldName, filedValue);
        this.fieldValue2 = filedValue2;
    }

}

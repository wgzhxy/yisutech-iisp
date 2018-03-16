package com.yisutech.iisp.toolkit.express.expr.compare;

/**
 * in
 */
public class InCompareNode extends CompareNode {

    public InCompareNode(String fieldName, Object fieldValue) {
        super(fieldName, fieldValue);
    }

    @Override
    public String doToString() {
        return "string.contains('" + fieldValue.toString() + "'," + fieldName + ")";
    }

    @Override
    protected boolean needCheckFieldValueIsNull() {
        return true;
    }

}

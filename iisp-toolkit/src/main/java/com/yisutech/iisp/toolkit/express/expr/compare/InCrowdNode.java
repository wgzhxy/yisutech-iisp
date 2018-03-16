package com.yisutech.iisp.toolkit.express.expr.compare;

/**
 * 人群
 */
public class InCrowdNode extends CompareNode {

    public InCrowdNode(String fieldName, Object fieldValue) {
        super(fieldName, fieldValue);
    }

    @Override
    public String doToString() {
        return "inCrowd('" + fieldValue.toString() + "'," + fieldName + ")";
    }

    @Override
    protected boolean needCheckFieldValueIsNull() {
        return false;
    }

}

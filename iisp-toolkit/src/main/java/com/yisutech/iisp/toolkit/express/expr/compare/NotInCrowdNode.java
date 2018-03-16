package com.yisutech.iisp.toolkit.express.expr.compare;

/**
 * 人群
 */
public class NotInCrowdNode extends CompareNode {

    public NotInCrowdNode(String fieldName, Object fieldValue) {
        super(fieldName, fieldValue);
    }

    @Override
    public String doToString() {
        return "notInCrowd('" + fieldValue.toString() + "'," + fieldName + ")";
    }

    @Override
    protected boolean needCheckFieldValueIsNull() {
        return false;
    }

}

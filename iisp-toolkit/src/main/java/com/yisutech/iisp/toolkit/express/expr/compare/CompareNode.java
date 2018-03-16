package com.yisutech.iisp.toolkit.express.expr.compare;

import com.yisutech.iisp.toolkit.express.expr.ExpressNode;
import org.apache.commons.lang3.StringUtils;

public abstract class CompareNode extends ExpressNode {

    protected String fieldName;
    protected Object fieldValue;

    public CompareNode(String fieldName, Object fieldValue) {
        this.fieldName = escapeFieldName(fieldName);
        this.fieldValue = fieldValue;
    }

    protected String escapeFieldName(String fieldName) {
        return StringUtils.replace(fieldName, ".", "_");
    }

    protected String notNull() {
        return fieldName + "!=nil && ";
    }

    protected abstract boolean needCheckFieldValueIsNull();

    protected abstract String doToString();

    public String toString() {
        if (needCheckFieldValueIsNull()) {
            return notNull() + doToString();
        }
        return doToString();
    }
}

package com.yisutech.iisp.toolkit.express.expr;

public abstract class ExpressNode implements Cloneable {

    public abstract String toString();

    public ExpressNode clone() {
        try {
            return (ExpressNode) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

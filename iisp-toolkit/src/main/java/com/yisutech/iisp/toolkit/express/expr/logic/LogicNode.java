package com.yisutech.iisp.toolkit.express.expr.logic;


import com.yisutech.iisp.toolkit.express.expr.ExpressNode;

import java.util.ArrayList;
import java.util.List;

public abstract class LogicNode extends ExpressNode {

    private List<ExpressNode> childs = new ArrayList<ExpressNode>();

    public void add(ExpressNode node) {
        childs.add(node);
    }

    public List<ExpressNode> getChilds() {
        return childs;
    }

}

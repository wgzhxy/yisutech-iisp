package com.yisutech.iisp.toolkit.express.expr;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yisutech.iisp.toolkit.express.expr.compare.*;
import com.yisutech.iisp.toolkit.express.expr.logic.AndLogicNode;
import com.yisutech.iisp.toolkit.express.expr.logic.LogicNode;
import com.yisutech.iisp.toolkit.express.expr.logic.OrLogicNode;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

public class ExpressNodeBuilder {

    public static LogicNode newLogicNode(String type) {
        if (type.equals("$and")) {
            return new AndLogicNode();
        } else if (type.equals("$or")) {
            return new OrLogicNode();
        }
        throw new RuntimeException("it's not suport logic type! type=" + type);
    }

    private static CompareNode newCompareNode(String type, Map<String, Object> context) {

        String fieldName = context.get("fieldName").toString();
        Object fieldValue = context.get("fieldValue");

        Assert.notNull(type, "type is null");
        Assert.notNull(fieldName, "fieldName is null");
        Assert.notNull(fieldValue, "fieldValue is null");

        if (type.equals("$eq")) {
            return new EqCompareNode(fieldName, fieldValue);
        } else if (type.equals("$gt")) {
            return new GtCompareNode(fieldName, fieldValue);
        } else if (type.equals("$gte")) {
            return new GteCompareNode(fieldName, fieldValue);
        } else if (type.equals("$lt")) {
            return new LtCompareNode(fieldName, fieldValue);
        } else if (type.equals("$lte")) {
            return new LteCompareNode(fieldName, fieldValue);
        } else if (type.equals("$ne")) {
            return new NotEqCompareNode(fieldName, fieldValue);
        } else if (type.equals("$in")) {
            return new InCompareNode(fieldName, fieldValue);
        } else if (type.equals("$sw")) {
            return new StartWithCompareNode(fieldName, fieldValue);
        } else if (type.equals("$ew")) {
            return new EndWithCompareNode(fieldName, fieldValue);
        } else if (type.equals("$ct")) {
            return new ContainsCompareNode(fieldName, fieldValue);
        } else if (type.equals("$bt")) {
            JSONArray array = (JSONArray) fieldValue;
            return new BetweenCompareNode(fieldName, array.get(0), array.get(1));
        } else if (type.equals("$re")) {
            return new RegexCompareNode(fieldName, fieldValue);
        } else if (type.equals("$crowd")) {
            return new InCrowdNode(fieldName, fieldValue);
        } else if (type.equals("$notCrowd")) {
            return new NotInCrowdNode(fieldName, fieldValue);
        }

        throw new RuntimeException("it's not suport compare type! type=" + type);
    }

    private static boolean isLogicExpr(String type) {

        return "$and".equals(type) || "$or".equals(type);
    }

    static LogicNode build(LogicNode root, JSONObject context) {
        JSONArray criterions = (JSONArray) context.get("criterions");
        if (criterions == null) {
            return root;
        }
        for (Object item : criterions) {
            JSONObject json = (JSONObject) item;
            String type = json.get("type").toString();
            if (isLogicExpr(type)) {
                LogicNode node = (LogicNode) newLogicNode(type);
                root.add(build(node, json));
            } else {
                CompareNode node = newCompareNode(type, json);
                root.add(node);
            }
        }
        return root;
    }

    static String visit(LogicNode parent) {
        StringBuffer sb = new StringBuffer();
        List<ExpressNode> childList = parent.getChilds();
        for (int i = 0; i < childList.size(); ++i) {
            ExpressNode child = childList.get(i);
            if (child instanceof LogicNode) {
                sb.append("(");
                sb.append(visit((LogicNode) child));
                sb.append(")");
            } else {
                sb.append(child.toString());
                if (i < childList.size() - 1) {
                    sb.append(parent.toString());
                }
            }
        }
        return sb.toString();
    }
}

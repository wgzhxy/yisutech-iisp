package com.yisutech.iisp.toolkit.express.expr;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.googlecode.aviator.AviatorEvaluator;
import com.yisutech.iisp.toolkit.express.expr.logic.LogicNode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 条件表达式计算
 *
 * @author guangzhong.wgz
 */
public class EvaluateExpressionManager {

    private static final Logger LOG = LoggerFactory.getLogger(EvaluateExpressionManager.class);

    public static boolean execute(String expression, Map<String, Object> context) {
        if (StringUtils.isBlank(expression)) {
            return true;
        }
        String aviatorExpress = "";
        try {
            // 初始化计算参数
            transformCondition(context, expression);

            // 转为aviator表达式
            aviatorExpress = convertExpression(expression);
            if (StringUtils.isBlank(aviatorExpress)) {
                return true;
            }

            // 表达式计算
            return (Boolean) AviatorEvaluator.execute(aviatorExpress, context, true);

        } catch (Throwable e) {
            LOG.error("EvaluateExpressionManager.execute! expression : {}, aviatorExpress : {} , context : {}",
                    expression, aviatorExpress, JSON.toJSONString(context), e);
            return false;
        }
    }


    /**
     * 根据表达式转换变量类型
     *
     * @param condition 表达式变量集合
     * @param express   表达式
     */
    private static void transformCondition(Map<String, Object> condition, String express) {
        if (condition == null || condition.size() <= 0 || StringUtils.isBlank(express)) {
            return;
        }
        //解析表达式，得到表达式运算符及对应的key值
        List<String> keys = Lists.newArrayList();
        try {
            Map<String, String> fields = Maps.newHashMap();
            JSONObject expressJsons = JSON.parseObject(express);
            JSONArray expressJsonArray = expressJsons.getJSONArray("criterions");
            if (expressJsonArray != null) {
                for (Object expressJson : expressJsonArray) {
                    JSONObject condJson = (JSONObject) expressJson;
                    String value = condJson.getString("type");
                    String key = condJson.getString("fieldName");
                    fields.put(key, value);
                }
            }
            //转换对象
            for (Map.Entry<String, String> entry : fields.entrySet()) {

                keys.add(entry.getKey());
                Object value = condition.get(entry.getKey());

                if (getExpressType(entry.getValue()) == Long.class) {

                    if (value != null && StringUtils.isNumeric(value.toString())) {
                        condition.put(StringUtils.replace(entry.getKey(), ".", "_"), Long.parseLong(value.toString()));

                    } else {
                        LOG.error(entry.getKey() + " : " + value + " is not valid!");
                    }
                } else if (value != null && !(value instanceof String) && getExpressType(entry.getValue()) == String.class) {
                    condition.put(StringUtils.replace(entry.getKey(), ".", "_"), String.valueOf(value));

                } else if (value != null) {
                    condition.put(StringUtils.replace(entry.getKey(), ".", "_"), value);
                }
            }
        } catch (Throwable e) {
            LOG.error("transformCondition error", e);
        }
        // 移除无效的key值
        Iterator<String> iterator = condition.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            if (key.contains(".")) {
                iterator.remove();
            }
        }
    }

    /**
     * $eq	等于	字符串
     * $gt	大于	数字
     * $gte	大于等于	数字
     * $lt	小于	数字
     * $lte	小于等于	数字
     * $ne	不等于	字符串
     * $in	在...中	字符串
     * $sw	以...开始	字符串
     * $ew	以...结束	字符串
     * $ct	包含...	字符串
     * $bt	在...范围	数字
     * $re	正则表达式	字符串
     */
    private static List<String> expressTypeList = new ArrayList<String>();

    static {
        expressTypeList.add("$bt");
        expressTypeList.add("$lte");
        expressTypeList.add("$lt");
        expressTypeList.add("$gte");
        expressTypeList.add("$gt");
    }

    private static Object getExpressType(String expressType) {
        if (expressTypeList.contains(expressType)) {
            return Long.class;
        }
        return String.class;
    }

    private static String convertExpression(final String express) {
        if (StringUtils.isBlank(express)) {
            return "";
        }
        JSONObject expressJsons = JSON.parseObject(express);
        return convertToAviatorExpress(expressJsons);
    }

    public static String convertToAviatorExpress(JSONObject context) {
        String type = (String) context.get("type");
        if (StringUtils.isBlank(type)) {
            type = "$and";
        }
        LogicNode root = ExpressNodeBuilder.newLogicNode(type);
        LogicNode node = ExpressNodeBuilder.build(root, context);
        String expr = ExpressNodeBuilder.visit(node);
        return expr;
    }

    public static Object getFieldValue(String express, String fieldName) {

        if (StringUtils.isBlank(fieldName) || StringUtils.isBlank(express)) {
            return null;
        }

        JSONObject expressJsons = JSON.parseObject(express);
        JSONArray expressJsonArray = expressJsons.getJSONArray("criterions");

        if (expressJsonArray != null) {
            for (Object expressJson : expressJsonArray) {
                JSONObject condJson = (JSONObject) expressJson;
                String key = condJson.getString("fieldName");
                if (StringUtils.equals(key, fieldName)) {
                    return condJson.get("fieldValue");
                }
            }
        }
        return null;
    }
}

package com.yisutech.iisp.toolkit.express;

import com.yisutech.iisp.toolkit.express.expr.EvaluateExpressionManager;
import java.util.Map;

/**
 * @author guangzhong.wgz
 */
public class ExpressEngine {

    public boolean run(String express, Map<String, Object> env) {
        Object obj = EvaluateExpressionManager.execute(express, env);
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        throw new RuntimeException("AviatorEvaluator.execute result is not Boolean");
    }

    public Object runWithObject(String express, Map<String, Object> env) {
        return EvaluateExpressionManager.execute(express, env);
    }

}

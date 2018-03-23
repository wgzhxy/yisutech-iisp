package com.yisutech.iisp.toolkit.utils;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.tuple.MutablePair;
import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Map;
import java.util.Set;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.toolkit.utils.ValidUtil
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-03-22 下午8:12
 **/
public class ValidUtil {

    /**
     * 校验所有对象属性
     *
     * @param pojoBean Java Pojo对象
     * @return {@link Map<String, MutablePair>}
     * ps :
     * 字段: <false, 校验消息>
     */
    public static Map<String, MutablePair> allValid(Object pojoBean) {
        Set<ConstraintViolation<Object>> validResult = getValidator(false).validate(pojoBean);
        Map<String, MutablePair> validRts = Maps.newHashMap();
        validResult.forEach(result -> {
            validRts.put(result.getPropertyPath().toString(), MutablePair.of(false, result.getMessage()));
        });
        return validRts;
    }

    /**
     * 快速检查对象
     * <p>
     * ps:
     * 有一个属性检查未通过就返回
     *
     * @param pojoBean Java Pojo对象
     * @return {@link MutablePair}
     * <p>
     * ps:
     * 字段: <false, 校验消息>
     */
    public static MutablePair fastValid(Object pojoBean) {
        Set<ConstraintViolation<Object>> validResult = getValidator(true).validate(pojoBean);
        if (validResult.isEmpty()) {
            return null;
        }
        ConstraintViolation constraintViolation = validResult.iterator().next();
        return MutablePair.of(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
    }

    /**
     * 获取验证器
     *
     * @param fast
     * @return {@link Validator}
     */
    private static Validator getValidator(Boolean fast) {
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .failFast(fast)
                .buildValidatorFactory();
        return validatorFactory.getValidator();
    }
}

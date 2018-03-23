package com.yisutech.iisp.toolkit.utils;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.tuple.MutablePair;
import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 版权：Copyright by www.yisutech.com
 * 文件名：com.yisutech.iisp.toolkit.utils.ValidUtil
 * 描述：
 *
 * @author guangzhong.wgz
 * @create 2018-03-22 下午8:12
 **/
public class ValidUtil {

    public static Validator getValidator(Boolean fast) {
        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .failFast(true)
                .buildValidatorFactory();
        return validatorFactory.getValidator();
    }

    public List<String> valid(Object validObj, Boolean fast) {
        Set<ConstraintViolation<Object>> validResult = getValidator(false).validate(validObj);
        return validResult.stream().map(result -> result.getMessage()).collect(Collectors.toList());
    }

    public static Map<String, MutablePair> allValid(Object validObj) {
        Set<ConstraintViolation<Object>> validResult = getValidator(true).validate(validObj);
        Map<String, MutablePair> validRts = Maps.newHashMap();
        validResult.forEach(result -> {
            validRts.put(result.getPropertyPath().toString(), MutablePair.of(false, result.getMessage()));
        });
        return validRts;
    }

    public static MutablePair fastValid(Object validObj) {
        Set<ConstraintViolation<Object>> validResult = getValidator(false).validate(validObj);
        if (validResult.isEmpty()) {
            return null;
        }
        ConstraintViolation constraintViolation = validResult.iterator().next();
        return MutablePair.of(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
    }
}

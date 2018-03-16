package com.yisutech.iisp.toolkit.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

/**
 * @author guangzhong.wgz
 */
public class BeanTools extends BeanUtils {

    public static void copyPropertiesInclude(Object source, Object target, String... includeProperties) {
        copyPropertiesInclude(source, target, (Class) null, includeProperties);
    }

    private static void copyPropertiesInclude(Object source, Object target, Class<?> editable,
                                              String... includeProperties)
            throws BeansException {
        Assert.notNull(source, "Source must not be null");
        Assert.notNull(target, "Target must not be null");
        Class actualEditable = target.getClass();
        if (editable != null) {
            if (!editable.isInstance(target)) {
                throw new IllegalArgumentException("Target class [" + target.getClass().getName()
                        + "] not assignable to Editable class [" + editable.getName() + "]");
            }

            actualEditable = editable;
        }

        PropertyDescriptor[] targetPds = getPropertyDescriptors(actualEditable);
        List includeList = includeProperties != null ? Arrays.asList(includeProperties) : null;
        PropertyDescriptor[] arr$ = targetPds;
        int len$ = targetPds.length;

        for (int i$ = 0; i$ < len$; ++i$) {
            PropertyDescriptor targetPd = arr$[i$];
            Method writeMethod = targetPd.getWriteMethod();
            if (writeMethod != null && (includeProperties == null || includeList.contains(targetPd.getName()))) {
                PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
                if (sourcePd != null) {
                    Method readMethod = sourcePd.getReadMethod();
                    if (readMethod != null && ClassUtils.isAssignable(writeMethod.getParameterTypes()[0],
                            readMethod.getReturnType())) {
                        try {
                            if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                                readMethod.setAccessible(true);
                            }

                            Object ex = readMethod.invoke(source, new Object[0]);
                            if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                                writeMethod.setAccessible(true);
                            }

                            writeMethod.invoke(target, new Object[] { ex });
                        } catch (Throwable var15) {
                            throw new FatalBeanException(
                                    "Could not copy property \'" + targetPd.getName() + "\' from source to target",
                                    var15);
                        }
                    }
                }
            }
        }
    }
}

/*
 * Copyright (c) 2018. CK. All rights reserved.
 */

package com.github.fartherp.framework.common.validate;

import org.hibernate.validator.HibernateValidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;
import java.util.Set;

/**
 * 验证工具类
 * Author: CK
 * Date: 2015/9/29
 */
public class ValidateUtils {

    /**
     * 默认模式（非快速失败，所有验证一起返回）
     * @param bean 对象
     * @param groups 分组
     * @param <T> 泛型
     */
    public static <T> void validate(T bean, Class<?>... groups) {
        validate(bean, true, groups);
    }

    /**
     * 返回模式
     * @param bean 对象
     * @param flag true: 快速失败返回模式    false: 普通模式
     * @param groups 分组
     * @param <T> 泛型
     */
    public static <T> void validate(T bean, boolean flag, Class<?>... groups) {
        StringBuilder sb = new StringBuilder();

        Class<?>[] group = (groups == null || groups.length ==0) ? new Class[]{Default.class} : groups;

        ValidatorFactory validatorFactory = Validation.byProvider(HibernateValidator.class).configure().failFast(flag).buildValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(bean, group);
        if (!constraintViolations.isEmpty()) {
            for (ConstraintViolation<T> constraint : constraintViolations) {
				sb.append(constraint.getMessage());
				sb.append(",");
            }
        }

        if (sb.length() > 0) {
            throw new IllegalArgumentException(sb.deleteCharAt(sb.length() - 1).toString());
        }
    }
}

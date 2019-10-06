package com.video.service.exception.annotation;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NotEmptyRequestValidator implements
        ConstraintValidator<NotEmptyRequest, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isBlank(value)) {
            throw new IllegalArgumentException("The input parameter is empty!");
        }
        return true;
    }
}

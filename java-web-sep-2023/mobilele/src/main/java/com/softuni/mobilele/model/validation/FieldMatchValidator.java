package com.softuni.mobilele.model.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {

    private String firstField;
    private String secondField;
    private String message;

    @Override
    public void initialize(FieldMatch constraintAnnotation) {
        this.firstField = constraintAnnotation.firstField();
        this.secondField = constraintAnnotation.secondField();
        this.message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        BeanWrapper beanWrapper = PropertyAccessorFactory
                .forBeanPropertyAccess(value);

        Object firstValue = beanWrapper.getPropertyValue(firstField);
        Object secondValue = beanWrapper.getPropertyValue(secondField);

        boolean valid;

        if(firstValue == null) {
            valid = secondValue == null;
        } else {
            valid = firstValue.equals(secondValue);
        }

        if(!valid) {
            context.buildConstraintViolationWithTemplate(message)
                    .addPropertyNode(secondField)
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
        }

        return valid;
    }
}

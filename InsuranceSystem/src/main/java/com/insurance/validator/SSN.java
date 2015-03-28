package com.insurance.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = SSNValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface SSN {
  
      
    String message() default "{SSN}";
      
    Class<?>[] groups() default {};
    Class<?> entity();
      
    Class<? extends Payload>[] payload() default {};
       
}
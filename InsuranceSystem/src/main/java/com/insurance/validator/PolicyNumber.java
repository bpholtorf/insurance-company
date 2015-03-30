package com.insurance.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
 


import javax.validation.Constraint;
import javax.validation.Payload;
 
@Documented
@Constraint(validatedBy = PolicyNumberValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PolicyNumber {
  
      
    String message() default "{policyNumber}";
      
    Class<?>[] groups() default {};
    Class<?> entity();
      
    Class<? extends Payload>[] payload() default {};

       
}
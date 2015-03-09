package com.insurance.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {
	
	

	@Override
	public void initialize(Password arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		// TODO Auto-generated method stub
		String PASSWORD_PATTERN = 
	              "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
		Pattern pattern=Pattern.compile(PASSWORD_PATTERN);
		Matcher matcher=pattern.matcher(arg0);
		return matcher.matches();
	}

}

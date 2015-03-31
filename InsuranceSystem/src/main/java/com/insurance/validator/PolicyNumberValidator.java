package com.insurance.validator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

public class PolicyNumberValidator implements ConstraintValidator<PolicyNumber, String>{
    
	@Autowired
	private DataSource dataSource;
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void initialize(PolicyNumber constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		String sqlString="SELECT * FROM Insurance_Policy where PolicyNumber="+"'"+value+"'";
		Connection conn=null;
		try {
			System.out.println(dataSource);
			conn=dataSource.getConnection();
			PreparedStatement ps=conn.prepareStatement(sqlString);
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
				rs.close();
				ps.close();
				conn.close();
				return false;
			}
			rs.close();
			ps.close();
			conn.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return false;

	}

}

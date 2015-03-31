package com.insurance.validator;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

public class UsernameValidator implements ConstraintValidator<Username, String> {
	@Autowired
	private DataSource dataSource;
	

	@Override
	public void initialize(Username arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String arg0, ConstraintValidatorContext arg1) {
		// TODO Auto-generated method stub
		
		String sqlString="SELECT * FROM Staff where username="+"'"+arg0+"'";
		Connection conn=null;
		try {
			System.out.print(dataSource);
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
	

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}

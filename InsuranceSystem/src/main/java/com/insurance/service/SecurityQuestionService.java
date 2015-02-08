package com.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.dao.SecurityQuestionDao;
import com.insurance.data.SecurityQuestionDB;

@Service
public class SecurityQuestionService {
  @Autowired
  private SecurityQuestionDao securityQuestionDao;
  public List<SecurityQuestionDB> findAll()
  {
	  return securityQuestionDao.findAll();
  }
}

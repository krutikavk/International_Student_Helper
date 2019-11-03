package com.isshelper.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.isshelper.dao.IssHelperDaoImplementation;
import com.isshelper.exception.IssHelperException;
import com.isshelper.input.IssHelperStudentSignUpInputVO;

public class IssHelperService {
@Autowired
IssHelperDaoImplementation issHelperDaoImplementation;
	public void signUp(IssHelperStudentSignUpInputVO issHelperStudentSignUpInputVO) throws IssHelperException {
		issHelperDaoImplementation.signUp(issHelperStudentSignUpInputVO);

	}

}

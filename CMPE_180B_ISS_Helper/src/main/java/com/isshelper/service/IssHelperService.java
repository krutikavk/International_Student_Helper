package com.isshelper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isshelper.dao.IssHelperDaoImplementation;
import com.isshelper.exception.IssHelperException;
import com.isshelper.input.IssHelperStudentSignUpInputVO;
import com.isshelper.pojo.Student;

@Service
public class IssHelperService {
	@Autowired
	IssHelperDaoImplementation issHelperDaoImplementation;

	@Autowired
	Student student;

	public void signUp(IssHelperStudentSignUpInputVO issHelperStudentSignUpInputVO) throws IssHelperException {

		
		student.setS_Id(Integer.parseInt(issHelperStudentSignUpInputVO.getStudent_ID()));
		student.setS_Email(issHelperStudentSignUpInputVO.getEmail());
		student.setS_Name((issHelperStudentSignUpInputVO.getName()));
		student.setS_University(Integer.parseInt(issHelperStudentSignUpInputVO.getUniversity()));
		student.setS_Phone(Long.parseLong(issHelperStudentSignUpInputVO.getPhone()));

		issHelperDaoImplementation.signUp(student);

	}

}

package com.isshelper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.isshelper.dao.IssHelperDaoImplementation;
import com.isshelper.exception.IssHelperException;
import com.isshelper.input.IssHelperRiderSignUpInputVO;
import com.isshelper.input.IssHelperStudentRideRequest;
import com.isshelper.input.IssHelperStudentSignUpInputVO;
import com.isshelper.output.IssHelperOutput;
import com.isshelper.output.IssHelperStudentSignUpOutputVO;
import com.isshelper.pojo.Student;

@Service
public class IssHelperService {
	@Autowired
	IssHelperDaoImplementation issHelperDaoImplementation;

	@Autowired
	Student student;

	public IssHelperOutput studentSignUp(IssHelperStudentSignUpInputVO issHelperStudentSignUpInputVO)
			throws IssHelperException {

		return issHelperDaoImplementation.studentSignUp(issHelperStudentSignUpInputVO);

	}

	public IssHelperOutput riderSignUp(IssHelperRiderSignUpInputVO issHelperRiderSignUpInputVO)
			throws IssHelperException {

		return issHelperDaoImplementation.riderSignUp(issHelperRiderSignUpInputVO);

	}

	public IssHelperOutput studentRideRequest(IssHelperStudentRideRequest issHelperStudentRideRequest)
			throws IssHelperException {

		return issHelperDaoImplementation.studentRideRequest(issHelperStudentRideRequest);

	}

}

package com.isshelper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isshelper.dao.IssHelperDaoImplementation;
import com.isshelper.exception.IssHelperException;
import com.isshelper.input.IssHelperBookAlreadyBookedRidesForStudent;
import com.isshelper.input.IssHelperBookRideForStudentInputVO;
import com.isshelper.input.IssHelperGetAlreadyBookedRidesForStudentInputVO;
import com.isshelper.input.IssHelperGetBrandNewRidesPostedByProviderInputVO;
import com.isshelper.input.IssHelperLoginInput;
import com.isshelper.input.IssHelperProviderViewRidesPostedByStudentInputVO;
import com.isshelper.input.IssHelperRiderSignUpInputVO;
import com.isshelper.input.IssHelperRidesPostedByProvider;
import com.isshelper.input.IssHelperStudentRideRequest;
import com.isshelper.input.IssHelperStudentSignUpInputVO;
import com.isshelper.output.IssHelperGetAlreadyBookedRidesForStudentOutputVO;
import com.isshelper.output.IssHelperGetBrandNewRidesPostedByProviderOutputVO;
import com.isshelper.output.IssHelperLoginOutput;
import com.isshelper.output.IssHelperOutput;
import com.isshelper.output.IssHelperProviderViewRidesPostedByStudentOutputVO;
import com.isshelper.output.IssHelperRidesBookedByStudent;
import com.isshelper.output.IssHelperRidesPostedByStudentOutputVO;
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

	public IssHelperOutput providerRidePost(IssHelperRidesPostedByProvider issHelperRidesPostedByProvider)
			throws IssHelperException {

		return issHelperDaoImplementation.providerRidePost(issHelperRidesPostedByProvider);

	}

	public List<IssHelperRidesPostedByStudentOutputVO> ridesPostedByStudent(String student_ID)
			throws IssHelperException {

		return issHelperDaoImplementation.ridesPostedByStudent(student_ID);
	}

	public IssHelperLoginOutput login(IssHelperLoginInput issHelperLoginInput) throws IssHelperException {

		return issHelperDaoImplementation.login(issHelperLoginInput);
	}

	public List<IssHelperRidesBookedByStudent> ridesBookedByStudent(String student_ID) throws IssHelperException

	{
		return issHelperDaoImplementation.ridesBookedByStudent(student_ID);
	}

	public List<IssHelperGetBrandNewRidesPostedByProviderOutputVO> getBrandNewRidesPostedByProvider(
			IssHelperGetBrandNewRidesPostedByProviderInputVO issHelperGetBrandNewRidesPostedByProviderInputVO)
			throws IssHelperException {

		return issHelperDaoImplementation
				.getBrandNewRidesPostedByProvider(issHelperGetBrandNewRidesPostedByProviderInputVO);
	}

	public IssHelperOutput bookRideForStudent(IssHelperBookRideForStudentInputVO issHelperBookRideForStudentInputVO)
			throws IssHelperException {

		return issHelperDaoImplementation.bookRideForStudent(issHelperBookRideForStudentInputVO);
	}

	public List<IssHelperGetAlreadyBookedRidesForStudentOutputVO> getAlreadyBookedRidesForStudent(
			IssHelperGetAlreadyBookedRidesForStudentInputVO issHelperGetAlreadyBookedRidesForStudentInputVO)
			throws IssHelperException {

		return issHelperDaoImplementation
				.getAlreadyBookedRidesForStudent(issHelperGetAlreadyBookedRidesForStudentInputVO);
	}

	public IssHelperOutput bookAlreadyBookedRidesForStudent(
			IssHelperBookAlreadyBookedRidesForStudent issHelperBookAlreadyBookedRidesForStudent)
			throws IssHelperException {

		return issHelperDaoImplementation.bookAlreadyBookedRidesForStudent(issHelperBookAlreadyBookedRidesForStudent);
	}

	public List<IssHelperProviderViewRidesPostedByStudentOutputVO> providerViewRidesPostedByStudent(
			IssHelperProviderViewRidesPostedByStudentInputVO issHelperProviderViewRidesPostedByStudentByIntputVO)
			throws IssHelperException {

		return issHelperDaoImplementation
				.providerViewRidesPostedByStudent(issHelperProviderViewRidesPostedByStudentByIntputVO);

	}

}

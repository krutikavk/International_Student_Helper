package com.isshelper.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import com.isshelper.input.IssHelperStudentRideAcceptedByProviderInputVO;
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
	
	private static final Logger log = LoggerFactory.getLogger(IssHelperService.class);
	@Autowired
	IssHelperDaoImplementation issHelperDaoImplementation;

	@Autowired
	Student student;

	public IssHelperOutput studentSignUp(IssHelperStudentSignUpInputVO issHelperStudentSignUpInputVO)
			throws IssHelperException {
		
		log.info("Student SignUp called");
		return issHelperDaoImplementation.studentSignUp(issHelperStudentSignUpInputVO);

	}

	public IssHelperOutput riderSignUp(IssHelperRiderSignUpInputVO issHelperRiderSignUpInputVO)
			throws IssHelperException {

		log.info("Ride Provider SignUp called");
		return issHelperDaoImplementation.riderSignUp(issHelperRiderSignUpInputVO);

	}

	public IssHelperOutput studentRideRequest(IssHelperStudentRideRequest issHelperStudentRideRequest)
			throws IssHelperException {

		log.info("Student Ride Request called");
		return issHelperDaoImplementation.studentRideRequest(issHelperStudentRideRequest);

	}

	public IssHelperOutput providerRidePost(IssHelperRidesPostedByProvider issHelperRidesPostedByProvider)
			throws IssHelperException {

		log.info("Rides Posted by Provider called");
		return issHelperDaoImplementation.providerRidePost(issHelperRidesPostedByProvider);

	}

	public List<IssHelperRidesPostedByStudentOutputVO> ridesPostedByStudent(String student_ID)
			throws IssHelperException {

		log.info("Rides Posted by Student called");
		return issHelperDaoImplementation.ridesPostedByStudent(student_ID);
	}

	public IssHelperLoginOutput login(IssHelperLoginInput issHelperLoginInput) throws IssHelperException {

		log.info("Login called");
		return issHelperDaoImplementation.login(issHelperLoginInput);
	}

	public List<IssHelperRidesBookedByStudent> ridesBookedByStudent(String student_ID) throws IssHelperException

	{
		log.info("Rides Booked by Student called");
		return issHelperDaoImplementation.ridesBookedByStudent(student_ID);
	}

	public List<IssHelperGetBrandNewRidesPostedByProviderOutputVO> getBrandNewRidesPostedByProvider(
			IssHelperGetBrandNewRidesPostedByProviderInputVO issHelperGetBrandNewRidesPostedByProviderInputVO)
			throws IssHelperException {

		log.info("Brand New Rides Posted by Provider called");
		return issHelperDaoImplementation
				.getBrandNewRidesPostedByProvider(issHelperGetBrandNewRidesPostedByProviderInputVO);
	}

	public IssHelperOutput bookRideForStudent(IssHelperBookRideForStudentInputVO issHelperBookRideForStudentInputVO)
			throws IssHelperException {

		log.info("Book Rides for Student called");
		return issHelperDaoImplementation.bookRideForStudent(issHelperBookRideForStudentInputVO);
	}

	public List<IssHelperGetAlreadyBookedRidesForStudentOutputVO> getAlreadyBookedRidesForStudent(
			IssHelperGetAlreadyBookedRidesForStudentInputVO issHelperGetAlreadyBookedRidesForStudentInputVO)
			throws IssHelperException {

		log.info("Get already Booked Rides by Student called");
		return issHelperDaoImplementation
				.getAlreadyBookedRidesForStudent(issHelperGetAlreadyBookedRidesForStudentInputVO);
	}

	public IssHelperOutput bookAlreadyBookedRidesForStudent(
			IssHelperBookAlreadyBookedRidesForStudent issHelperBookAlreadyBookedRidesForStudent)
			throws IssHelperException {

		log.info("Book Already Booked Rides called");
		return issHelperDaoImplementation.bookAlreadyBookedRidesForStudent(issHelperBookAlreadyBookedRidesForStudent);
	}

	public List<IssHelperProviderViewRidesPostedByStudentOutputVO> providerViewRidesPostedByStudent(
			IssHelperProviderViewRidesPostedByStudentInputVO issHelperProviderViewRidesPostedByStudentByIntputVO)
			throws IssHelperException {

		log.info("Ride Provider Viewing Rides Posted by Student called");
		return issHelperDaoImplementation
				.providerViewRidesPostedByStudent(issHelperProviderViewRidesPostedByStudentByIntputVO);

	}

	public IssHelperOutput studentRidePostedAcceptedByProvider(
			IssHelperStudentRideAcceptedByProviderInputVO issHelperStudentRideAcceptedByProviderInputVO)
			throws IssHelperException {

		return issHelperDaoImplementation
				.studentRidePostedAcceptedByProvider(issHelperStudentRideAcceptedByProviderInputVO);
	}
}

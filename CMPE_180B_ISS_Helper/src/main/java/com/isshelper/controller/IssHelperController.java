
//SJSU CMPE 138 Fall2019 TEAM8
package com.isshelper.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.isshelper.exception.IssHelperException;
import com.isshelper.input.IssHelperBookAlreadyBookedRidesForStudent;
import com.isshelper.input.IssHelperBookRideForStudentInputVO;
import com.isshelper.input.IssHelperGetAlreadyBookedRidesForStudentInputVO;
import com.isshelper.input.IssHelperGetBrandNewRidesPostedByProviderInputVO;
import com.isshelper.input.IssHelperLoginInput;
import com.isshelper.input.IssHelperProviderViewRidesPostedByStudentInputVO;
import com.isshelper.input.IssHelperRiderSignUpInputVO;
import com.isshelper.input.IssHelperRidesBookedByStudentInputVO;
import com.isshelper.input.IssHelperRidesPostedAndAcceptedByProviderInputVO;
import com.isshelper.input.IssHelperRidesPostedByProvider;
import com.isshelper.input.IssHelperStudentRideAcceptedByProviderInputVO;
import com.isshelper.input.IssHelperStudentRideRequest;
import com.isshelper.input.IssHelperStudentSignUpInputVO;
import com.isshelper.output.IssHelperAppartmentsOutputVO;
import com.isshelper.output.IssHelperGetAlreadyBookedRidesForStudentOutputVO;
import com.isshelper.output.IssHelperGetBrandNewRidesPostedByProviderOutputVO;
import com.isshelper.output.IssHelperLoginOutput;
import com.isshelper.output.IssHelperOutput;
import com.isshelper.output.IssHelperProviderDashBoardRidesAcceptedByProviderOutputVO;
import com.isshelper.output.IssHelperProviderDashBoardRidesPostedByProviderOutputVO;
import com.isshelper.output.IssHelperProviderViewRidesPostedByStudentOutputVO;
import com.isshelper.output.IssHelperRidesBookedByStudent;
import com.isshelper.output.IssHelperRidesPostedByStudentOutputVO;
import com.isshelper.service.IssHelperService;
import com.isshelper.utils.ApplicationsConstants;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/IssHelper")
public class IssHelperController {

	private static final Logger log = LoggerFactory.getLogger(IssHelperController.class);

	@Autowired
	IssHelperService issHelperService;

	IssHelperOutput issHelperOutput;

	IssHelperLoginOutput issHelperLoginOutput;

	/*
	 * @Autowired IssHelperMailNotificationHelper IssHelperMailNotificationHelper;
	 */
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(path = "/StudentSignUp")
	@ResponseBody
	@PostMapping
	public ResponseEntity<IssHelperOutput> studentSignUp(
			@RequestBody IssHelperStudentSignUpInputVO issHelperStudentSignUpInputVO) {
		ResponseEntity<IssHelperOutput> responseEntity;
		issHelperOutput = new IssHelperOutput();
		try {
			issHelperOutput = issHelperService.studentSignUp(issHelperStudentSignUpInputVO);
			log.info("Student SignUp InputVO" + issHelperStudentSignUpInputVO);

			responseEntity = new ResponseEntity<IssHelperOutput>(issHelperOutput, HttpStatus.OK);
		} catch (IssHelperException e) {
			// System.out.println(e.getMessage());
			issHelperOutput.setMessage(e.getMessage());
			log.error("Student SignUp InputVO" + issHelperStudentSignUpInputVO.toString());
			responseEntity = new ResponseEntity<IssHelperOutput>(issHelperOutput, HttpStatus.FORBIDDEN);
			return responseEntity;
		}
		return responseEntity;

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/RideProviderSignUp")
	public ResponseEntity<IssHelperOutput> rideProviderSignUp(
			@RequestBody IssHelperRiderSignUpInputVO issHelperRiderSignUpInputVO) {
		issHelperOutput = new IssHelperOutput();
		ResponseEntity<IssHelperOutput> responseEntity;
		try {
			issHelperOutput = issHelperService.riderSignUp(issHelperRiderSignUpInputVO);
			log.info("Ride Provider SignUp InputVO " + issHelperRiderSignUpInputVO.toString());
			responseEntity = new ResponseEntity<IssHelperOutput>((IssHelperOutput) issHelperOutput, HttpStatus.OK);
			return responseEntity;
		} catch (IssHelperException e) {
			// TODO: handle exception
			issHelperOutput.setMessage(e.getMessage());
			log.error("Ride Provider SignUp InputVO " + issHelperRiderSignUpInputVO.toString());
			responseEntity = new ResponseEntity<IssHelperOutput>(issHelperOutput, HttpStatus.FORBIDDEN);
			return responseEntity;
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/StudentRideRequest")
	public ResponseEntity<IssHelperOutput> studentRideRequest(
			@RequestBody IssHelperStudentRideRequest issHelperStudentRideRequest) {
		issHelperOutput = new IssHelperOutput();
		ResponseEntity<IssHelperOutput> responseEntity;
		try {
			issHelperOutput = issHelperService.studentRideRequest(issHelperStudentRideRequest);
			log.info("Student Ride Request InputVO " + issHelperStudentRideRequest.toString());
			responseEntity = new ResponseEntity<IssHelperOutput>((IssHelperOutput) issHelperOutput, HttpStatus.OK);
			return responseEntity;
		} catch (IssHelperException e) {
			// TODO: handle exception
			issHelperOutput.setMessage(e.getMessage());
			log.error("Student Ride Request InputVO " + issHelperStudentRideRequest.toString());
			responseEntity = new ResponseEntity<IssHelperOutput>(issHelperOutput, HttpStatus.FORBIDDEN);
			return responseEntity;
		}

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/ProviderRidePost")
	public ResponseEntity<IssHelperOutput> providerRidePost(
			@RequestBody IssHelperRidesPostedByProvider issHelperRidesPostedByProvider) {
		issHelperOutput = new IssHelperOutput();
		ResponseEntity<IssHelperOutput> responseEntity;
		try {
			issHelperOutput = issHelperService.providerRidePost(issHelperRidesPostedByProvider);
			log.info("Student SignUp InputVO " + issHelperRidesPostedByProvider.toString());
			responseEntity = new ResponseEntity<IssHelperOutput>((IssHelperOutput) issHelperOutput, HttpStatus.OK);
			return responseEntity;
		} catch (IssHelperException e) {
			// TODO: handle exception
			issHelperOutput.setMessage(e.getMessage());
			log.error("Student SignUp InputVO " + issHelperRidesPostedByProvider.toString());
			responseEntity = new ResponseEntity<IssHelperOutput>(issHelperOutput, HttpStatus.FORBIDDEN);
			return responseEntity;
		}

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/Login")
	public ResponseEntity<IssHelperLoginOutput> login(@RequestBody IssHelperLoginInput issHelperLoginInput)
			throws IssHelperException {
		ResponseEntity<IssHelperLoginOutput> responseEntity;
		issHelperLoginOutput = new IssHelperLoginOutput();
		try {
			issHelperLoginOutput = issHelperService.login(issHelperLoginInput);
			log.info("Login InputVO " + issHelperLoginInput.toString());
			if (issHelperLoginOutput.getEmail() != null)
				issHelperLoginOutput.setMessage(ApplicationsConstants.SUCCESS);
			else
				issHelperLoginOutput.setMessage(ApplicationsConstants.FAILURE);
			responseEntity = new ResponseEntity<IssHelperLoginOutput>(issHelperLoginOutput, HttpStatus.OK);
			return responseEntity;
		} catch (IssHelperException e) {
			issHelperLoginOutput.setMessage(e.getMessage());
			log.error("Login InputVO " + issHelperLoginInput.toString());
			responseEntity = new ResponseEntity<IssHelperLoginOutput>(issHelperLoginOutput, HttpStatus.FORBIDDEN);
			return responseEntity;
		}
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/Dashboard/RidesBookedByStudent")
	public ResponseEntity<List<IssHelperRidesBookedByStudent>> ridesBookedByStudent(
			@RequestBody IssHelperRidesBookedByStudentInputVO issHelperRidesBookedByStudentInputVO) {

		ResponseEntity<List<IssHelperRidesBookedByStudent>> responseEntity;
		try {
			log.info("Rides Booked By Student InputVO" + issHelperRidesBookedByStudentInputVO.toString());
			List<IssHelperRidesBookedByStudent> IssHelperRidesBookedByStudentlist = issHelperService
					.ridesBookedByStudent(issHelperRidesBookedByStudentInputVO.getStudent_ID());
			responseEntity = new ResponseEntity<List<IssHelperRidesBookedByStudent>>(IssHelperRidesBookedByStudentlist,
					HttpStatus.OK);
			return responseEntity;
		} catch (Exception e) {
			log.error("Rides Booked By Student " + issHelperRidesBookedByStudentInputVO.toString());
			return responseEntity = null;

		}

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/Dashboard/RidesPostedByStudent")
	public ResponseEntity<List<IssHelperRidesPostedByStudentOutputVO>> ridesPostedByStudent(
			@RequestBody IssHelperRidesBookedByStudentInputVO issHelperRidesBookedByStudentInputVO)
			throws IssHelperException {

		ResponseEntity<List<IssHelperRidesPostedByStudentOutputVO>> responseEntity;
		try {
			List<IssHelperRidesPostedByStudentOutputVO> IssHelperRidesPostedByStudentOutputVOList = issHelperService
					.ridesPostedByStudent(issHelperRidesBookedByStudentInputVO.getStudent_ID());
			responseEntity = new ResponseEntity<List<IssHelperRidesPostedByStudentOutputVO>>(
					IssHelperRidesPostedByStudentOutputVOList, HttpStatus.OK);
			return responseEntity;
		} catch (Exception e) {
			return responseEntity = null;
		}

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/GetBrandNewRidesPostedByProvider")
	public ResponseEntity<List<IssHelperGetBrandNewRidesPostedByProviderOutputVO>> getBrandNewRidesPostedByProvider(
			@RequestBody IssHelperGetBrandNewRidesPostedByProviderInputVO issHelperGetBrandNewRidesPostedByProviderInputVO) {
		ResponseEntity<List<IssHelperGetBrandNewRidesPostedByProviderOutputVO>> responseEntity;

		try {
			log.info("Get brand new Rides posted by provider InputVO "
					+ issHelperGetBrandNewRidesPostedByProviderInputVO.toString());
			List<IssHelperGetBrandNewRidesPostedByProviderOutputVO> issHelperGetBrandNewRidesPostedByProviderOutputVOList = issHelperService
					.getBrandNewRidesPostedByProvider(issHelperGetBrandNewRidesPostedByProviderInputVO);

			responseEntity = new ResponseEntity<List<IssHelperGetBrandNewRidesPostedByProviderOutputVO>>(
					issHelperGetBrandNewRidesPostedByProviderOutputVOList, HttpStatus.OK);
			return responseEntity;
		}

		catch (Exception e) {
			log.error("Get brand new Rides posted by provider InputVO "
					+ issHelperGetBrandNewRidesPostedByProviderInputVO.toString());
			return responseEntity = null;
		}

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/BookRideForStudent")
	public ResponseEntity<IssHelperOutput> bookRideForStudent(
			@RequestBody IssHelperBookRideForStudentInputVO issHelperBookRideForStudentInputVO) {
		ResponseEntity<IssHelperOutput> responseEntity;
		issHelperOutput = new IssHelperOutput();

		try {
			issHelperOutput = issHelperService.bookRideForStudent(issHelperBookRideForStudentInputVO);
			log.info("Book ride for student InputVO " + issHelperBookRideForStudentInputVO.toString());
			responseEntity = new ResponseEntity<IssHelperOutput>(issHelperOutput, HttpStatus.OK);
			return responseEntity;
		} catch (IssHelperException e) {

			issHelperOutput.setMessage(e.getMessage());
			log.error("Book ride for student InputVO " + issHelperBookRideForStudentInputVO.toString());
			responseEntity = new ResponseEntity<IssHelperOutput>(issHelperOutput, HttpStatus.FORBIDDEN);
			return responseEntity;

		}

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/GetAlreadyBookedRidesForStudent")
	public ResponseEntity<List<IssHelperGetAlreadyBookedRidesForStudentOutputVO>> getAlreadyBookedRidesForStudent(
			@RequestBody IssHelperGetAlreadyBookedRidesForStudentInputVO issHelperGetAlreadyBookedRidesForStudentInputVO) {
		ResponseEntity<List<IssHelperGetAlreadyBookedRidesForStudentOutputVO>> responseEntity;

		try {
			log.info("Get already booked rides for student InputVO "
					+ issHelperGetAlreadyBookedRidesForStudentInputVO.toString());
			List<IssHelperGetAlreadyBookedRidesForStudentOutputVO> issHelperGetBrandNewRidesPostedByProviderOutputVOList = issHelperService
					.getAlreadyBookedRidesForStudent(issHelperGetAlreadyBookedRidesForStudentInputVO);

			responseEntity = new ResponseEntity<List<IssHelperGetAlreadyBookedRidesForStudentOutputVO>>(
					issHelperGetBrandNewRidesPostedByProviderOutputVOList, HttpStatus.OK);
			return responseEntity;
		}

		catch (Exception e) {
			log.error("Get already booked rides for student InputVO "
					+ issHelperGetAlreadyBookedRidesForStudentInputVO.toString());
			return responseEntity = null;
		}

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/BookAlreadyBookedRidesForStudent")
	public ResponseEntity<IssHelperOutput> bookAlreadyBookedRidesForStudent(
			@RequestBody IssHelperBookAlreadyBookedRidesForStudent issHelperBookAlreadyBookedRidesForStudent)
			throws IssHelperException {
		ResponseEntity<IssHelperOutput> responseEntity;
		issHelperOutput = new IssHelperOutput();

		try {
			issHelperOutput = issHelperService
					.bookAlreadyBookedRidesForStudent(issHelperBookAlreadyBookedRidesForStudent);
			log.info("Book already booked rides for Student InputVO "
					+ issHelperBookAlreadyBookedRidesForStudent.toString());
			responseEntity = new ResponseEntity<IssHelperOutput>(issHelperOutput, HttpStatus.OK);
			return responseEntity;
		} catch (IssHelperException e) {
			issHelperOutput.setMessage(ApplicationsConstants.FAILURE);
			responseEntity = new ResponseEntity<IssHelperOutput>(issHelperOutput, HttpStatus.FORBIDDEN);
			log.error("Book already booked rides for Student InputVO "
					+ issHelperBookAlreadyBookedRidesForStudent.toString());

			return responseEntity;
		}

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/ProviderViewRidesPostedByStudent")
	public ResponseEntity<List<IssHelperProviderViewRidesPostedByStudentOutputVO>> getProviderViewRidesPostedByStudent(
			@RequestBody IssHelperProviderViewRidesPostedByStudentInputVO issHelperProviderViewRidesPostedByStudentInputVO) {
		ResponseEntity<List<IssHelperProviderViewRidesPostedByStudentOutputVO>> responseEntity;

		try {
			List<IssHelperProviderViewRidesPostedByStudentOutputVO> IssHelperProviderViewRidesPostedByStudentOutputVOList = issHelperService
					.providerViewRidesPostedByStudent(issHelperProviderViewRidesPostedByStudentInputVO);

			responseEntity = new ResponseEntity<List<IssHelperProviderViewRidesPostedByStudentOutputVO>>(
					IssHelperProviderViewRidesPostedByStudentOutputVOList, HttpStatus.OK);
			return responseEntity;
		}

		catch (Exception e) {
			return responseEntity = null;
		}

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/StudentRideAcceptedByProvider")
	public ResponseEntity<IssHelperOutput> studentRidePostedAcceptedByProvider(
			@RequestBody IssHelperStudentRideAcceptedByProviderInputVO issHelperStudentRideAcceptedByProviderInputVO) {

		ResponseEntity<IssHelperOutput> responseEntity;
		issHelperOutput = new IssHelperOutput();

		try {
			issHelperOutput = issHelperService
					.studentRidePostedAcceptedByProvider(issHelperStudentRideAcceptedByProviderInputVO);
			log.info("Book already booked rides for Student InputVO "
					+ issHelperStudentRideAcceptedByProviderInputVO.toString());
			responseEntity = new ResponseEntity<IssHelperOutput>(issHelperOutput, HttpStatus.OK);
			return responseEntity;
		} catch (IssHelperException e) {
			issHelperOutput.setMessage(ApplicationsConstants.FAILURE);
			responseEntity = new ResponseEntity<IssHelperOutput>(issHelperOutput, HttpStatus.FORBIDDEN);
			log.error("Book already booked rides for Student InputVO "
					+ issHelperStudentRideAcceptedByProviderInputVO.toString());

			return responseEntity;
		}

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/Dashboard/RidesPostedByProvider")
	public ResponseEntity<List<IssHelperProviderDashBoardRidesPostedByProviderOutputVO>> ridesPostedByProvider(
			@RequestBody IssHelperRidesPostedAndAcceptedByProviderInputVO issHelperRidesPostedAndAcceptedByProviderInputVO) {

		ResponseEntity<List<IssHelperProviderDashBoardRidesPostedByProviderOutputVO>> responseEntity;
		try {
			log.info("Rides Posted By Provider Input" + issHelperRidesPostedAndAcceptedByProviderInputVO.toString());
			List<IssHelperProviderDashBoardRidesPostedByProviderOutputVO> issHelperProviderDashBoardRidesPostedByProviderOutputVOList = issHelperService
					.providerDashBoardRidesPostedByProvider(issHelperRidesPostedAndAcceptedByProviderInputVO);
			responseEntity = new ResponseEntity<List<IssHelperProviderDashBoardRidesPostedByProviderOutputVO>>(
					issHelperProviderDashBoardRidesPostedByProviderOutputVOList, HttpStatus.OK);
			return responseEntity;
		} catch (Exception e) {
			log.error("Rides Booked By Student " + issHelperRidesPostedAndAcceptedByProviderInputVO.toString());
			return responseEntity = null;

		}

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/Dashboard/RidePostedAcceptedByProvider")
	public ResponseEntity<List<IssHelperProviderDashBoardRidesAcceptedByProviderOutputVO>> ridesAcceptedByProvider(
			@RequestBody IssHelperRidesPostedAndAcceptedByProviderInputVO issHelperRidesPostedAndAcceptedByProviderInputVO) {

		ResponseEntity<List<IssHelperProviderDashBoardRidesAcceptedByProviderOutputVO>> responseEntity;
		try {
			log.info("Rides Posted By Provider Input" + issHelperRidesPostedAndAcceptedByProviderInputVO.toString());
			List<IssHelperProviderDashBoardRidesAcceptedByProviderOutputVO> IssHelperProviderDashBoardRidesAcceptedByProviderOutputVOList = issHelperService
					.providerDashBoardRidesAcceptedByProvider(issHelperRidesPostedAndAcceptedByProviderInputVO);
			responseEntity = new ResponseEntity<List<IssHelperProviderDashBoardRidesAcceptedByProviderOutputVO>>(
					IssHelperProviderDashBoardRidesAcceptedByProviderOutputVOList, HttpStatus.OK);
			return responseEntity;
		} catch (Exception e) {
			log.error("Rides Booked By Student " + issHelperRidesPostedAndAcceptedByProviderInputVO.toString());
			return responseEntity = null;

		}

	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/ViewAppartments")
	public ResponseEntity<List<IssHelperAppartmentsOutputVO>> viewAppartments(
			@RequestBody IssHelperRidesBookedByStudentInputVO issHelperAppartmentInputVO) {

		ResponseEntity<List<IssHelperAppartmentsOutputVO>> responseEntity;
		try {
			log.info("Appartment Input" + issHelperAppartmentInputVO.toString());
			List<IssHelperAppartmentsOutputVO> IssHelperAppartmentsOutputVOList = issHelperService
					.viewAppartments(issHelperAppartmentInputVO);
			responseEntity = new ResponseEntity<List<IssHelperAppartmentsOutputVO>>(IssHelperAppartmentsOutputVOList,
					HttpStatus.OK);
			return responseEntity;
		} catch (Exception e) {
			log.error("Appartments list for Student ");
			return responseEntity = null;

		}

	}

}
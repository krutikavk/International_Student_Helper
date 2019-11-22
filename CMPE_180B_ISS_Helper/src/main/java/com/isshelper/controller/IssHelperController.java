package com.isshelper.controller;

import java.util.List;

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
import com.isshelper.input.IssHelperRiderSignUpInputVO;
import com.isshelper.input.IssHelperRidesBookedByStudentInputVO;
import com.isshelper.input.IssHelperRidesPostedByProvider;
import com.isshelper.input.IssHelperStudentRideRequest;
import com.isshelper.input.IssHelperStudentSignUpInputVO;
import com.isshelper.output.IssHelperGetAlreadyBookedRidesForStudentOutputVO;
import com.isshelper.output.IssHelperGetBrandNewRidesPostedByProviderOutputVO;
import com.isshelper.output.IssHelperLoginOutput;
import com.isshelper.output.IssHelperOutput;
import com.isshelper.output.IssHelperRidesBookedByStudent;
import com.isshelper.service.IssHelperService;
import com.isshelper.utils.ApplicationsConstants;

@RestController
@RequestMapping(path = "/IssHelper")
public class IssHelperController {

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
			responseEntity = new ResponseEntity<IssHelperOutput>(issHelperOutput, HttpStatus.OK);
		} catch (IssHelperException e) {
			// System.out.println(e.getMessage());
			issHelperOutput.setMessage(e.getMessage());
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
			responseEntity = new ResponseEntity<IssHelperOutput>((IssHelperOutput) issHelperOutput, HttpStatus.OK);
			return responseEntity;
		} catch (IssHelperException e) {
			// TODO: handle exception
			issHelperOutput.setMessage(e.getMessage());
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
			responseEntity = new ResponseEntity<IssHelperOutput>((IssHelperOutput) issHelperOutput, HttpStatus.OK);
			return responseEntity;
		} catch (IssHelperException e) {
			// TODO: handle exception
			issHelperOutput.setMessage(e.getMessage());
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
			responseEntity = new ResponseEntity<IssHelperOutput>((IssHelperOutput) issHelperOutput, HttpStatus.OK);
			return responseEntity;
		} catch (IssHelperException e) {
			// TODO: handle exception
			issHelperOutput.setMessage(e.getMessage());
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
			if (issHelperLoginOutput.getEmail() != null)
				issHelperLoginOutput.setMessage(ApplicationsConstants.SUCCESS);
			else
				issHelperLoginOutput.setMessage(ApplicationsConstants.FAILURE);
			responseEntity = new ResponseEntity<IssHelperLoginOutput>(issHelperLoginOutput, HttpStatus.OK);
			return responseEntity;
		} catch (IssHelperException e) {
			issHelperLoginOutput.setMessage(e.getMessage());
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
			List<IssHelperRidesBookedByStudent> IssHelperRidesBookedByStudentlist = issHelperService
					.ridesBookedByStudent(issHelperRidesBookedByStudentInputVO.getStudent_ID());
			responseEntity = new ResponseEntity<List<IssHelperRidesBookedByStudent>>(IssHelperRidesBookedByStudentlist,
					HttpStatus.OK);
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
			List<IssHelperGetBrandNewRidesPostedByProviderOutputVO> issHelperGetBrandNewRidesPostedByProviderOutputVOList = issHelperService
					.getBrandNewRidesPostedByProvider(issHelperGetBrandNewRidesPostedByProviderInputVO);

			responseEntity = new ResponseEntity<List<IssHelperGetBrandNewRidesPostedByProviderOutputVO>>(
					issHelperGetBrandNewRidesPostedByProviderOutputVOList, HttpStatus.OK);
			return responseEntity;
		}

		catch (Exception e) {
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

			responseEntity = new ResponseEntity<IssHelperOutput>(issHelperOutput, HttpStatus.OK);
			return responseEntity;
		} catch (IssHelperException e) {

			issHelperOutput.setMessage(e.getMessage());
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
			List<IssHelperGetAlreadyBookedRidesForStudentOutputVO> issHelperGetBrandNewRidesPostedByProviderOutputVOList = issHelperService
					.getAlreadyBookedRidesForStudent(issHelperGetAlreadyBookedRidesForStudentInputVO);

			responseEntity = new ResponseEntity<List<IssHelperGetAlreadyBookedRidesForStudentOutputVO>>(
					issHelperGetBrandNewRidesPostedByProviderOutputVOList, HttpStatus.OK);
			return responseEntity;
		}

		catch (Exception e) {
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

			responseEntity = new ResponseEntity<IssHelperOutput>(issHelperOutput, HttpStatus.OK);
			return responseEntity;
		} catch (IssHelperException e) {

			issHelperOutput.setMessage(ApplicationsConstants.FAILURE);
			responseEntity = new ResponseEntity<IssHelperOutput>(issHelperOutput, HttpStatus.FORBIDDEN);
			return responseEntity;

		}

	}
}
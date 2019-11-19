package com.isshelper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.isshelper.exception.IssHelperException;
import com.isshelper.input.IssHelperLoginInput;
import com.isshelper.input.IssHelperRiderSignUpInputVO;
import com.isshelper.input.IssHelperRidesPostedByProvider;
import com.isshelper.input.IssHelperStudentRideRequest;
import com.isshelper.input.IssHelperStudentSignUpInputVO;
import com.isshelper.output.IssHelperLoginOutput;
import com.isshelper.output.IssHelperOutput;
import com.isshelper.service.IssHelperService;
import com.isshelper.utils.ApplicationsConstants;

@RestController
@RequestMapping(path = "/IssHelper")
public class IssHelperController {

	@Autowired
	IssHelperService issHelperService;

	IssHelperOutput issHelperOutput;

	IssHelperLoginOutput issHelperLoginOutput;

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

	@RequestMapping("/RideProviderSignup")
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
}

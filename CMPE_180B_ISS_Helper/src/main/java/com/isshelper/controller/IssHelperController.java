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
import com.isshelper.input.IssHelperRiderSignUpInputVO;
import com.isshelper.input.IssHelperRidesPostedByProvider;
import com.isshelper.input.IssHelperStudentRideRequest;
import com.isshelper.input.IssHelperStudentSignUpInputVO;
import com.isshelper.output.IssHelperOutput;
import com.isshelper.output.IssHelperStudentSignUpOutputVO;
import com.isshelper.service.IssHelperService;
import com.isshelper.utils.ApplicationsConstants;

@RestController
@RequestMapping(path = "/IssHelper")
public class IssHelperController {

	@Autowired
	IssHelperService issHelperService;
	@Autowired
	IssHelperOutput issHelperOutput;

	@RequestMapping(path = "/StudentSignUp")
	@ResponseBody
	@PostMapping
	public ResponseEntity<IssHelperOutput> studentSignUp(
			@RequestBody IssHelperStudentSignUpInputVO issHelperStudentSignUpInputVO) {
		ResponseEntity<IssHelperOutput> responseEntity;
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
}

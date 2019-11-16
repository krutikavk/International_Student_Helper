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
import com.isshelper.input.IssHelperStudentSignUpInputVO;
import com.isshelper.output.IssHelperStudentSignUpOutputVO;
import com.isshelper.service.IssHelperService;
import com.isshelper.utils.ApplicationsConstants;

@RestController
@RequestMapping(path = "/IssHelper")
public class IssHelperController {

	@Autowired
	IssHelperService issHelperService;
	@Autowired
	IssHelperStudentSignUpOutputVO issHelperStudentSignUpOutputVO;

	@RequestMapping(path = "/StudentSignUp")
	@ResponseBody
	@PostMapping
	public ResponseEntity<IssHelperStudentSignUpOutputVO> studentSignUp(
			@RequestBody IssHelperStudentSignUpInputVO issHelperStudentSignUpInputVO) {
		ResponseEntity<IssHelperStudentSignUpOutputVO> responseEntity;
		try {
			issHelperStudentSignUpOutputVO = issHelperService.signUp(issHelperStudentSignUpInputVO);
			responseEntity = new ResponseEntity<IssHelperStudentSignUpOutputVO>(issHelperStudentSignUpOutputVO,
					HttpStatus.OK);
		} catch (IssHelperException e) {
			// System.out.println(e.getMessage());
			issHelperStudentSignUpOutputVO.setMessage(ApplicationsConstants.FAILURE);
			responseEntity = new ResponseEntity<IssHelperStudentSignUpOutputVO>(issHelperStudentSignUpOutputVO,
					HttpStatus.FORBIDDEN);
			return responseEntity;
		}
		return responseEntity;

	}

	@RequestMapping("/RideProviderSignup")
	public String rideProviderSignUp() {

		return "";

	}

}

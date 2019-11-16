package com.isshelper.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping(path = "/IssHelper")
public class IssHelperController {

	@Autowired
	IssHelperService issHelperService;

	@RequestMapping(path = "/StudentSignUp")
	@ResponseBody
	@PostMapping
	public ResponseEntity<IssHelperStudentSignUpOutputVO> studentSignUp(
			@RequestBody IssHelperStudentSignUpInputVO issHelperStudentSignUpInputVO) {

		try {
			issHelperService.signUp(issHelperStudentSignUpInputVO);
		} catch (IssHelperException e) {
			System.out.println(e.getMessage());

			return null;
		}
		return null;

	}

	@RequestMapping("/RideProviderSignup")
	public String rideProviderSignUp() {

		return "";

	}

}

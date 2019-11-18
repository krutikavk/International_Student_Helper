package com.isshelper.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.isshelper.exception.IssHelperException;
import com.isshelper.input.IssHelperRiderSignUpInputVO;
import com.isshelper.input.IssHelperStudentSignUpInputVO;
import com.isshelper.output.IssHelperOutput;
import com.isshelper.pojo.RideProvider;
import com.isshelper.pojo.Student;
import com.isshelper.utils.ApplicationsConstants;

@Repository
public class IssHelperDaoImplementation {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	IssHelperOutput issHelperOutput;
	@Autowired
	Student student;
	@Autowired
	RideProvider riderProvider;

	public IssHelperOutput studentSignUp(IssHelperStudentSignUpInputVO issHelperStudentSignUpInputVO)
			throws IssHelperException {

		try {
			String university = "select U_Id from StudentHelper.dbo.University where StudentHelper.dbo.University.U_Name= '"
					+ issHelperStudentSignUpInputVO.getUniversity() + "';";

			Integer u_id = jdbcTemplate.queryForObject(university, Integer.class);
			student.setS_Id(Integer.parseInt(issHelperStudentSignUpInputVO.getStudent_ID()));
			student.setS_Email(issHelperStudentSignUpInputVO.getEmail());
			student.setS_Name((issHelperStudentSignUpInputVO.getName()));
			student.setS_University(u_id);
			student.setS_Phone(Long.parseLong(issHelperStudentSignUpInputVO.getPhone()));
			String insertStudent = "Insert into StudentHelper.dbo.Student values(" + student.getS_Id() + ",'"
					+ student.getS_Name() + "','" + student.getS_Email() + "'," + student.getS_Phone() + "," + u_id
					+ ")";

			jdbcTemplate.execute(insertStudent);
		} catch (DataAccessException e) {
			throw new IssHelperException("Student SignUp failed");
		}
		issHelperOutput.setMessage(ApplicationsConstants.SUCCESS);
		return issHelperOutput;

	}
	
	
	public IssHelperOutput riderSignUp(IssHelperRiderSignUpInputVO issHelperRiderSignUpInputVO)
			throws IssHelperException {

		try {

			riderProvider.setP_Name(issHelperRiderSignUpInputVO.getName());
			riderProvider.setP_Email(issHelperRiderSignUpInputVO.getEmail());
			riderProvider.setP_Phone(issHelperRiderSignUpInputVO.getPhone());
			riderProvider.setP_Drivers_License(issHelperRiderSignUpInputVO.getDriversLicense());
			
			String insertRideProvider = "insert into StudentHelper.dbo.Ride_Provider values ('" + 
										riderProvider.getP_Name() + "'" + "," + riderProvider.getP_Phone() + 
										 ",'" + riderProvider.getP_Email() + "','" + riderProvider.getP_Drivers_License() + "')";
			
			jdbcTemplate.execute(insertRideProvider);
		} catch (DataAccessException e) {
			throw new IssHelperException("Ride Provider SignUp failed");
		}
		issHelperOutput.setMessage(ApplicationsConstants.SUCCESS);
		return issHelperOutput;

	}
}

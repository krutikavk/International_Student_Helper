package com.isshelper.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.isshelper.exception.IssHelperException;
import com.isshelper.input.IssHelperRiderSignUpInputVO;
import com.isshelper.input.IssHelperRidesPostedByProvider;
import com.isshelper.input.IssHelperStudentRideRequest;
import com.isshelper.input.IssHelperStudentSignUpInputVO;
import com.isshelper.output.IssHelperOutput;
import com.isshelper.pojo.Ride;
import com.isshelper.pojo.RideProvider;
import com.isshelper.pojo.Rides_Posted_By_Provider;
import com.isshelper.pojo.Rides_Requested_By_Student;
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
	@Autowired
	Ride ride;
	@Autowired
	Rides_Requested_By_Student rides_Requested_By_Student;
	@Autowired
	Rides_Posted_By_Provider rides_Posted_By_Provider;

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
			throw new IssHelperException(ApplicationsConstants.STUDENT_SIGNUP_FAILURE);
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

			String insertRideProvider = "insert into StudentHelper.dbo.Ride_Provider values ('"
					+ riderProvider.getP_Name() + "'" + "," + riderProvider.getP_Phone() + ",'"
					+ riderProvider.getP_Email() + "','" + riderProvider.getP_Drivers_License() + "')";

			jdbcTemplate.execute(insertRideProvider);
		} catch (DataAccessException e) {
			throw new IssHelperException(ApplicationsConstants.RIDER_SIGNUP_FAILURE);
		}
		issHelperOutput.setMessage(ApplicationsConstants.SUCCESS);
		return issHelperOutput;

	}

	public IssHelperOutput studentRideRequest(IssHelperStudentRideRequest issHelperStudentRideRequest)
			throws IssHelperException {
		try {
			rides_Requested_By_Student.setRRBS_Id(issHelperStudentRideRequest.getId());
			rides_Requested_By_Student.setRBBS_Air_Code(issHelperStudentRideRequest.getAircode());
			rides_Requested_By_Student.setRRBS_Date(issHelperStudentRideRequest.getDate());
			rides_Requested_By_Student.setRRBS_Seats(issHelperStudentRideRequest.getSeats());
			rides_Requested_By_Student.setRRBS_T_Number(issHelperStudentRideRequest.getTerminalNo());
			rides_Requested_By_Student.setRRBS_Time(issHelperStudentRideRequest.getTime());
			String insertRideRequestByStudent = "insert into StudentHelper.dbo.Rides_Requested_By_Student values ("
					+ rides_Requested_By_Student.getRRBS_Id() + ",'" + rides_Requested_By_Student.getRRBS_Date()
					+ "','" + rides_Requested_By_Student.getRRBS_Time() + "','"
					+ rides_Requested_By_Student.getRBBS_Air_Code() + "',"
					+ rides_Requested_By_Student.getRRBS_T_Number() + "," + rides_Requested_By_Student.getRRBS_Seats() + ")";

			jdbcTemplate.execute(insertRideRequestByStudent);

			issHelperOutput.setMessage(ApplicationsConstants.SUCCESS);

		} catch (Exception e) {
			throw new IssHelperException(ApplicationsConstants.STUDENT_REQUEST_RIDE_FAILURE);
		}
		return issHelperOutput;
	}
	
	
	public IssHelperOutput providerRidePost(IssHelperRidesPostedByProvider issHelperRidesPostedByProvider)
			throws IssHelperException {
		try {
			rides_Posted_By_Provider.setRPBP_Drivers_License(issHelperRidesPostedByProvider.getDriversLicense());
			rides_Posted_By_Provider.setRPBP_Date(issHelperRidesPostedByProvider.getDate());
			rides_Posted_By_Provider.setRPBP_Time(issHelperRidesPostedByProvider.getTime());
			rides_Posted_By_Provider.setRPBP_From(issHelperRidesPostedByProvider.getFrom());
			rides_Posted_By_Provider.setRPBP_Current(issHelperRidesPostedByProvider.getCurrent());
			rides_Posted_By_Provider.setRPBP_Total(issHelperRidesPostedByProvider.getTotal());
			
			String insertRidePostedByProvider = "insert into StudentHelper.dbo.Rides_Posted_By_Provider values ('" +
			rides_Posted_By_Provider.getRPBP_Drivers_License() + "','" + rides_Posted_By_Provider.getRPBP_Date() + "','" +
					rides_Posted_By_Provider.getRPBP_Time() + "','" + rides_Posted_By_Provider.getRPBP_From() + "', " + 
			rides_Posted_By_Provider.getRPBP_Current() + "," + rides_Posted_By_Provider.getRPBP_Total() + ")";
			
			jdbcTemplate.execute(insertRidePostedByProvider);

			issHelperOutput.setMessage(ApplicationsConstants.SUCCESS);

		} catch (Exception e) {
			throw new IssHelperException(ApplicationsConstants.RIDE_PROVIDER_POST_FAILURE);
		}
		return issHelperOutput;
	}

}

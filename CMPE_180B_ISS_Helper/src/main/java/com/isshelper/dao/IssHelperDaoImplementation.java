package com.isshelper.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.isshelper.exception.IssHelperException;
import com.isshelper.input.IssHelperLoginInput;
import com.isshelper.input.IssHelperRiderSignUpInputVO;
import com.isshelper.input.IssHelperRidesPostedByProvider;
import com.isshelper.input.IssHelperStudentRideRequest;
import com.isshelper.input.IssHelperStudentSignUpInputVO;
import com.isshelper.output.IssHelperLoginOutput;
import com.isshelper.output.IssHelperOutput;
import com.isshelper.output.IssHelperRidesBookedByStudent;
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
	Student student;
	@Autowired
	RideProvider riderProvider;
	@Autowired
	Ride ride;
	@Autowired
	Rides_Requested_By_Student rides_Requested_By_Student;
	@Autowired
	Rides_Posted_By_Provider rides_Posted_By_Provider;
	@Autowired
	PasswordEncoder passwordEncoder;

	IssHelperLoginOutput issHelperLoginOutput;
	IssHelperOutput issHelperOutput;

	public IssHelperOutput studentSignUp(IssHelperStudentSignUpInputVO issHelperStudentSignUpInputVO)
			throws IssHelperException {
		issHelperOutput = new IssHelperOutput();

		try {
			String university = "select U_Id from StudentHelper.dbo.University where StudentHelper.dbo.University.U_Name= '"
					+ issHelperStudentSignUpInputVO.getUniversity() + "';";

			Integer u_id = jdbcTemplate.queryForObject(university, Integer.class);
			student.setS_ID((issHelperStudentSignUpInputVO.getStudent_ID()));
			student.setS_Email(issHelperStudentSignUpInputVO.getEmail());
			student.setS_Name((issHelperStudentSignUpInputVO.getName()));
			student.setS_University(u_id);
			student.setS_Phone(Long.parseLong(issHelperStudentSignUpInputVO.getPhone()));
			student.setS_Password(passwordEncoder.encode(issHelperStudentSignUpInputVO.getPassword()));
			String insertStudent = "Insert into StudentHelper.dbo.Student values('" + student.getS_ID() + "','"
					+ student.getS_Name() + "','" + student.getS_Email() + "','" + student.getS_Password() + "',"
					+ student.getS_Phone() + "," + u_id + ")";

			jdbcTemplate.execute(insertStudent);
		} catch (DataAccessException e) {
			throw new IssHelperException(ApplicationsConstants.STUDENT_SIGNUP_FAILURE);
		}

		issHelperOutput.setMessage(ApplicationsConstants.SUCCESS);
		return issHelperOutput;

	}

	public IssHelperOutput riderSignUp(IssHelperRiderSignUpInputVO issHelperRiderSignUpInputVO)
			throws IssHelperException {
		issHelperOutput = new IssHelperOutput();

		try {
			String university = "select U_Id from StudentHelper.dbo.University where StudentHelper.dbo.University.U_Name= '"
					+ issHelperRiderSignUpInputVO.getUniversity() + "';";
			Integer u_id = jdbcTemplate.queryForObject(university, Integer.class);
			riderProvider.setP_Name(issHelperRiderSignUpInputVO.getName());
			riderProvider.setP_Email(issHelperRiderSignUpInputVO.getEmail());
			riderProvider.setP_Phone(issHelperRiderSignUpInputVO.getPhone());
			riderProvider.setP_Drivers_License(issHelperRiderSignUpInputVO.getDriversLicense());
			riderProvider.setP_Password(passwordEncoder.encode(issHelperRiderSignUpInputVO.getPassword()));
			riderProvider.setP_University(u_id);
			String insertRideProvider = "insert into StudentHelper.dbo.Ride_Provider values ('"
					+ riderProvider.getP_Drivers_License() + "','" + riderProvider.getP_Password() + "','"
					+ riderProvider.getP_Name() + "'" + "," + riderProvider.getP_Phone() + ",'"
					+ riderProvider.getP_Email() + "'," + riderProvider.getP_University() + ")";

			jdbcTemplate.execute(insertRideProvider);
		} catch (DataAccessException e) {
			throw new IssHelperException(ApplicationsConstants.RIDER_SIGNUP_FAILURE);
		}

		issHelperOutput.setMessage(ApplicationsConstants.SUCCESS);
		return issHelperOutput;

	}

	public IssHelperOutput studentRideRequest(IssHelperStudentRideRequest issHelperStudentRideRequest)
			throws IssHelperException {
		issHelperOutput = new IssHelperOutput();
		try {
			rides_Requested_By_Student.setRRBS_Id(issHelperStudentRideRequest.getId());
			rides_Requested_By_Student.setRRBS_S_Id(issHelperStudentRideRequest.getStudent_ID());
			rides_Requested_By_Student.setRBBS_Air_Code(issHelperStudentRideRequest.getAircode());
			rides_Requested_By_Student.setRRBS_Date(issHelperStudentRideRequest.getDate());
			rides_Requested_By_Student.setRRBS_Seats(issHelperStudentRideRequest.getSeats());
			rides_Requested_By_Student.setRRBS_T_Number(issHelperStudentRideRequest.getTerminalNo());
			rides_Requested_By_Student.setRRBS_Time(issHelperStudentRideRequest.getTime());
			rides_Requested_By_Student.setRRBS_Street(issHelperStudentRideRequest.getStreet());
			rides_Requested_By_Student.setRRBS_City(issHelperStudentRideRequest.getCity());
			rides_Requested_By_Student.setRRBS_State(issHelperStudentRideRequest.getState());
			rides_Requested_By_Student.setRRBS_Zip(issHelperStudentRideRequest.getZip());
			String insertRideRequestByStudent = "insert into StudentHelper.dbo.Rides_Requested_By_Student values ('"
					+ rides_Requested_By_Student.getRRBS_S_Id() + "','" + rides_Requested_By_Student.getRRBS_Date()
					+ "','" + rides_Requested_By_Student.getRRBS_Time() + "','"
					+ rides_Requested_By_Student.getRBBS_Air_Code() + "',"
					+ rides_Requested_By_Student.getRRBS_T_Number() + "," + rides_Requested_By_Student.getRRBS_Seats()
					+ ",'" + rides_Requested_By_Student.getRRBS_Street() + "','"
					+ rides_Requested_By_Student.getRRBS_City() + "','" + rides_Requested_By_Student.getRRBS_State()
					+ "'," + rides_Requested_By_Student.getRRBS_Zip() + ")";

			jdbcTemplate.execute(insertRideRequestByStudent);

			issHelperOutput.setMessage(ApplicationsConstants.SUCCESS);

		} catch (Exception e) {
			throw new IssHelperException(ApplicationsConstants.STUDENT_REQUEST_RIDE_FAILURE);
		}

		return issHelperOutput;
	}

	public IssHelperOutput providerRidePost(IssHelperRidesPostedByProvider issHelperRidesPostedByProvider)
			throws IssHelperException {
		issHelperOutput = new IssHelperOutput();
		try {
			rides_Posted_By_Provider.setRPBP_Drivers_License(issHelperRidesPostedByProvider.getDriversLicense());
			rides_Posted_By_Provider.setRPBP_Date(issHelperRidesPostedByProvider.getDate());
			rides_Posted_By_Provider.setRPBP_Time(issHelperRidesPostedByProvider.getTime());
			rides_Posted_By_Provider.setRPBP_From(issHelperRidesPostedByProvider.getFrom());
			rides_Posted_By_Provider.setRPBP_Current(issHelperRidesPostedByProvider.getCurrent());
			rides_Posted_By_Provider.setRPBP_Total(issHelperRidesPostedByProvider.getTotal());

			String insertRidePostedByProvider = "insert into StudentHelper.dbo.Rides_Posted_By_Provider values ('"
					+ rides_Posted_By_Provider.getRPBP_Drivers_License() + "','"
					+ rides_Posted_By_Provider.getRPBP_Date() + "','" + rides_Posted_By_Provider.getRPBP_Time() + "','"
					+ rides_Posted_By_Provider.getRPBP_From() + "', " + rides_Posted_By_Provider.getRPBP_Current() + ","
					+ rides_Posted_By_Provider.getRPBP_Total() + ")";

			jdbcTemplate.execute(insertRidePostedByProvider);

			issHelperOutput.setMessage(ApplicationsConstants.SUCCESS);

		} catch (Exception e) {
			throw new IssHelperException(ApplicationsConstants.RIDE_PROVIDER_POST_FAILURE);
		}

		return issHelperOutput;
	}

	public IssHelperLoginOutput login(IssHelperLoginInput issHelperLoginInput) throws IssHelperException {
		issHelperLoginOutput = new IssHelperLoginOutput();
		try {
			if (issHelperLoginInput != null && issHelperLoginInput.getFlag().equals("S")) {
				String studentProviderPasswordFromEmailQuery = "select S_Password from StudentHelper.dbo.Student where S_Email= '"
						+ issHelperLoginInput.getEmail() + "'";
				String encryptedPasswordFromEmail = jdbcTemplate.queryForObject(studentProviderPasswordFromEmailQuery,
						String.class);

				String studentIDQuery = "select S_Id from StudentHelper.dbo.Student where S_Email= '"
						+ issHelperLoginInput.getEmail() + "'";
				String idFromEmail = jdbcTemplate.queryForObject(studentIDQuery, String.class);

				String studentnameFromIDQuery = "select S_Name from StudentHelper.dbo.Student where S_Id= '"
						+ idFromEmail + "'";
				String nameFromID = jdbcTemplate.queryForObject(studentnameFromIDQuery, String.class);

				if (!encryptedPasswordFromEmail.isEmpty()) {
					if (!(passwordEncoder.matches(issHelperLoginInput.getPassword(), encryptedPasswordFromEmail))) {
						throw new IssHelperException("Invalid Password");
					}

					else {

						issHelperLoginOutput.setEmail(issHelperLoginInput.getEmail());
						issHelperLoginOutput.setId(idFromEmail);
						issHelperLoginOutput.setName(nameFromID);
					}

				}
			}

			if (issHelperLoginInput != null && issHelperLoginInput.getFlag().equals("R")) {
				String RideProviderPasswordFromEmailQuery = "select P_Password from StudentHelper.dbo.Ride_Provider where P_Email= '"
						+ issHelperLoginInput.getEmail() + "'";
				String encryptedPasswordFromEmail = jdbcTemplate.queryForObject(RideProviderPasswordFromEmailQuery,
						String.class);

				String driversLicenseQuery = "select P_Drivers_License from StudentHelper.dbo.Ride_Provider where P_Email= '"
						+ issHelperLoginInput.getEmail() + "'";
				String driversLicenseFromEmail = jdbcTemplate.queryForObject(driversLicenseQuery, String.class);

				String RidernameFromIDQuery = "select P_Name from StudentHelper.dbo.Ride_Provider where P_Drivers_License= '"
						+ driversLicenseFromEmail + "'";
				String nameFromID = jdbcTemplate.queryForObject(RidernameFromIDQuery, String.class);

				if (!encryptedPasswordFromEmail.isEmpty()) {
					if (!(passwordEncoder.matches(issHelperLoginInput.getPassword(), encryptedPasswordFromEmail))) {
						throw new IssHelperException("Invalid Password");
					}

					else {

						issHelperLoginOutput.setEmail(issHelperLoginInput.getEmail());
						issHelperLoginOutput.setId(driversLicenseFromEmail);
						issHelperLoginOutput.setName(nameFromID);
					}

				}
			}

		} catch (Exception e) {
			throw new IssHelperException(ApplicationsConstants.FAILURE);
		}
		return issHelperLoginOutput;
	}

	public List<IssHelperRidesBookedByStudent> ridesBookedByStudent(String student_ID) throws IssHelperException {

		List<IssHelperRidesBookedByStudent> ridesBookedByStudent = null;
		String ridesBookedByStudentquery = "select r.R_Id , a.Air_Name , r.R_Starting_Terminal , r.R_Date , r.R_Time , rp.P_Name , rp.P_Email  from StudentHelper.dbo.Ride r join StudentHelper.dbo.Student_Ride_Availed ra on ra.SRA_Ride_Id = r.R_Id join StudentHelper.dbo.Airport a on a.Air_Code = r.R_Starting_Air_Code join StudentHelper.dbo.Ride_Provider rp on rp.P_Drivers_License = r.R_Accepted_By where ra.SRA_S_Id = "
				+ "'" + student_ID + "'";
		try {
			ridesBookedByStudent = jdbcTemplate.query(ridesBookedByStudentquery,
					new com.isshelper.utils.IssHelperRidesBookedByStudentRowMapper());

		} catch (Exception e) {
			throw new IssHelperException(ApplicationsConstants.STUDENT_BOOKED_RIDES_FETCHED_FAILED);
		}
		return ridesBookedByStudent;

	}

}

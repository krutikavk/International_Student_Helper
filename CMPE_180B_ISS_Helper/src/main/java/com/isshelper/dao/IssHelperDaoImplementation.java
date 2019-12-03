

//SJSU CMPE 138 Fall2019 TEAM8
package com.isshelper.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
import com.isshelper.pojo.Ride;
import com.isshelper.pojo.RideProvider;
import com.isshelper.pojo.Rides_Posted_By_Provider;
import com.isshelper.pojo.Rides_Requested_By_Student;
import com.isshelper.pojo.Student;
import com.isshelper.utils.ApplicationsConstants;
import com.isshelper.utils.IssHelperMailNotificationHelper;

@Repository
public class IssHelperDaoImplementation {

	private static final Logger log = LoggerFactory.getLogger(IssHelperDaoImplementation.class);

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
	@Autowired
	IssHelperMailNotificationHelper IssHelperMailNotificationHelper;

	IssHelperLoginOutput issHelperLoginOutput;
	IssHelperOutput issHelperOutput;

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
	public IssHelperOutput studentSignUp(IssHelperStudentSignUpInputVO issHelperStudentSignUpInputVO)
			throws IssHelperException {
		issHelperOutput = new IssHelperOutput();
		String insertStudent = "";
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
			insertStudent = "Insert into StudentHelper.dbo.Student values('" + student.getS_ID() + "','"
					+ student.getS_Name() + "','" + student.getS_Email() + "','" + student.getS_Password() + "',"
					+ student.getS_Phone() + "," + u_id + ")";

			jdbcTemplate.execute(insertStudent);
			log.info("Query for student signUp: " + insertStudent);
		} catch (DataAccessException e) {
			log.error("Student SignUp failed " + insertStudent);
			throw new IssHelperException(ApplicationsConstants.STUDENT_SIGNUP_FAILURE);
		}

		issHelperOutput.setMessage(ApplicationsConstants.SUCCESS);
		return issHelperOutput;

	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
	public IssHelperOutput riderSignUp(IssHelperRiderSignUpInputVO issHelperRiderSignUpInputVO)
			throws IssHelperException {
		issHelperOutput = new IssHelperOutput();
		String insertRideProvider = "";
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
			insertRideProvider = "insert into StudentHelper.dbo.Ride_Provider values ('"
					+ riderProvider.getP_Drivers_License() + "','" + riderProvider.getP_Password() + "','"
					+ riderProvider.getP_Name() + "'" + "," + riderProvider.getP_Phone() + ",'"
					+ riderProvider.getP_Email() + "'," + riderProvider.getP_University() + ")";

			jdbcTemplate.execute(insertRideProvider);
			log.info("Query for Ride Provider signUp: " + insertRideProvider);
		} catch (DataAccessException e) {
			log.error("Rider SignUp Failed" + insertRideProvider);
			throw new IssHelperException(ApplicationsConstants.RIDER_SIGNUP_FAILURE);
		}

		issHelperOutput.setMessage(ApplicationsConstants.SUCCESS);
		return issHelperOutput;

	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
	public IssHelperOutput studentRideRequest(IssHelperStudentRideRequest issHelperStudentRideRequest)
			throws IssHelperException {
		issHelperOutput = new IssHelperOutput();
		String insertRideRequestByStudent = "";
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
			insertRideRequestByStudent = "insert into StudentHelper.dbo.Rides_Requested_By_Student values ('"
					+ rides_Requested_By_Student.getRRBS_S_Id() + "','" + rides_Requested_By_Student.getRRBS_Date()
					+ "','" + rides_Requested_By_Student.getRRBS_Time() + "','"
					+ rides_Requested_By_Student.getRBBS_Air_Code() + "',"
					+ rides_Requested_By_Student.getRRBS_T_Number() + "," + rides_Requested_By_Student.getRRBS_Seats()
					+ ",'" + rides_Requested_By_Student.getRRBS_Street() + "','"
					+ rides_Requested_By_Student.getRRBS_City() + "','" + rides_Requested_By_Student.getRRBS_State()
					+ "'," + rides_Requested_By_Student.getRRBS_Zip() + ")";

			jdbcTemplate.execute(insertRideRequestByStudent);

			log.info("Student Ride Request " + insertRideRequestByStudent);

			issHelperOutput.setMessage(ApplicationsConstants.SUCCESS);

		} catch (Exception e) {
			log.error("Student Ride Request Failed " + insertRideRequestByStudent);
			throw new IssHelperException(ApplicationsConstants.STUDENT_REQUEST_RIDE_FAILURE);
		}

		return issHelperOutput;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
	public IssHelperOutput providerRidePost(IssHelperRidesPostedByProvider issHelperRidesPostedByProvider)
			throws IssHelperException {
		issHelperOutput = new IssHelperOutput();
		String insertRidePostedByProvider = "";
		try {
			rides_Posted_By_Provider.setRPBP_Drivers_License(issHelperRidesPostedByProvider.getDriversLicense());
			rides_Posted_By_Provider.setRPBP_Date(issHelperRidesPostedByProvider.getDate());
			rides_Posted_By_Provider.setRPBP_Time(issHelperRidesPostedByProvider.getTime());
			rides_Posted_By_Provider.setRPBP_From(issHelperRidesPostedByProvider.getFrom());
			rides_Posted_By_Provider.setRPBP_Current(issHelperRidesPostedByProvider.getCurrent());
			rides_Posted_By_Provider.setRPBP_Total(issHelperRidesPostedByProvider.getTotal());

			insertRidePostedByProvider = "insert into StudentHelper.dbo.Rides_Posted_By_Provider values ('"
					+ rides_Posted_By_Provider.getRPBP_Drivers_License() + "','"
					+ rides_Posted_By_Provider.getRPBP_Date() + "','" + rides_Posted_By_Provider.getRPBP_Time() + "','"
					+ rides_Posted_By_Provider.getRPBP_From() + "', " + rides_Posted_By_Provider.getRPBP_Current() + ","
					+ rides_Posted_By_Provider.getRPBP_Total() + ")";

			jdbcTemplate.execute(insertRidePostedByProvider);

			log.info("Ride Provider Posting Rides " + insertRidePostedByProvider);

			issHelperOutput.setMessage(ApplicationsConstants.SUCCESS);

		} catch (Exception e) {
			log.error("Ride Provider Ride Posting Failed " + insertRidePostedByProvider);
			throw new IssHelperException(ApplicationsConstants.RIDE_PROVIDER_POST_FAILURE);
		}

		return issHelperOutput;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
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
						log.error("Login Failed for user " + nameFromID);
						throw new IssHelperException("Invalid Password");
					}

					else {
						log.info("Student Login Successful for " + nameFromID);
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
						log.error("Login Failed for Ride Provider " + nameFromID);
						throw new IssHelperException("Invalid Password");
					}

					else {
						log.info("Login Successful for Ride Provider " + nameFromID);
						issHelperLoginOutput.setEmail(issHelperLoginInput.getEmail());
						issHelperLoginOutput.setId(driversLicenseFromEmail);
						issHelperLoginOutput.setName(nameFromID);
					}

				}
			}

		} catch (Exception e) {
			log.error("User Login Failed");
			throw new IssHelperException(ApplicationsConstants.FAILURE);
		}
		return issHelperLoginOutput;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
	public List<IssHelperRidesBookedByStudent> ridesBookedByStudent(String student_ID) throws IssHelperException {

		List<IssHelperRidesBookedByStudent> ridesBookedByStudentList = null;
		String ridesBookedByStudentquery = "select r.R_Id , a.Air_Name , r.R_Starting_Terminal , r.R_Date , r.R_Time , rp.P_Name , rp.P_Email  from StudentHelper.dbo.Ride r join StudentHelper.dbo.Student_Ride_Availed ra on ra.SRA_Ride_Id = r.R_Id join StudentHelper.dbo.Airport a on a.Air_Code = r.R_Starting_Air_Code join StudentHelper.dbo.Ride_Provider rp on rp.P_Drivers_License = r.R_Accepted_By where ra.SRA_S_Id = "
				+ "'" + student_ID + "'";
		try {
			ridesBookedByStudentList = jdbcTemplate.query(ridesBookedByStudentquery,
					new com.isshelper.utils.IssHelperRidesBookedByStudentRowMapper());
			log.info("Rides Booked by Student " + ridesBookedByStudentquery);

		} catch (Exception e) {
			log.error("Rides Booked by Student " + ridesBookedByStudentquery);
			throw new IssHelperException(ApplicationsConstants.STUDENT_BOOKED_RIDES_FETCHED_FAILED);
		}
		return ridesBookedByStudentList;

	}

	public List<IssHelperRidesPostedByStudentOutputVO> ridesPostedByStudent(String student_ID)
			throws IssHelperException {

		List<IssHelperRidesPostedByStudentOutputVO> ridesPostedByStudentList = null;
		String ridesPostedByStudentquery = "	select RRBS_Id,	RRBS_Date, RRBS_Time, RRBS_Air_Code, RRBS_T_Number,	RRBS_Seats,	RRBS_Street, RRBS_City,	RRBS_State,	RRBS_Zip from StudentHelper.dbo.Rides_Requested_By_Student where RRBS_S_Id = "
				+ "'" + student_ID + "'" + "and RRBS_Date >= GETDATE()";
		try {
			ridesPostedByStudentList = jdbcTemplate.query(ridesPostedByStudentquery,
					new com.isshelper.utils.IssHelperRidesPostedByStudentRowMapper());
			log.info("Rides Posted by Student " + ridesPostedByStudentList);

		} catch (Exception e) {
			log.error("Rides Booked by Student " + ridesPostedByStudentList);
			throw new IssHelperException(ApplicationsConstants.STUDENT_BOOKED_RIDES_FETCHED_FAILED);
		}
		return ridesPostedByStudentList;

	}

	// Method for Student to see RidesPosted By Provider Matching his time

	public List<IssHelperGetBrandNewRidesPostedByProviderOutputVO> getBrandNewRidesPostedByProvider(
			IssHelperGetBrandNewRidesPostedByProviderInputVO issHelperGetBrandNewRidesPostedByProviderInputVO)
			throws IssHelperException {

		List<IssHelperGetBrandNewRidesPostedByProviderOutputVO> IssHelperGetBrandNewRidesPostedByProviderOutputVOList = null;
		String getBrandNewRidesPostedByProviderquery = "";
		try {

			getBrandNewRidesPostedByProviderquery = "select RPBP_Id, RPBP_Drivers_License, RPBP_Date, RPBP_Time, RPBP_From, RPBP_Total from StudentHelper.dbo.Rides_Posted_By_Provider where RPBP_Date ="
					+ "'" + issHelperGetBrandNewRidesPostedByProviderInputVO.getDate() + "'and RPBP_Time >='"
					+ issHelperGetBrandNewRidesPostedByProviderInputVO.getLanding_time() + "'and RPBP_From='"
					+ issHelperGetBrandNewRidesPostedByProviderInputVO.getLanding_airport() + "'and RPBP_Total>="
					+ issHelperGetBrandNewRidesPostedByProviderInputVO.getSeats();

			IssHelperGetBrandNewRidesPostedByProviderOutputVOList = jdbcTemplate.query(
					getBrandNewRidesPostedByProviderquery,
					new com.isshelper.utils.IssHelperGetBrandNewRidesPostedByProviderrRowMapper());
			log.info("Get Brand New Rides Posted by Ride Provider " + getBrandNewRidesPostedByProviderquery);
		} catch (Exception e) {
			log.error("Get Brand New Rides Posted by Ride Provider " + getBrandNewRidesPostedByProviderquery);
			throw new IssHelperException(ApplicationsConstants.GET_BRAND_NEW_RIDES_POSTED_BY_PROVIDER);
		}
		return IssHelperGetBrandNewRidesPostedByProviderOutputVOList;

	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
	public IssHelperOutput bookRideForStudent(IssHelperBookRideForStudentInputVO issHelperBookRideForStudentInputVO)
			throws IssHelperException {

		IssHelperOutput issHelperOutput = new IssHelperOutput();

		try {
			log.info("Executing Queries for Book Ride For Student");
			String insertIntoRideQuery = "insert into StudentHelper.dbo.Ride values ('"
					+ issHelperBookRideForStudentInputVO.getRpbp_Date() + "','"
					+ issHelperBookRideForStudentInputVO.getRpbp_Time() + "',0,'"
					+ issHelperBookRideForStudentInputVO.getRpbp_From() + "',"
					+ issHelperBookRideForStudentInputVO.getTerminal() + ",'"
					+ issHelperBookRideForStudentInputVO.getDrivers_Lisence() + "',"
					+ issHelperBookRideForStudentInputVO.getSeats() + ","
					+ issHelperBookRideForStudentInputVO.getRpbp_Total() + ")";

			jdbcTemplate.execute(insertIntoRideQuery);
			log.info("Executing " + insertIntoRideQuery + " Successful");

			String getRideIDQuery = "Select R_ID from StudentHelper.dbo.Ride where R_Accepted_By= '"
					+ issHelperBookRideForStudentInputVO.getDrivers_Lisence() + "' and R_Date='"
					+ issHelperBookRideForStudentInputVO.getRpbp_Date() + "' and R_Time='"
					+ issHelperBookRideForStudentInputVO.getRpbp_Time() + "'";

			int RideID = jdbcTemplate.queryForObject(getRideIDQuery, Integer.class);
			log.info("Executing " + getRideIDQuery + " Successful");

			String insertIntoStudentRideAvailed = "insert into StudentHelper.dbo.Student_Ride_Availed values('"
					+ issHelperBookRideForStudentInputVO.getStudent_Id() + "'," + RideID + ",0)";

			log.info("Executing " + insertIntoStudentRideAvailed + " Successful");
			jdbcTemplate.execute(insertIntoStudentRideAvailed);

			String insertrideAddressQuery = "insert into StudentHelper.dbo.Ride_Address values('"
					+ issHelperBookRideForStudentInputVO.getStudent_Id() + "'," + RideID + ",'"
					+ issHelperBookRideForStudentInputVO.getStreet() + "','"
					+ issHelperBookRideForStudentInputVO.getCity() + "','"
					+ issHelperBookRideForStudentInputVO.getState() + "'," + issHelperBookRideForStudentInputVO.getZip()
					+ ")";

			log.info("Executing " + insertrideAddressQuery + " Successful");
			jdbcTemplate.execute(insertrideAddressQuery);

			String insertIntoStudentArrivingAtTerminalQuery = "insert into StudentHelper.dbo.Student_Arriving_Terminal values ('"
					+ issHelperBookRideForStudentInputVO.getStudent_Id() + "','"
					+ issHelperBookRideForStudentInputVO.getRpbp_From() + "',"
					+ issHelperBookRideForStudentInputVO.getTerminal() + ",'"
					+ issHelperBookRideForStudentInputVO.getRpbp_Date() + "','"
					+ issHelperBookRideForStudentInputVO.getRpbp_Time() + "')";

			log.info("Executing " + insertIntoStudentArrivingAtTerminalQuery + " Successful");
			jdbcTemplate.execute(insertIntoStudentArrivingAtTerminalQuery);

			String deleteRidesPostedByProviderQuery = "delete from StudentHelper.dbo.Rides_Posted_By_Provider where RPBP_Id="
					+ issHelperBookRideForStudentInputVO.getRpbp_Id();

			log.info("Executing " + deleteRidesPostedByProviderQuery + " Successful");
			jdbcTemplate.execute(deleteRidesPostedByProviderQuery);

			String getRideProviderdetailsQuery = "select P_Drivers_License, P_Email, P_Phone, P_Name from StudentHelper.dbo.Ride_Provider where P_Drivers_License ='"
					+ issHelperBookRideForStudentInputVO.getDrivers_Lisence() + "'";

			RideProvider rideProvider = jdbcTemplate
					.query(getRideProviderdetailsQuery, new com.isshelper.utils.IssHelperRideProviderRowMapper())
					.get(0);

			String getStudentDetailsQuery = "select S_Name, S_Email,S_Phone from StudentHelper.dbo.student where S_Id = '"
					+ issHelperBookRideForStudentInputVO.getStudent_Id() + "'";

			Student student = jdbcTemplate
					.query(getStudentDetailsQuery, new com.isshelper.utils.IssHelperStudentRowMapper()).get(0);

			IssHelperMailNotificationHelper.sendEmailtoStudent(student.getS_Email(), rideProvider.getP_Email(),
					issHelperBookRideForStudentInputVO.getState() + " " + " "
							+ issHelperBookRideForStudentInputVO.getCity(),
					student.getS_Phone(), rideProvider.getP_Phone(), rideProvider.getP_Name(), student.getS_Name(),
					issHelperBookRideForStudentInputVO.getRpbp_Date(),
					issHelperBookRideForStudentInputVO.getRpbp_Time(),
					issHelperBookRideForStudentInputVO.getRpbp_From(), issHelperBookRideForStudentInputVO.getZip());

			IssHelperMailNotificationHelper.sendEmailtoRideProvider(student.getS_Email(), rideProvider.getP_Email(),
					issHelperBookRideForStudentInputVO.getState() + " " + " "
							+ issHelperBookRideForStudentInputVO.getCity(),
					student.getS_Phone(), rideProvider.getP_Phone(), rideProvider.getP_Name(), student.getS_Name(),
					issHelperBookRideForStudentInputVO.getRpbp_Date(),
					issHelperBookRideForStudentInputVO.getRpbp_Time(),
					issHelperBookRideForStudentInputVO.getRpbp_From(), issHelperBookRideForStudentInputVO.getZip());

		} catch (Exception e) {
			log.error("Ride Booking for Student Failed");
			throw new IssHelperException(ApplicationsConstants.RIDE_BOOKING_FOR_STUDENT_FAILED);
		}

		issHelperOutput.setMessage(ApplicationsConstants.SUCCESS);
		return issHelperOutput;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
	public List<IssHelperGetAlreadyBookedRidesForStudentOutputVO> getAlreadyBookedRidesForStudent(
			IssHelperGetAlreadyBookedRidesForStudentInputVO issHelperGetAlreadyBookedRidesForStudentInputVO)
			throws IssHelperException {
		List<IssHelperGetAlreadyBookedRidesForStudentOutputVO> issHelperGetAlreadyBookedRidesForStudentOutputVOList = null;
		String getAlreadyBookedRidesForStudent = "";
		try {

			getAlreadyBookedRidesForStudent = "select R_Id,R_date,R_Time,R_Rating,R_Starting_Air_Code,R_Starting_Terminal,R_Accepted_By,R_Current,R_Total from StudentHelper.dbo.Ride where R_Date='"
					+ issHelperGetAlreadyBookedRidesForStudentInputVO.getDate() + "'" + " and R_Time  >= '"
					+ issHelperGetAlreadyBookedRidesForStudentInputVO.getLanding_time() + "'and R_Starting_Air_Code= '"
					+ issHelperGetAlreadyBookedRidesForStudentInputVO.getLanding_airport()
					+ "' and R_Total-R_Current>= " + issHelperGetAlreadyBookedRidesForStudentInputVO.getSeats();

			issHelperGetAlreadyBookedRidesForStudentOutputVOList = jdbcTemplate.query(getAlreadyBookedRidesForStudent,
					new com.isshelper.utils.IssHelperGetAlreadyBookedRidesForStduentRowMapper());
			log.info("Getting all rides booked by Student " + getAlreadyBookedRidesForStudent);

		} catch (Exception e) {
			log.info("Getting all rides booked by Student " + getAlreadyBookedRidesForStudent);
			throw new IssHelperException(ApplicationsConstants.ALREADY_BOOKED_RIDES_FOR_STUDENT_FAILED);

		}
		return issHelperGetAlreadyBookedRidesForStudentOutputVOList;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
	public IssHelperOutput bookAlreadyBookedRidesForStudent(
			IssHelperBookAlreadyBookedRidesForStudent issHelperBookAlreadyBookedRidesForStudent)
			throws IssHelperException {

		IssHelperOutput issHelperOutput = new IssHelperOutput();
		try {
			log.info("Booked Rides for Student Queries");

			String bookAlreadyBookedRidesForStudentQuery = "update StudentHelper.dbo.Ride set R_Current ="
					+ (+issHelperBookAlreadyBookedRidesForStudent.getR_Current()
							+ issHelperBookAlreadyBookedRidesForStudent.getSeats())
					+ " where R_Id = " + issHelperBookAlreadyBookedRidesForStudent.getR_Id();

			jdbcTemplate.execute(bookAlreadyBookedRidesForStudentQuery);
			log.info("Successfully executed " + bookAlreadyBookedRidesForStudentQuery);

			String insertIntoStudentRideAvailedQuery = "Insert into StudentHelper.dbo.Student_Ride_Availed values( '"
					+ issHelperBookAlreadyBookedRidesForStudent.getStudent_Id() + "',"
					+ issHelperBookAlreadyBookedRidesForStudent.getR_Id() + "," + 0 + ")";

			jdbcTemplate.execute(insertIntoStudentRideAvailedQuery);
			log.info("Successfully executed " + insertIntoStudentRideAvailedQuery);

			String insertIntoStudentArrivingTerminalValuesQuery = "Insert into StudentHelper.dbo.Student_Arriving_Terminal values( '"
					+ issHelperBookAlreadyBookedRidesForStudent.getStudent_Id() + "','"
					+ issHelperBookAlreadyBookedRidesForStudent.getR_Starting_Air_Code() + "',"
					+ issHelperBookAlreadyBookedRidesForStudent.getR_Starting_Terminal() + ",'"
					+ issHelperBookAlreadyBookedRidesForStudent.getR_Date() + "','"
					+ issHelperBookAlreadyBookedRidesForStudent.getR_Time() + "')";

			jdbcTemplate.execute(insertIntoStudentArrivingTerminalValuesQuery);
			log.info("Successfully executed " + insertIntoStudentArrivingTerminalValuesQuery);

			String insertIntoRideAdressQuery = "Insert into StudentHelper.dbo.Ride_Address values( '"
					+ issHelperBookAlreadyBookedRidesForStudent.getStudent_Id() + "',"
					+ issHelperBookAlreadyBookedRidesForStudent.getR_Id() + ",'"
					+ issHelperBookAlreadyBookedRidesForStudent.getStreet() + "','"
					+ issHelperBookAlreadyBookedRidesForStudent.getCity() + "','"
					+ issHelperBookAlreadyBookedRidesForStudent.getState() + "',"
					+ issHelperBookAlreadyBookedRidesForStudent.getZip() + ")";

			jdbcTemplate.execute(insertIntoRideAdressQuery);
			log.info("Successfully executed " + insertIntoRideAdressQuery);
			String getDriversLicenseQuery = "select R_Accepted_By from StudentHelper.dbo.Ride where R_Id = "
					+ issHelperBookAlreadyBookedRidesForStudent.getR_Id();

			String RideProviderDriversLicesnse = jdbcTemplate.queryForObject(getDriversLicenseQuery, String.class);

			String getRideProviderdetailsQuery = "select P_Drivers_License, P_Email, P_Phone, P_Name from StudentHelper.dbo.Ride_Provider where P_Drivers_License ='"
					+ RideProviderDriversLicesnse + "'";

			RideProvider rideProvider = jdbcTemplate
					.query(getRideProviderdetailsQuery, new com.isshelper.utils.IssHelperRideProviderRowMapper())
					.get(0);

			String getStudentDetailsQuery = "select S_Name, S_Email,S_Phone from StudentHelper.dbo.student where S_Id = '"
					+ issHelperBookAlreadyBookedRidesForStudent.getStudent_Id() + "'";

			Student student = jdbcTemplate
					.query(getStudentDetailsQuery, new com.isshelper.utils.IssHelperStudentRowMapper()).get(0);

			IssHelperMailNotificationHelper.sendEmailtoStudent(student.getS_Email(), rideProvider.getP_Email(),
					issHelperBookAlreadyBookedRidesForStudent.getStreet() + " "
							+ issHelperBookAlreadyBookedRidesForStudent.getCity() + " " + " "
							+ issHelperBookAlreadyBookedRidesForStudent.getState() + " ",
					student.getS_Phone(), rideProvider.getP_Phone(), rideProvider.getP_Name(), student.getS_Name(),
					issHelperBookAlreadyBookedRidesForStudent.getR_Date(),
					issHelperBookAlreadyBookedRidesForStudent.getR_Time(),
					issHelperBookAlreadyBookedRidesForStudent.getR_Starting_Air_Code(),
					issHelperBookAlreadyBookedRidesForStudent.getZip());

			IssHelperMailNotificationHelper.sendEmailtoRideProvider(student.getS_Email(), rideProvider.getP_Email(),
					issHelperBookAlreadyBookedRidesForStudent.getStreet() + " "
							+ issHelperBookAlreadyBookedRidesForStudent.getCity() + " " + " "
							+ issHelperBookAlreadyBookedRidesForStudent.getState() + " ",
					student.getS_Phone(), rideProvider.getP_Phone(), rideProvider.getP_Name(), student.getS_Name(),
					issHelperBookAlreadyBookedRidesForStudent.getR_Date(),
					issHelperBookAlreadyBookedRidesForStudent.getR_Time(),
					issHelperBookAlreadyBookedRidesForStudent.getR_Starting_Air_Code(),
					issHelperBookAlreadyBookedRidesForStudent.getZip());

		} catch (Exception e) {
			log.error("Booked Rides for Student Queries execution failed");
			throw new IssHelperException(ApplicationsConstants.FAILURE);
		}
		issHelperOutput.setMessage(ApplicationsConstants.SUCCESS);
		return issHelperOutput;
	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
	public List<IssHelperProviderViewRidesPostedByStudentOutputVO> providerViewRidesPostedByStudent(
			IssHelperProviderViewRidesPostedByStudentInputVO issHelperProviderViewRidesPostedByStudentByIntputVO)
			throws IssHelperException {
		List<IssHelperProviderViewRidesPostedByStudentOutputVO> providerViewRidesPostedByStudentOutputVOList = null;

		try {
			String rideProviderUniversityIdQuery = "select P_University from StudentHelper.dbo.Ride_Provider where P_Drivers_License ='"
					+ issHelperProviderViewRidesPostedByStudentByIntputVO.getDrivers_Lisence() + "'";

			String rideProviderUniversityId = jdbcTemplate.queryForObject(rideProviderUniversityIdQuery, String.class);

			String providerViewRidesPostedByStudentQuery = "select RRBS_Id,	RRBS_S_Id,	RRBS_Date,	RRBS_Time,	RRBS_Air_Code,	RRBS_T_Number,	RRBS_Seats,RRBS_Street,RRBS_City,RRBS_State,RRBS_Zip from StudentHelper.dbo.Rides_Requested_By_Student rrbs where RRBS_Date= '"
					+ issHelperProviderViewRidesPostedByStudentByIntputVO.getDate() + "' and rrbs.RRBS_Seats <= "
					+ issHelperProviderViewRidesPostedByStudentByIntputVO.getSeats()
					+ " and rrbs.RRBS_Air_Code in (select N_A_Code from StudentHelper.dbo.Nearby_Airports where N_U_Id = "
					+ rideProviderUniversityId + ")";

			providerViewRidesPostedByStudentOutputVOList = jdbcTemplate.query(providerViewRidesPostedByStudentQuery,
					new com.isshelper.utils.IssHelperProviderViewRidesPostedByStudentByRowMapper());
			log.info("View rides posted by Student " + providerViewRidesPostedByStudentQuery);
		} catch (Exception e) {
			log.info("View rides posted by Student fetch failed");
			throw new IssHelperException(ApplicationsConstants.STUDENT_BOOKED_RIDES_FETCHED_FAILED);
		}
		return providerViewRidesPostedByStudentOutputVOList;

	}

	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
	public IssHelperOutput studentRidePostedAcceptedByProvider(
			IssHelperStudentRideAcceptedByProviderInputVO issHelperStudentRideAcceptedByProviderInputVO)
			throws IssHelperException {
		IssHelperOutput issHelperOutput = new IssHelperOutput();
		try {
			String insertIntoRideQuery = "insert into StudentHelper.dbo.Ride values ('"
					+ issHelperStudentRideAcceptedByProviderInputVO.getRrbs_Date() + "','"
					+ issHelperStudentRideAcceptedByProviderInputVO.getRrbs_Time() + "',0,'"
					+ issHelperStudentRideAcceptedByProviderInputVO.getRrbs_Air_Code() + "',"
					+ issHelperStudentRideAcceptedByProviderInputVO.getRrbs_T_Number() + ",'"
					+ issHelperStudentRideAcceptedByProviderInputVO.getDrivers_Lisence() + "',"
					+ issHelperStudentRideAcceptedByProviderInputVO.getRrbs_Seats() + ","
					+ issHelperStudentRideAcceptedByProviderInputVO.getSeats() + ")";

			jdbcTemplate.execute(insertIntoRideQuery);

			String getLatestRideIDQuery = "select top 1 R_Id from StudentHelper.dbo.Ride where R_Accepted_By =" + "'"
					+ issHelperStudentRideAcceptedByProviderInputVO.getDrivers_Lisence() + "' order by R_Id desc";

			String getLatestRideID = jdbcTemplate.queryForObject(getLatestRideIDQuery, String.class);

			String insertIntoStudentRideAvailed = "insert into StudentHelper.dbo.Student_Ride_Availed values('"
					+ issHelperStudentRideAcceptedByProviderInputVO.getRrbs_S_Id() + "'," + getLatestRideID + ",0)";

			jdbcTemplate.execute(insertIntoStudentRideAvailed);

			String insertIntoStudentArrivingAtTerminalQuery = "insert into StudentHelper.dbo.Student_Arriving_Terminal values ('"
					+ issHelperStudentRideAcceptedByProviderInputVO.getRrbs_S_Id() + "','"
					+ issHelperStudentRideAcceptedByProviderInputVO.getRrbs_Air_Code() + "',"
					+ issHelperStudentRideAcceptedByProviderInputVO.getRrbs_T_Number() + ",'"
					+ issHelperStudentRideAcceptedByProviderInputVO.getRrbs_Date() + "','"
					+ issHelperStudentRideAcceptedByProviderInputVO.getRrbs_Time() + "')";

			jdbcTemplate.execute(insertIntoStudentArrivingAtTerminalQuery);

			String insertIntoRideAdressQuery = "Insert into StudentHelper.dbo.Ride_Address values( '"
					+ issHelperStudentRideAcceptedByProviderInputVO.getRrbs_S_Id() + "'," + getLatestRideID + ",'"
					+ issHelperStudentRideAcceptedByProviderInputVO.getRrbs_Street() + "','"
					+ issHelperStudentRideAcceptedByProviderInputVO.getRrbs_City() + "','"
					+ issHelperStudentRideAcceptedByProviderInputVO.getRrbs_State() + "',"
					+ issHelperStudentRideAcceptedByProviderInputVO.getRrbs_Zip() + ")";

			jdbcTemplate.execute(insertIntoRideAdressQuery);

			String deleteRideAcceptedByProviderQuery = "delete from StudentHelper.dbo.Rides_Posted_By_Provider where RPBP_Id="
					+ issHelperStudentRideAcceptedByProviderInputVO.getRrbs_Id();

			jdbcTemplate.execute(deleteRideAcceptedByProviderQuery);

			String getRideProviderdetailsQuery = "select P_Drivers_License, P_Email, P_Phone, P_Name from StudentHelper.dbo.Ride_Provider where P_Drivers_License ='"
					+ issHelperStudentRideAcceptedByProviderInputVO.getDrivers_Lisence() + "'";

			RideProvider rideProvider = jdbcTemplate
					.query(getRideProviderdetailsQuery, new com.isshelper.utils.IssHelperRideProviderRowMapper())
					.get(0);

			String getStudentDetailsQuery = "select S_Name, S_Email,S_Phone from StudentHelper.dbo.student where S_Id = '"
					+ issHelperStudentRideAcceptedByProviderInputVO.getRrbs_S_Id() + "'";

			Student student = jdbcTemplate
					.query(getStudentDetailsQuery, new com.isshelper.utils.IssHelperStudentRowMapper()).get(0);

			IssHelperMailNotificationHelper.sendEmailtoStudent(student.getS_Email(), rideProvider.getP_Email(),
					issHelperStudentRideAcceptedByProviderInputVO.getRrbs_State() + " " + " "
							+ issHelperStudentRideAcceptedByProviderInputVO.getRrbs_City(),
					student.getS_Phone(), rideProvider.getP_Phone(), rideProvider.getP_Name(), student.getS_Name(),
					issHelperStudentRideAcceptedByProviderInputVO.getRrbs_Date(),
					issHelperStudentRideAcceptedByProviderInputVO.getRrbs_Time(),
					issHelperStudentRideAcceptedByProviderInputVO.getRrbs_Air_Code(),
					issHelperStudentRideAcceptedByProviderInputVO.getRrbs_Zip());

			IssHelperMailNotificationHelper.sendEmailtoRideProvider(student.getS_Email(), rideProvider.getP_Email(),
					issHelperStudentRideAcceptedByProviderInputVO.getRrbs_State() + " " + " "
							+ issHelperStudentRideAcceptedByProviderInputVO.getRrbs_City(),
					student.getS_Phone(), rideProvider.getP_Phone(), rideProvider.getP_Name(), student.getS_Name(),
					issHelperStudentRideAcceptedByProviderInputVO.getRrbs_Date(),
					issHelperStudentRideAcceptedByProviderInputVO.getRrbs_Time(),
					issHelperStudentRideAcceptedByProviderInputVO.getRrbs_Air_Code(),
					issHelperStudentRideAcceptedByProviderInputVO.getRrbs_Zip());

		} catch (Exception e) {

			throw new IssHelperException(ApplicationsConstants.FAILURE);

		}
		issHelperOutput.setMessage(ApplicationsConstants.SUCCESS);
		return issHelperOutput;

	}

	public List<IssHelperProviderDashBoardRidesPostedByProviderOutputVO> providerDashBoardRidesPostedByProvider(
			IssHelperRidesPostedAndAcceptedByProviderInputVO issHelperRidesPostedAndAcceptedByProviderInputVO) {
		List<IssHelperProviderDashBoardRidesPostedByProviderOutputVO> issHelperProviderDashBoardRidesPostedByProviderOutputVOlist = null;

		try {

			String issHelperProviderDashBoardRidesPostedByProviderQuery = "Select RPBP_Id,	RPBP_Date, RPBP_Time, RPBP_From, RPBP_Current, RPBP_Total from StudentHelper.dbo.Rides_Posted_By_Provider where RPBP_Drivers_License = '"
					+ issHelperRidesPostedAndAcceptedByProviderInputVO.getDriversLicense()
					+ "'and RPBP_Date >= GETDATE()";

			issHelperProviderDashBoardRidesPostedByProviderOutputVOlist = jdbcTemplate.query(
					issHelperProviderDashBoardRidesPostedByProviderQuery,
					new com.isshelper.utils.IssHelperProviderDashBoardRidesPostedByProviderRowMapper());

		} catch (Exception e) {
			return issHelperProviderDashBoardRidesPostedByProviderOutputVOlist;
		}
		return issHelperProviderDashBoardRidesPostedByProviderOutputVOlist;
	}

	public List<IssHelperProviderDashBoardRidesAcceptedByProviderOutputVO> providerDashBoardRidesAcceptedByProvider(
			IssHelperRidesPostedAndAcceptedByProviderInputVO issHelperRidesPostedAndAcceptedByProviderInputVO) {
		List<IssHelperProviderDashBoardRidesAcceptedByProviderOutputVO> IssHelperProviderDashBoardRidesAcceptedByProviderOutputVOlist = null;

		try {

			String issHelperProviderDashBoardRidesAcceptedByProviderQuery = "select distinct R_Id, R_Date, R_Time, R_Rating, R_Starting_Air_Code, R_Starting_Terminal, R_Current, R_Total, s.S_Name, s.S_Email from StudentHelper.dbo.Ride r join StudentHelper.dbo.Student_Ride_Availed sra on sra.SRA_Ride_Id = r.R_Id join StudentHelper.dbo.Student s on s.S_Id = sra.SRA_S_Id where r.R_Accepted_By = '"
					+ issHelperRidesPostedAndAcceptedByProviderInputVO.getDriversLicense() + "'"
					+ "and r.R_Date >= GETDATE()";
			IssHelperProviderDashBoardRidesAcceptedByProviderOutputVOlist = jdbcTemplate.query(
					issHelperProviderDashBoardRidesAcceptedByProviderQuery,
					new com.isshelper.utils.IssHelperProviderDashBoardRidesAcceptedByProviderRowMapper());

		} catch (Exception e) {
			return IssHelperProviderDashBoardRidesAcceptedByProviderOutputVOlist;
		}
		return IssHelperProviderDashBoardRidesAcceptedByProviderOutputVOlist;
	}

	public List<IssHelperAppartmentsOutputVO> viewAppartments(
			IssHelperRidesBookedByStudentInputVO issHelperAppartmentInputVO) {
		List<IssHelperAppartmentsOutputVO> IssHelperAppartmentsOutputVOList = null;

		try {

			String viewAppartmentsQuery = "select A_Name,A_Distance,A_Website,A_Street,A_City,A_State,A_Zip from StudentHelper.dbo.Student S join StudentHelper.dbo.Apartment A on S.S_University = A.A_U_Id where S.S_Id='"
					+ issHelperAppartmentInputVO.getStudent_ID() + "'";
			IssHelperAppartmentsOutputVOList = jdbcTemplate.query(viewAppartmentsQuery,
					new com.isshelper.utils.IssHelperAppartmentRowMapper());

		} catch (Exception e) {
			return IssHelperAppartmentsOutputVOList;
		}
		return IssHelperAppartmentsOutputVOList;
	}

}
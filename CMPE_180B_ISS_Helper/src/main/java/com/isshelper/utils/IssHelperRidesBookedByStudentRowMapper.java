package com.isshelper.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.isshelper.output.IssHelperRidesBookedByStudent;

public class IssHelperRidesBookedByStudentRowMapper implements RowMapper<IssHelperRidesBookedByStudent> {
	public IssHelperRidesBookedByStudent mapRow(ResultSet rs, int rowNum) throws SQLException {

		IssHelperRidesBookedByStudent issHelperRidesBookedByStudent = new IssHelperRidesBookedByStudent();
		issHelperRidesBookedByStudent.setRide_Id(rs.getInt("R_Id"));
		issHelperRidesBookedByStudent.setAirport(rs.getString("Air_Name"));
		issHelperRidesBookedByStudent.setTerminal_Number(rs.getString("R_Starting_Terminal"));
		issHelperRidesBookedByStudent.setDate(rs.getString("R_Date"));
		issHelperRidesBookedByStudent.setTime(rs.getString("R_Time"));
		issHelperRidesBookedByStudent.setAccepted_By(rs.getString("P_Name"));
		issHelperRidesBookedByStudent.setContact_Email(rs.getString("P_Email"));

		return issHelperRidesBookedByStudent;

	}
}
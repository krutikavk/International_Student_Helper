//SJSU CMPE 138 Fall2019 TEAM8
package com.isshelper.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.isshelper.pojo.Student;

public class IssHelperStudentRowMapper implements RowMapper<Student> {

	public Student mapRow(ResultSet rs2, int rowNum) throws SQLException {

		Student student = new Student();

		student.setS_Email(rs2.getString("S_Email"));
		student.setS_Name(rs2.getString("S_Name"));
		student.setS_Phone(rs2.getLong("S_Phone"));

		return student;

	}
}
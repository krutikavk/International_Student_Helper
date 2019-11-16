package com.isshelper.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.isshelper.exception.IssHelperException;
import com.isshelper.output.IssHelperStudentSignUpOutputVO;
import com.isshelper.pojo.Student;
import com.isshelper.utils.ApplicationsConstants;

@Repository
public class IssHelperDaoImplementation {

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	IssHelperStudentSignUpOutputVO issHelperStudentSignUpOutputVO;

	public IssHelperStudentSignUpOutputVO signUp(Student student) throws IssHelperException {

		try {
			String university = "select U_Id from StudentHelper.dbo.University where StudentHelper.dbo.University.U_Name= "
					+ student.getS_University() + ";";

			int u_id = jdbcTemplate.queryForObject(university, Integer.class);

			String insertStudent = "Insert into StudentHelper.dbo.Student values(" + student.getS_Id() + ",'"
					+ student.getS_Name() + "','" + student.getS_Email() + "'," + student.getS_Phone() + "," + u_id
					+ ")";

			jdbcTemplate.execute(insertStudent);
		} catch (DataAccessException e) {
			throw new IssHelperException("Something went wrong while connecting to DB ");
		}
		issHelperStudentSignUpOutputVO.setMessage(ApplicationsConstants.SUCCESS);
		return issHelperStudentSignUpOutputVO;

	}
}
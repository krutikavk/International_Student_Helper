package com.isshelper.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.isshelper.exception.IssHelperException;
import com.isshelper.pojo.Student;

@Repository
public class IssHelperDaoImplementation {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void signUp(Student student) throws IssHelperException {

		try {
			String sql = "Insert into StudentHelper.dbo.Student values("+ student.getS_Id()+",'" + student.getS_Name() +"','"
					+ student.getS_Email()+"'," + student.getS_Phone()
					+ "," + student.getS_University()
					+ ")";

			jdbcTemplate.execute(sql);
		} catch (DataAccessException e) {
			throw new IssHelperException("Something went wrong while connecting to DB ");
		}

	}
}
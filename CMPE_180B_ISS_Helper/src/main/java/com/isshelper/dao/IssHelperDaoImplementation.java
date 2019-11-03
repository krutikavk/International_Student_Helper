package com.isshelper.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.isshelper.exception.IssHelperException;
import com.isshelper.input.IssHelperStudentSignUpInputVO;

public class IssHelperDaoImplementation {

	public Connection connectDB() throws IssHelperException {

		String connectionUrl = "jdbc:sqlserver://localhost;" + "databaseName=ms_test;user=username;password=password";

		Connection con = null;
		ResultSet rs = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
		}

		catch (SQLException | ClassNotFoundException e) {

			throw new IssHelperException("Unable to connect to DB");

		}
		return con;
	}

	public void signUp(IssHelperStudentSignUpInputVO issHelperStudentSignUpInputVO) throws IssHelperException {

		Connection connection = connectDB();

		try {
			Statement statement = connection.createStatement();

			String sql;

			sql = "SELECT id, first, last, age FROM Employees";
			ResultSet rs = statement.executeQuery(sql);
		} catch (SQLException e) {
			throw new IssHelperException("Something went wrong while connecting to DB ");
		}

	}
}
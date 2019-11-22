package com.isshelper.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.isshelper.output.IssHelperGetAlreadyBookedRidesForStudentOutputVO;

public class IssHelperGetAlreadyBookedRidesForStduentRowMapper
		implements RowMapper<IssHelperGetAlreadyBookedRidesForStudentOutputVO> {

	public IssHelperGetAlreadyBookedRidesForStudentOutputVO mapRow(ResultSet rs, int rowNum) throws SQLException {

		IssHelperGetAlreadyBookedRidesForStudentOutputVO issHelperGetAlreadyBookedRidesForStudentOutputVO = new IssHelperGetAlreadyBookedRidesForStudentOutputVO();

		issHelperGetAlreadyBookedRidesForStudentOutputVO.setR_Accepted_By(rs.getString("R_Accepted_By"));
		issHelperGetAlreadyBookedRidesForStudentOutputVO.setR_Current(rs.getInt("R_Current"));
		issHelperGetAlreadyBookedRidesForStudentOutputVO.setR_Date(rs.getString("R_Date"));
		issHelperGetAlreadyBookedRidesForStudentOutputVO.setR_Time(rs.getString("R_Time"));
		issHelperGetAlreadyBookedRidesForStudentOutputVO.setR_Starting_Air_Code(rs.getString("R_Starting_Air_Code"));
		issHelperGetAlreadyBookedRidesForStudentOutputVO.setR_Starting_Terminal(rs.getInt("R_Starting_Terminal"));
		issHelperGetAlreadyBookedRidesForStudentOutputVO.setR_Total(rs.getInt("R_Total"));
		issHelperGetAlreadyBookedRidesForStudentOutputVO.setR_Rating(rs.getInt("R_Rating"));
		issHelperGetAlreadyBookedRidesForStudentOutputVO.setR_Id(rs.getInt("R_ID"));

		return issHelperGetAlreadyBookedRidesForStudentOutputVO;

	}

}

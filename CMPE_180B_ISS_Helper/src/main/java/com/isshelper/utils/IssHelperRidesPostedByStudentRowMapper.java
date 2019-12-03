//SJSU CMPE 138 Fall2019 TEAM8
package com.isshelper.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.isshelper.output.IssHelperRidesPostedByStudentOutputVO;

public class IssHelperRidesPostedByStudentRowMapper implements RowMapper<IssHelperRidesPostedByStudentOutputVO> {

	public IssHelperRidesPostedByStudentOutputVO mapRow(ResultSet rs, int rowNum) throws SQLException {

		IssHelperRidesPostedByStudentOutputVO issHelperRidesPostedByStudentOutputVO = new IssHelperRidesPostedByStudentOutputVO();
		issHelperRidesPostedByStudentOutputVO.setRRBS_Id(rs.getInt("RRBS_Id"));
		issHelperRidesPostedByStudentOutputVO.setRRBS_Date(rs.getString("RRBS_Date"));
		issHelperRidesPostedByStudentOutputVO.setRRBS_Time(rs.getString("RRBS_Time"));
		issHelperRidesPostedByStudentOutputVO.setRRBS_Air_Code(rs.getString("RRBS_Air_Code"));
		issHelperRidesPostedByStudentOutputVO.setRRBS_T_Number(rs.getInt("RRBS_T_Number"));
		issHelperRidesPostedByStudentOutputVO.setRRBS_Seats(rs.getInt("RRBS_Seats"));
		issHelperRidesPostedByStudentOutputVO.setRRBS_City(rs.getString("RRBS_City"));
		issHelperRidesPostedByStudentOutputVO.setRRBS_State(rs.getString("RRBS_State"));
		issHelperRidesPostedByStudentOutputVO.setRRBS_Street(rs.getString("RRBS_Street"));
		issHelperRidesPostedByStudentOutputVO.setRRBS_Zip(rs.getInt("RRBS_Zip"));

		return issHelperRidesPostedByStudentOutputVO;
	}

}

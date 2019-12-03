//SJSU CMPE 138 Fall2019 TEAM8
package com.isshelper.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.isshelper.output.IssHelperProviderViewRidesPostedByStudentOutputVO;

public class IssHelperProviderViewRidesPostedByStudentByRowMapper
		implements RowMapper<IssHelperProviderViewRidesPostedByStudentOutputVO> {

	public IssHelperProviderViewRidesPostedByStudentOutputVO mapRow(ResultSet rs, int rowNum) throws SQLException {

		IssHelperProviderViewRidesPostedByStudentOutputVO issHelperProviderViewRidesPostedByStudentOutputVO = new IssHelperProviderViewRidesPostedByStudentOutputVO();
		issHelperProviderViewRidesPostedByStudentOutputVO.setRRBS_Id(rs.getInt("RRBS_Id"));
		issHelperProviderViewRidesPostedByStudentOutputVO.setRRBS_Date(rs.getString("RRBS_Date"));
		issHelperProviderViewRidesPostedByStudentOutputVO.setRRBS_Time(rs.getString("RRBS_Time"));
		issHelperProviderViewRidesPostedByStudentOutputVO.setRRBS_Air_Code(rs.getString("RRBS_Air_Code"));
		issHelperProviderViewRidesPostedByStudentOutputVO.setRRBS_T_Number(rs.getInt("RRBS_T_Number"));
		issHelperProviderViewRidesPostedByStudentOutputVO.setRRBS_Seats(rs.getInt("RRBS_Seats"));
		issHelperProviderViewRidesPostedByStudentOutputVO.setRRBS_S_Id(rs.getString("RRBS_S_Id"));
		issHelperProviderViewRidesPostedByStudentOutputVO.setRRBS_Street(rs.getString("RRBS_Street"));
		issHelperProviderViewRidesPostedByStudentOutputVO.setRRBS_City(rs.getString("RRBS_City"));
		issHelperProviderViewRidesPostedByStudentOutputVO.setRRBS_State(rs.getString("RRBS_State"));
		issHelperProviderViewRidesPostedByStudentOutputVO.setRRBS_Zip(rs.getInt("RRBS_Zip"));

		return issHelperProviderViewRidesPostedByStudentOutputVO;
	}

}

//SJSU CMPE 138 Fall2019 TEAM8
package com.isshelper.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.isshelper.output.IssHelperProviderDashBoardRidesAcceptedByProviderOutputVO;

public class IssHelperProviderDashBoardRidesAcceptedByProviderRowMapper
		implements RowMapper<IssHelperProviderDashBoardRidesAcceptedByProviderOutputVO> {

	public IssHelperProviderDashBoardRidesAcceptedByProviderOutputVO mapRow(ResultSet rs, int rowNum)
			throws SQLException {

		IssHelperProviderDashBoardRidesAcceptedByProviderOutputVO issHelperProviderDashBoardRidesAcceptedByProviderOutputVO = new IssHelperProviderDashBoardRidesAcceptedByProviderOutputVO();

		issHelperProviderDashBoardRidesAcceptedByProviderOutputVO.setR_Id(rs.getInt("R_Id"));
		issHelperProviderDashBoardRidesAcceptedByProviderOutputVO.setR_Date(rs.getString("R_Date"));
		issHelperProviderDashBoardRidesAcceptedByProviderOutputVO.setR_Time(rs.getString("R_Time"));
		issHelperProviderDashBoardRidesAcceptedByProviderOutputVO.setR_Rating(rs.getInt("R_Rating"));
		issHelperProviderDashBoardRidesAcceptedByProviderOutputVO
				.setR_Starting_Air_Code(rs.getString("R_Starting_Air_Code"));
		issHelperProviderDashBoardRidesAcceptedByProviderOutputVO
				.setR_Starting_Terminal(rs.getInt("R_Starting_Terminal"));
		issHelperProviderDashBoardRidesAcceptedByProviderOutputVO.setR_Current(rs.getInt("R_Current"));
		issHelperProviderDashBoardRidesAcceptedByProviderOutputVO.setR_Total(rs.getInt("R_Total"));
		issHelperProviderDashBoardRidesAcceptedByProviderOutputVO.setS_Name(rs.getString("S_Name"));
		issHelperProviderDashBoardRidesAcceptedByProviderOutputVO.setS_Email(rs.getString("S_Email"));
		return issHelperProviderDashBoardRidesAcceptedByProviderOutputVO;
	}

}

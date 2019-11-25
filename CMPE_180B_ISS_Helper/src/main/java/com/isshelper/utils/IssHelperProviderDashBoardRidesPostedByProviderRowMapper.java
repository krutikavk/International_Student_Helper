package com.isshelper.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.isshelper.output.IssHelperProviderDashBoardRidesPostedByProviderOutputVO;

public class IssHelperProviderDashBoardRidesPostedByProviderRowMapper
		implements RowMapper<IssHelperProviderDashBoardRidesPostedByProviderOutputVO> {
	public IssHelperProviderDashBoardRidesPostedByProviderOutputVO mapRow(ResultSet rs, int rowNum)
			throws SQLException {

		IssHelperProviderDashBoardRidesPostedByProviderOutputVO issHelperProviderDashBoardRidesPostedByProviderOutputVO = new IssHelperProviderDashBoardRidesPostedByProviderOutputVO();

		issHelperProviderDashBoardRidesPostedByProviderOutputVO.setRPBP_Id(rs.getInt("RPBP_Id"));
		issHelperProviderDashBoardRidesPostedByProviderOutputVO.setRPBP_Date(rs.getString("RPBP_Date"));
		issHelperProviderDashBoardRidesPostedByProviderOutputVO.setRPBP_Time(rs.getString("RPBP_Time"));
		issHelperProviderDashBoardRidesPostedByProviderOutputVO.setRPBP_From(rs.getString("RPBP_From"));
		issHelperProviderDashBoardRidesPostedByProviderOutputVO.setRPBP_Current(rs.getInt("RPBP_Current"));
		issHelperProviderDashBoardRidesPostedByProviderOutputVO.setRPBP_Total(rs.getInt("RPBP_Total"));

		return issHelperProviderDashBoardRidesPostedByProviderOutputVO;
	}
}

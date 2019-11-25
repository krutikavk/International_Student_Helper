package com.isshelper.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.isshelper.output.IssHelperGetBrandNewRidesPostedByProviderOutputVO;

public class IssHelperGetBrandNewRidesPostedByProviderrRowMapper
		implements RowMapper<IssHelperGetBrandNewRidesPostedByProviderOutputVO> {

	public IssHelperGetBrandNewRidesPostedByProviderOutputVO mapRow(ResultSet rs, int rowNum) throws SQLException {

		IssHelperGetBrandNewRidesPostedByProviderOutputVO issHelperGetBrandNewRidesPostedByProviderOutputVO = new IssHelperGetBrandNewRidesPostedByProviderOutputVO();
		issHelperGetBrandNewRidesPostedByProviderOutputVO.setRPBP_Id(rs.getInt("RPBP_Id"));
		issHelperGetBrandNewRidesPostedByProviderOutputVO.setRPBP_Drivers_License(rs.getString("RPBP_Drivers_License"));
		issHelperGetBrandNewRidesPostedByProviderOutputVO.setRPBP_Date(rs.getString("RPBP_Date"));
		issHelperGetBrandNewRidesPostedByProviderOutputVO.setRPBP_Time(rs.getString("RPBP_Time"));
		issHelperGetBrandNewRidesPostedByProviderOutputVO.setRPBP_From(rs.getString("RPBP_From"));
		issHelperGetBrandNewRidesPostedByProviderOutputVO.setRPBP_Total(rs.getInt("RPBP_Total"));
		return issHelperGetBrandNewRidesPostedByProviderOutputVO;

	}

}

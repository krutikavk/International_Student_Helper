//SJSU CMPE 138 Fall2019 TEAM8

package com.isshelper.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.isshelper.output.IssHelperAppartmentsOutputVO;

public class IssHelperAppartmentRowMapper implements RowMapper<IssHelperAppartmentsOutputVO> {

	public IssHelperAppartmentsOutputVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		IssHelperAppartmentsOutputVO issHelperAppartmentsOutputVO = new IssHelperAppartmentsOutputVO();

		issHelperAppartmentsOutputVO.setA_Name(rs.getString("A_Name"));
		issHelperAppartmentsOutputVO.setA_Distance(rs.getFloat("A_Distance"));
		issHelperAppartmentsOutputVO.setA_Website(rs.getString("A_Website"));
		issHelperAppartmentsOutputVO.setA_City(rs.getString("A_City"));
		issHelperAppartmentsOutputVO.setA_Street(rs.getString("A_Street"));
		issHelperAppartmentsOutputVO.setA_State(rs.getString("A_State"));
		issHelperAppartmentsOutputVO.setA_Zip(rs.getInt("A_Zip"));

		return issHelperAppartmentsOutputVO;
	}

}

package com.isshelper.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.isshelper.pojo.RideProvider;

public class IssHelperRideProviderRowMapper implements RowMapper<RideProvider> {

	public RideProvider mapRow(ResultSet rs1, int rowNum) throws SQLException {

		RideProvider rideProvider = new RideProvider();
		rideProvider.setP_Drivers_License(rs1.getString("P_Drivers_License"));
		rideProvider.setP_Email(rs1.getString("P_Email"));
		rideProvider.setP_Name(rs1.getString("P_Name"));
		rideProvider.setP_Phone(rs1.getLong("P_Phone"));
		return rideProvider;

	}
}
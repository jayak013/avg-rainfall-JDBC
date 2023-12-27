package com.zettamine.rainfall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zettamine.rainfall.dto.AnnualRainFall;

public class RainfallDAOImpl implements RainfallDAO{

	@Override
	public int saveCity(AnnualRainFall aRF){
		int rowsSaved = 0;
		try {
			Connection con = DBHandler.establishConnection();
			PreparedStatement pst = con.prepareStatement("INSERT INTO annual_rain_fall values(?,?,?)");
			pst.setInt(1, aRF.getPincode());
			pst.setString(2, aRF.getCityName());
			pst.setDouble(3, aRF.getAvgerageRainfall());
			rowsSaved =  pst.executeUpdate();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return rowsSaved;
	}

	@Override
	public List<AnnualRainFall> findMaximumRainfallCities() {
		List<AnnualRainFall> list = new ArrayList<AnnualRainFall>();
		try {
			Connection con = DBHandler.establishConnection();
			Statement st = con.createStatement();
			String query = "select * from annual_rain_fall where average_annual_rainfall = (select max(average_annual_rainfall) from annual_rain_fall)";
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				int cityPinCode = rs.getInt(1);
				String cityName = rs.getString(2);
				double avgRainFall = rs.getDouble(3);
				AnnualRainFall aRF = new AnnualRainFall(cityPinCode, cityName, avgRainFall);
				list.add(aRF);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return list;
	}



}

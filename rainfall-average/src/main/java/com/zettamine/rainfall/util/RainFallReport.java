package com.zettamine.rainfall.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.zettamine.rainfall.dao.RainfallDAO;
import com.zettamine.rainfall.dao.RainfallDAOImpl;
import com.zettamine.rainfall.dto.AnnualRainFall;

public class RainFallReport {

	
	public static List<AnnualRainFall> generateRainFallReport(String filePath){
		List<AnnualRainFall> listOfAverageRainFallCities = new ArrayList<AnnualRainFall>();
		try {
			FileReader fR = new FileReader(new File(filePath));
			BufferedReader bR = new BufferedReader(fR);
			String readLine = bR.readLine();
			while(readLine!=null) {
				String[] split = readLine.split(",");
				String cityPinCode = split[0];
				int pinCode = 0,sum = 0;
				if(validate(cityPinCode)) {
					pinCode = Integer.parseInt(cityPinCode);
				}else throw new InvalidCityPincodeException();
				String cityName = split[1];
				double[] monthlyRainFall = new double[12];
				for(int i = 2;i<monthlyRainFall.length;i++) {
					monthlyRainFall[i-2] = Double.valueOf(split[i]);
				}
				AnnualRainFall aRF = new AnnualRainFall(pinCode, cityName, 
						new AnnualRainFall().calculateAverageAnnualRainfall(monthlyRainFall));
				listOfAverageRainFallCities.add(aRF);
				readLine = bR.readLine();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return listOfAverageRainFallCities;
	}
	
	//act as a service method to get max rainfall cities
	public static List<AnnualRainFall> findMaximumRainfallCities(){
		RainfallDAO rDAO = new RainfallDAOImpl();
		return rDAO.findMaximumRainfallCities();
	}
	
	//act as a service method to save the data
	public static int saveData(AnnualRainFall aRF) {
		RainfallDAO rDAO = new RainfallDAOImpl();
		return rDAO.saveCity(aRF);
	}
	
	public static boolean validate(String cityPinCode) {
		return cityPinCode.matches("[0-9]{5}");
	}
}

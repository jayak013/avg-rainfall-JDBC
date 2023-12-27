package com.zettamine.rainfall.app;

import java.util.List;

import com.zettamine.rainfall.dto.AnnualRainFall;
import com.zettamine.rainfall.util.RainFallReport;

public class RainFallApplication {
	
	public static void main(String[] args) {
		String filePath = "C:\\Users\\S Jaya Krishna\\Desktop\\AllCityMonthlyRainfall.txt";
		List<AnnualRainFall> report = RainFallReport.generateRainFallReport(filePath);
		int totalrecordsAdded = 0;
		for(AnnualRainFall aRF:report) {
			totalrecordsAdded+=RainFallReport.saveData(aRF);
		}
		System.out.println("Total records Added are :"+totalrecordsAdded);
		List<AnnualRainFall> highRainFallCities = RainFallReport.findMaximumRainfallCities();
		String header = String.format("%-8s | %-15s | %-15s","pincode","city","avgRainfall");
		System.out.println(header);
		for(AnnualRainFall aRF: highRainFallCities) {
			String format = String.format("%-8d | %-15s | %-15.2f",aRF.getPincode(),aRF.getCityName(),aRF.getAvgerageRainfall());
			System.out.println(format);
		}
	}
	
}

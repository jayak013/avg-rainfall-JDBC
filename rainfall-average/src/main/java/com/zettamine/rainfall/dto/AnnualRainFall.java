package com.zettamine.rainfall.dto;

public class AnnualRainFall {
	private int pincode;
	private String cityName;
	private double avgerageRainfall;
	
	public AnnualRainFall() {}
	
	public AnnualRainFall(int pincode, String cityName, double avgerageRainfall) {
		super();
		this.pincode = pincode;
		this.cityName = cityName;
		this.avgerageRainfall = avgerageRainfall;
	}

	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public double getAvgerageRainfall() {
		return avgerageRainfall;
	}
	public void setAvgerageRainfall(double avgerageRainfall) {
		this.avgerageRainfall = avgerageRainfall;
	}
	
	public double calculateAverageAnnualRainfall(double monthlyRainFall[]) {
		double sum = 0;
		for(int i = 0;i<monthlyRainFall.length;i++) {
			sum+=Double.valueOf(monthlyRainFall[i]);
		}
		double avg = sum/12;
		return avg;
	}

	@Override
	public String toString() {
		return "AnnualRainFall [pincode=" + pincode + ", cityName=" + cityName + ", avgerageRainfall="
				+ avgerageRainfall + "]\n";
	}
	
	
}

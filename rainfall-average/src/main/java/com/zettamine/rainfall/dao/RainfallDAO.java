package com.zettamine.rainfall.dao;

import java.sql.Connection;
import java.util.List;

import com.zettamine.rainfall.dto.AnnualRainFall;

public interface RainfallDAO {
	int saveCity(AnnualRainFall aRF);
	List<AnnualRainFall> findMaximumRainfallCities();
}

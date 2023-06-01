package com.sarudr.weekendtripservice.service;

import java.util.List;

import com.sarudr.weekendtripservice.dto.CityPojo;
import com.sarudr.weekendtripservice.model.City;

public interface CityService {

	City getById(long cityId);

	String changeStatus(long cityId);

	CityPojo saveCity(CityPojo citypojo);

	CityPojo updateCity(long cityId, CityPojo cityPojo);

	List<City> getAllCities();
}

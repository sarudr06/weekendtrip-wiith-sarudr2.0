package com.sarudr.weekendtripservice.dto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.sarudr.weekendtripservice.model.City;

@Component
public class CityConvertor {

	public CityPojo convertEntityToDto(City city) {
		ModelMapper modelMapper = new ModelMapper();

		return modelMapper.map(city, CityPojo.class);
	}

	public City convertDtoToEntity(CityPojo cityPojo) {
		ModelMapper modelMapper = new ModelMapper();

		return modelMapper.map(cityPojo, City.class);
	}
}

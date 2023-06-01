package com.sarudr.weekendtripservice.dto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.sarudr.weekendtripservice.model.Place;

@Component
public class PlaceConvertor {

	public PlacePojo convertEntityToDto(Place place) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(place, PlacePojo.class);
	}

	public Place convertDtoToEntity(PlacePojo placePojo) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(placePojo, Place.class);
	}
}

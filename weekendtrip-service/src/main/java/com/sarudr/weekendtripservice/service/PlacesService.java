package com.sarudr.weekendtripservice.service;

import java.util.List;

import com.sarudr.weekendtripservice.dto.PlacePojo;
import com.sarudr.weekendtripservice.model.Place;

public interface PlacesService {

	PlacePojo savePlace(PlacePojo placePojo);

	List<Place> getPlaces();

	Place getPlaceById(long packid);

	PlacePojo updatePlace(long placeId, PlacePojo placePojo);

	PlacePojo saveplaceById(long packId, PlacePojo placePojo);

	String changeStatus(long placeId);
}
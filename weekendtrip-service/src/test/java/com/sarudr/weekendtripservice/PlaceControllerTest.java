package com.sarudr.weekendtripservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sarudr.weekendtripservice.controller.PlacesController;
import com.sarudr.weekendtripservice.dto.PlacePojo;
import com.sarudr.weekendtripservice.model.Place;
import com.sarudr.weekendtripservice.service.PlacesService;

@SpringBootTest
class PlaceControllerTest {
	@Mock
	private PlacesService placesService;

	@InjectMocks
	private PlacesController controller;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testSavePlace() {
		PlacePojo placePojo = new PlacePojo();
		PlacePojo savePlace = new PlacePojo();

		when(placesService.savePlace(savePlace)).thenReturn(savePlace);

		ResponseEntity<PlacePojo> entity = controller.savePlace(savePlace);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		assertEquals(savePlace, entity.getBody());

		verify(placesService, times(1)).savePlace(placePojo);
		verifyNoMoreInteractions(placesService);

	}

	@Test
	void testGetAllPlaces() {

		List<Place> places = new ArrayList<>();

		when(placesService.getPlaces()).thenReturn(places);

		ResponseEntity<List<Place>> response = controller.findAllPlaces();

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(places, response.getBody());

		verify(placesService, times(1)).getPlaces();
		verifyNoMoreInteractions(placesService);
	}

	@Test
	void testUpdatePack() {
		PlacePojo placePojo = new PlacePojo();
		PlacePojo updatePlace = new PlacePojo();

		when(placesService.updatePlace(1, placePojo)).thenReturn(updatePlace);

		PlacePojo result = controller.updatePlaceByPlaceId(1, updatePlace);

		assertEquals(updatePlace, result);

		verify(placesService, times(1)).updatePlace(1, placePojo);
		verifyNoMoreInteractions(placesService);
	}

	@Test
	 void changeStatusOfPack() {

		String val = null;

		when(placesService.changeStatus(1)).thenReturn(val);

		ResponseEntity<String> entity = controller.changeStatusOfPlace(1);

		assertEquals(HttpStatus.OK, entity.getStatusCode());


		verify(placesService, times(1)).changeStatus(1);
	}
}

//package com.sarudr.travellerTest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.Optional;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import com.sarudr.travellerservice.controller.TravellerController;
//import com.sarudr.travellerservice.model.Passenger;
//import com.sarudr.travellerservice.model.PasssengerDto;
//import com.sarudr.travellerservice.model.Traveller;
//import com.sarudr.travellerservice.model.TravellerConvertor;
//import com.sarudr.travellerservice.model.TravellerDto;
//import com.sarudr.travellerservice.service.PassengersService;
//import com.sarudr.travellerservice.service.TravellersService;
//
//class TravellerControllerTest {
//
//	@Mock
//	private TravellersService travellersService;
//
//	@Mock
//	private PassengersService passengersService;
//
//	@InjectMocks
//	private TravellerController travellerController;
//
//	@BeforeEach
//	void setUp() {
//		MockitoAnnotations.openMocks(this);
//	}
//
//	@Test
//	void testGetAllTraveller() {
//		List<Traveller> travellerList = new ArrayList<>();
//		when(travellersService.getTraveller()).thenReturn(travellerList);
//
//		ResponseEntity<List<Traveller>> response = travellerController.getAllTraveller();
//
//		assertEquals(HttpStatus.OK, response.getStatusCode());
//		assertEquals(travellerList, response.getBody());
//
//		verify(travellersService, times(1)).getTraveller();
//	}
//
//	@Test
//	void testGetTravellerById() {
//		long id = 1;
//		Traveller traveller = new Traveller();
//		when(travellersService.getTravellerById(id)).thenReturn(traveller);
//
//		ResponseEntity<Traveller> response = travellerController.getTravellerById(id);
//
//		assertEquals(HttpStatus.OK, response.getStatusCode());
//		assertEquals(traveller, response.getBody());
//
//		verify(travellersService, times(1)).getTravellerById(id);
//	}
//
////	@Test
////	void testSaveTraveller() {
////		TravellerDto travellerDto = new TravellerDto();
////		TravellerDto savedTravellerDto = new TravellerDto();
////		when(travellersService.saveTraveller(travellerDto)).thenReturn(savedTravellerDto);
////
////		ResponseEntity<TravellerDto> response = travellerController.saveTraveller(travellerDto);
////
////		assertEquals(HttpStatus.OK, response.getStatusCode());
////		assertEquals(savedTravellerDto, response.getBody());
////
////		verify(travellersService, times(1)).saveTraveller(travellerDto);
////	}
//
//	@Test
//	void testDeleteTraveller() {
//		long id = 1;
//
//		ResponseEntity<String> response = travellerController.deleteTraveller(id);
//
//		assertEquals(HttpStatus.OK, response.getStatusCode());
//		assertEquals("Traveller are deleted", response.getBody());
//
//		verify(travellersService, times(1)).deleteTravellerById(id);
//	}
//
//	@Test
//	void testGetAllPassengers() {
//		List<Passenger> passengerList = new ArrayList<>();
//		when(passengersService.getPassengers()).thenReturn(passengerList);
//
//		ResponseEntity<List<Passenger>> response = travellerController.getAllPasssengers();
//
//		assertEquals(HttpStatus.OK, response.getStatusCode());
//		assertEquals(passengerList, response.getBody());
//
//		verify(passengersService, times(1)).getPassengers();
//	}
//
//	@Test
//	void testGetAllTravellersPagination() {
//		int page = 0;
//		int size = 5;
//
//		List<Traveller> travellerList = new ArrayList<>();
//		Page<Traveller> pageResult = new PageImpl<>(travellerList);
//		when(travellersService.findAll(PageRequest.of(page, size))).thenReturn(pageResult);
//
//		ResponseEntity<Map<String, Object>> response = travellerController.getAllTravellersPagination(page, size);
//
//		assertEquals(HttpStatus.OK, response.getStatusCode());
//		assertEquals(travellerList, response.getBody().get("travellers"));
//
//		verify(travellersService, times(1)).findAll(PageRequest.of(page, size));
//	}
//
//	@Test
//	void testSavePassenger() {
//		PasssengerDto passsengerDto = new PasssengerDto();
//		PasssengerDto savedPassengerDto = new PasssengerDto();
//		when(passengersService.savePassengers(passsengerDto)).thenReturn(savedPassengerDto);
//
//		ResponseEntity<PasssengerDto> response = travellerController.savePassenger(passsengerDto);
//
//		assertEquals(HttpStatus.OK, response.getStatusCode());
//		assertEquals(savedPassengerDto, response.getBody());
//
//		verify(passengersService, times(1)).savePassengers(passsengerDto);
//	}
//
//	@Test
//	void testDeletePassenger() {
//		long id = 1;
//
//		ResponseEntity<String> response = travellerController.deletePassenger(id);
//
//		assertEquals(HttpStatus.OK, response.getStatusCode());
//		assertEquals("passeneger are deleted", response.getBody());
//
//		verify(passengersService, times(1)).deletePasssengerById(id);
//	}
//
//	
//}

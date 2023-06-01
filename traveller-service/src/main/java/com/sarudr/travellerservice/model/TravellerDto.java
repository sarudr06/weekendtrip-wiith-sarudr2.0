//package com.sarudr.travellerservice.model;
//
//import java.util.Date;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.FetchType;
//import javax.persistence.OneToMany;
//
//import com.fasterxml.jackson.annotation.JsonManagedReference;
//
//import lombok.Data;
//
//@Data
//public class TravellerDto {
//	private Long travellerId;
//
//	private String travellerEmail;
//
//	private Date journeyStartingDate;
//
//	private Date journeyEndingDate;
//
//	private String packageName;
//
//	private double packagePrice;
//
//	private Date purchaseDate;
//
//	private boolean paymentStatus;
////
////	private String cityName;
////	
////	@OneToMany(mappedBy = "traveller", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
////	@JsonManagedReference
////	List<Passenger> passenger;
//}

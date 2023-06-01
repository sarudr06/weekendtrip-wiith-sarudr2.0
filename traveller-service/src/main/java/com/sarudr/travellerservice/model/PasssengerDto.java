//package com.sarudr.travellerservice.model;
//
//import javax.persistence.CascadeType;
//import javax.persistence.FetchType;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//
//import lombok.Data;
//
//@Data
//public class PasssengerDto {
//
//	private Long passengerId;
//
//	private String passengerName;
//
//	private int passengerAge;
//
//	private String passengerGender;
//
//	private String passengerAadhar;
//	
//	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	@JoinColumn(name = "refId", referencedColumnName = "travellerId")
//	@JsonBackReference
//	Traveller traveller;
//
//}

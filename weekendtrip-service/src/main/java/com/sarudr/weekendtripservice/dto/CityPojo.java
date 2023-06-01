package com.sarudr.weekendtripservice.dto;

import java.util.List;

import com.sarudr.weekendtripservice.model.Package;

import lombok.Data;

@Data
public class CityPojo {
	private Long cityId;

	private String cityName;

	private String status;

	private String cImageUrl;

	
	private List<Package> packages;

	
}

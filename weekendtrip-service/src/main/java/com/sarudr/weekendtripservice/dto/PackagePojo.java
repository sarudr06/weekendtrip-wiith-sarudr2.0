package com.sarudr.weekendtripservice.dto;

import java.util.List;

import lombok.Data;

@Data

public class PackagePojo {

	private Long packageId;

	private String packageName;

	private String packageCategory;

	private Double packagePrice;

	private String packageStatus;

	private String pImageUrl;

	private String packageDescription;

	private CityPojo cityPojo;

	private List<PlacePojo> places;


}
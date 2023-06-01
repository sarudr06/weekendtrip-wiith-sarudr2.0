package com.sarudr.weekendtripservice.dto;

import lombok.Data;

@Data

public class PlacePojo {

	private Long placeId;

	private String placeName;

	private String placeStatus;

	private String placeImgUrl;

	private PackagePojo packagePojo;

}

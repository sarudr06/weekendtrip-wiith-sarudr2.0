package com.sarudr.weekendtripservice.dto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.sarudr.weekendtripservice.model.Package;

@Component
public class PackageConvertor {

	public PackagePojo convertEntityToDto(Package packages) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(packages, PackagePojo.class);

	}

	public Package convertDtoToEntity(PackagePojo packagePojo) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(packagePojo, Package.class);

	}
}

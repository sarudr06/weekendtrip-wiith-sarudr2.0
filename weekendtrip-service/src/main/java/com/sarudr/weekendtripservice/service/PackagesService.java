package com.sarudr.weekendtripservice.service;

import java.util.List;
import java.util.Optional;

import com.sarudr.weekendtripservice.dto.PackagePojo;
import com.sarudr.weekendtripservice.model.Package;

public interface PackagesService {

	PackagePojo savePackage(PackagePojo pack);

	List<Package> getPack();

	Package getPackById(long packId);

	PackagePojo updatepack(long packId, PackagePojo pack);

	PackagePojo savepackageById(long cityId, PackagePojo pack);

	String changeStatus(long packId);

	Optional<Package> findbypackName(String packageName);
}

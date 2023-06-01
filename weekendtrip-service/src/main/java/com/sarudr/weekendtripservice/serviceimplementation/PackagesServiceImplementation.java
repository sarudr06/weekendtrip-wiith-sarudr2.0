package com.sarudr.weekendtripservice.serviceimplementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarudr.weekendtripservice.dto.PackageConvertor;
import com.sarudr.weekendtripservice.dto.PackagePojo;
import com.sarudr.weekendtripservice.model.City;
import com.sarudr.weekendtripservice.model.Package;
import com.sarudr.weekendtripservice.model.Place;
import com.sarudr.weekendtripservice.repository.CityRepository;
import com.sarudr.weekendtripservice.repository.PackageRepository;
import com.sarudr.weekendtripservice.repository.PlaceRepository;
import com.sarudr.weekendtripservice.service.PackagesService;

@Service
public class PackagesServiceImplementation implements PackagesService {
	@Autowired(required = true)
	CityRepository cityRepository;

	@Autowired(required = true)
	PackageRepository packageRepository;

	@Autowired(required = true)
	PlaceRepository placeRepository;

	@Autowired
	PackageConvertor convertor;
	
	@Override
	public PackagePojo savePackage(PackagePojo pack) {
		Package package1=convertor.convertDtoToEntity(pack);
		List<City> cities = cityRepository.findAll();
		for (City city : cities) {
			if (city.getCityId().equals(package1.getCity().getCityId())) {
				package1.setCity(city);
			}
		}
//		packageRepository.save(package1);
		return convertor.convertEntityToDto(packageRepository.save(package1));
	}


	@Override
	public List<Package> getPack() {
		return packageRepository.findAll();
	}

	@Override
	public Package getPackById(long packid) {
		return packageRepository.findById(packid).orElse(null);
	}

	@Override
	public PackagePojo updatepack(long packid, PackagePojo pack) {
		Package package1=convertor.convertDtoToEntity(pack);
		package1.setPackageId(packid);
//		 packageRepository.save(package1);
		 return convertor.convertEntityToDto(packageRepository.save(package1));
	}


	@Override
	public PackagePojo savepackageById(long cityid, PackagePojo pack) {
		Package package1=convertor.convertDtoToEntity(pack);
		List<City> cityList = cityRepository.findAll();
		for (City city : cityList) {
			if (city.getCityId().equals(cityid)) {
				package1.setCity(city);
			}
		}
//		 packageRepository.save(package1);
		 return convertor.convertEntityToDto(packageRepository.save(package1));
	}

	@Override
	public String changeStatus(long packId) {
	    List<Package> packageList = packageRepository.findAll();
	    List<Place> placeList = placeRepository.findAll();
	    String active = "Active";
	    String inActive = "InActive";

	    updatePackageStatus(packId, packageList, active, inActive);
	    updatePlaceStatus(packId, placeList, active, inActive);

	    return "Status Changed " + packId;
	}

	private void updatePackageStatus(long packId, List<Package> packageList, String active, String inActive) {
	    for (Package packages : packageList) {
	        if (packages.getPackageId().equals(packId)) {
	            if (packages.getPackageStatus().equalsIgnoreCase(inActive)) {
	                packages.setPackageStatus(active);
	            } else if (packages.getPackageStatus().equalsIgnoreCase(active)) {
	                packages.setPackageStatus(inActive);
	            }
	            packageRepository.save(packages);
	        }
	    }
	}

	private void updatePlaceStatus(long packId, List<Place> placeList, String active, String inActive) {
	    for (Place place : placeList) {
	        if (place.getPackages().getPackageId().equals(packId)) {
	            if (place.getPackages().getPackageStatus().equalsIgnoreCase(active)) {
	                place.setPlaceStatus(active);
	            } else if (place.getPackages().getPackageStatus().equalsIgnoreCase(inActive)) {
	                place.setPlaceStatus(inActive);
	            }
	            placeRepository.save(place);
	        }
	    }
	}


	@Override
	public Optional<Package> findbypackName(String packageName) {
		return packageRepository.findByPackageName(packageName);
		
	}

}

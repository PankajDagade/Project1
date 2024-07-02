package com.main.travel.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.main.travel.SamrthTravelApplication;
import com.main.travel.model.SamrthTravel;

@Repository
public interface TravelRepository extends CrudRepository<SamrthTravel, String>{

	public SamrthTravel findByBusNumber(String busNumber);

	

}

package com.main.travel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.main.travel.model.Passenger;
import com.main.travel.model.SamrthTravel;
import com.main.travel.service.TravelService;

import jakarta.validation.Valid;

@RestController
public class TravelController {
	
	@Autowired TravelService travelService;
	
	
	    @PostMapping("/travel")
	    public ResponseEntity<SamrthTravel> postSamrthTravel(@Valid @RequestBody SamrthTravel samrthTravel) 
	    {
	        SamrthTravel samrthTravel1 = travelService.postSamrthTravel(samrthTravel);
	        return new ResponseEntity<>(samrthTravel1, HttpStatus.CREATED);
	    }
	    
	    @PutMapping("/travel/{busNumber}/{seatId}")
	    public ResponseEntity<SamrthTravel> updatePassenger(@RequestBody Passenger passenger,
                @PathVariable String busNumber,
                @PathVariable int seatId) {
	    	SamrthTravel s = travelService.update(passenger,busNumber,seatId);
	    	return new ResponseEntity<SamrthTravel>(s,HttpStatus.OK);
	    }
	    
	   
	    
}

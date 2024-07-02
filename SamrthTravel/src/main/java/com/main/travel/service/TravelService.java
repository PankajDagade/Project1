package com.main.travel.service;

import com.main.travel.model.Passenger;
import com.main.travel.model.SamrthTravel;

public interface TravelService {

	public SamrthTravel postSamrthTravel(SamrthTravel samrthTravel);

	public SamrthTravel update(Passenger passenger, String busNumber, int seatId);

}

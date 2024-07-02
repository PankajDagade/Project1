package com.main.travel.serviceImpl;


import java.util.*;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.travel.exception.NullException;
import com.main.travel.exception.SeatBooked;
import com.main.travel.exception.SeatIsNotNotAvailable;
import com.main.travel.model.Passenger;
import com.main.travel.model.SamrthTravel;
import com.main.travel.model.Seat;
import com.main.travel.repository.TravelRepository;
import com.main.travel.service.TravelService;


@Service
public class TravelServiceImpl implements TravelService {
	
	@Autowired TravelRepository travelRepository;

	@Override
	public SamrthTravel postSamrthTravel(SamrthTravel samrthTravel) {
		
		Set<Seat> listSeat = new LinkedHashSet<Seat>();
		
		for(int i=1 ; i<=samrthTravel.getBusSeatingCapacity() ; i++)
		{
			Seat seat = new Seat();
			if(i>=20)
			{
				seat.setSeatNumber("U"+i);
				seat.setSeatStatus("Available");
			}
			else
			{
				seat.setSeatId(i);
				seat.setSeatNumber("L"+i);
				seat.setSeatStatus("Available");
			}
			listSeat.add(seat);
		}
		
		samrthTravel.setSeats(listSeat);
		
		return travelRepository.save(samrthTravel);
		
		
	}

	@Override
	public SamrthTravel update(Passenger passenger, String busNumber,int seatId) {
		
	
		SamrthTravel sam = travelRepository.findByBusNumber(busNumber);

		if(sam!=null)
		{
			Set<Seat> seat = sam.getSeats();
			
			boolean seatFound = false;
			
			for(Seat seats : seat)
			{
				
				if(seats.getSeatId()==seatId)
				{
					seatFound=true;
					if(!seats.getSeatStatus().equals("Booked"))
					{
						 seats.setSeatStatus("Booked");
		                 seats.setPassenger(passenger);
					}
					else
					{
						throw new SeatBooked("Seat is already booked!!!!");
					}
					
				}
				
				
			}
			if(seatFound==false)
			{
				throw new SeatIsNotNotAvailable("Seat is not Available!!!!");
			}
		}
		else
		{
			throw new NullException("Bus is not Available !!!");
		}
		
		return travelRepository.save(sam);
	}

	
	
}

	



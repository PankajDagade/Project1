package com.main.travel.exception_response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.main.travel.exception.NullException;
import com.main.travel.exception.SeatBooked;
import com.main.travel.exception.SeatIsNotNotAvailable;
import com.main.travel.model.SamrthTravel;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@ExceptionHandler(NullException.class)
	public ResponseEntity<String> handleNullException(NullException n)
	{
		return new ResponseEntity<String>(n.getMessage(),HttpStatus.OK);
	}
	
	@ExceptionHandler(SeatIsNotNotAvailable.class)
	public ResponseEntity<String> handleSeatNotAvailable(SeatIsNotNotAvailable s)
	{
		return new ResponseEntity<String>(s.getMessage(),HttpStatus.OK);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> handleMethod(MethodArgumentNotValidException m)
	{
		return new ResponseEntity<String>(m.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(SeatBooked.class)
	public ResponseEntity<String> handleSeatBooked(SeatBooked s)
	{
		return new ResponseEntity<String>(s.getMessage(),HttpStatus.FOUND);
	}

}

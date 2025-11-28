package com.alpha.Hospital.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alpha.Hospital.ResponceStructure;

@RestControllerAdvice
public class GlobalExceptionHandler {
	 @ExceptionHandler(DoctorNotFoundEception.class)
	public ResponceStructure<String> DoctorNotFoundExhandler(){
		ResponceStructure<String> rs = new ResponceStructure<String>();
		
		rs.setStatuscode(HttpStatus.NOT_FOUND.value());
		rs.setMessage("doctor not found");
		rs.setData("doctor not found");
		
		return rs;
		}


}

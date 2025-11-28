package com.alpha.Hospital.Exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.alpha.Hospital.ResponceStructure;

@RestControllerAdvice
public class GlobalExceptionHandler {
	 @ExceptionHandler(DoctorNotFoundException.class)
	public ResponceStructure<String> DoctorNotFoundExhandler(){
		ResponceStructure<String> rs = new ResponceStructure<String>();
		
		rs.setStatuscode(HttpStatus.NOT_FOUND.value());
		rs.setMessage("doctor not found");
		rs.setData("doctor not found");
		
		return rs;
		}
	 
	 @ExceptionHandler(MethodArgumentNotValidException.class)
	 public ResponceStructure<Map<String, String>> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {

	     Map<String, String> errorMap = new HashMap<>();

	     
	     List<ObjectError> objErrors = ex.getAllErrors();

	     for (ObjectError objectError : objErrors) {

	         
	         System.err.println(objectError.getDefaultMessage());

	         FieldError fieldError = (FieldError) objectError;

	         System.err.println(fieldError.getField());

	        
	         errorMap.put(fieldError.getField(), objectError.getDefaultMessage());
	     }

	    
	     ResponceStructure<Map<String, String>> rs = new ResponceStructure<>();
	     rs.setStatuscode(HttpStatus.NOT_ACCEPTABLE.value());
	     rs.setMessage("VALIDATION FAILED");
	     rs.setData(errorMap);

	     return rs;
	 }

	 
	 @ExceptionHandler(jakarta.validation.ConstraintViolationException.class)
	 public ResponseEntity<ResponceStructure<Object>> handleHibernateConstraintViolation(jakarta.validation.ConstraintViolationException ex) {

	     Map<String, String> errors = new HashMap<>();

	     ex.getConstraintViolations().forEach(violation -> {
	         errors.put(
	             violation.getPropertyPath().toString(),
	             violation.getMessage()
	         );
	     });

	     ResponceStructure<Object> rs = new ResponceStructure<>();
	     rs.setStatuscode(HttpStatus.BAD_REQUEST.value());
	     rs.setMessage("Validation Error");
	     rs.setData(errors);

	     return new ResponseEntity<>(rs, HttpStatus.BAD_REQUEST);
	 }



}



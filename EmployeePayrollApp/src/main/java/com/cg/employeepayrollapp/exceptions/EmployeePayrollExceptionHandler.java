package com.cg.employeepayrollapp.exceptions;

import java.util.List;
import java.util.stream.Collectors;
import  lombok.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cg.employeepayrollapp.dto.ResponseDTO;

@ControllerAdvice
public class EmployeePayrollExceptionHandler {
	
	private static final String message="Exception while processing REST Request";
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseDTO> handleHttpMessageNotReadablException(HttpMessageNotReadableException exception) {
//		log.error("Invalid Date Format", exception);
		ResponseDTO responseDTO=new ResponseDTO(message,"Should have date in the Format dd MMM yyyy");
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception){
		List<ObjectError> errorList =exception.getBindingResult().getAllErrors();
		List<String> errMesg=errorList.stream()
				                       .map(objErr -> objErr.getDefaultMessage())
				                       .collect(Collectors.toList());
		ResponseDTO responseDTO=new ResponseDTO("Exception while processing REST Request", errMesg);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmployeePayrollException.class)
	public ResponseEntity<ResponseDTO> handleEmployeePayrollIdException(EmployeePayrollException exception){
		ResponseDTO responseDTO=new ResponseDTO("Exception while processing REST request", exception.getMessage());
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}
}

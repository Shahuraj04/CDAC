package com.vehicle.globalHandler;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.vehicle.controllers.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> handleRuntime(RuntimeException e){
		return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse("error", e.getMessage()));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleAll(MethodArgumentNotValidException e){
 		List<FieldError	> fieldErrors = e.getFieldErrors();
 		Map<String, String> collect = fieldErrors.stream().collect(Collectors.toMap(FieldError::getField,FieldError::getDefaultMessage));
		
		
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(collect);
		
	}
}

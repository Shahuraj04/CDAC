package com.organization.globalhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.organization.dto.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> handleRuntimeExce(RuntimeException e){
		
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(new ApiResponse("Runtime Error",e.getMessage()));
	}
}

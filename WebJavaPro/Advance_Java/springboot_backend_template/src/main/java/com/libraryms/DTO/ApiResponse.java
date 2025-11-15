package com.libraryms.DTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ApiResponse {

	private String message;
	private String status;
	private LocalDate localDate;

	public ApiResponse(String message, String status) {
		super();
		this.message = message;
		this.status = status;
		this.localDate = LocalDate.now();
	}

}

package com.healthcare.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@Setter
@ToString
public class BookAppointmentDTO {
	
	private Long doc_id;
	private LocalDateTime ts;

}

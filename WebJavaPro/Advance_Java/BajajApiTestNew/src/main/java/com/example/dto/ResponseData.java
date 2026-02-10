package com.example.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData {

	@JsonProperty("is_success")
	private boolean is_success;
	private String user_id;
	private String roll_number;
	private List<String> numbers;
	private List<String> alphabets;
	private List<String> highest_lowercase;
	
}

package com.example.controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.RequestData;
import com.example.dto.ResponseData;

@RestController
@RequestMapping("/test")
@org.springframework.web.bind.annotation.CrossOrigin(origins = "*")
public class BfhlController {
	
	@PostMapping
	public ResponseEntity<?> processData(@RequestBody RequestData data){
		List<String> alldata = data.getData();
		
		List<String> alphabets = alldata.stream().filter(s->s.matches("[a-zA-Z]")).collect(Collectors.toList());
		
		List<String> nums = alldata.stream().filter(s->s.matches("[0-9]")).collect(Collectors.toList());
		
		List<String> highestLower = alphabets.stream()
				.filter(s->s.matches("[a-z]"))
				.max(String::compareTo)
				.map(Collections::singletonList)
				.orElse(Collections.emptyList());
		
		
		ResponseData responseData= new ResponseData();
		responseData.set_success(true);
		responseData.setUser_id("shahu");
		responseData.setRoll_number("2580");
		responseData.setNumbers(nums);
		responseData.setAlphabets(alphabets);
		responseData.setHighest_lowercase(highestLower);
		
		return ResponseEntity.ok(responseData);
	}
	

}

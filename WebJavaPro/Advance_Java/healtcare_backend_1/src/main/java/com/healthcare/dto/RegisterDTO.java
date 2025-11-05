package com.healthcare.dto;

import com.healthcare.entities.BloodGroup;
import com.healthcare.entities.Gender;
import com.healthcare.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
	
	private User user;
	private Gender gender;
    private BloodGroup bloodGroup;
    private String familyHistory;

}

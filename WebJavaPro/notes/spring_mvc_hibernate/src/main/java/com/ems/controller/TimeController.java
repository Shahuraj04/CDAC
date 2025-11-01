package com.ems.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class TimeController {

	public TimeController() {
	System.out.println("in Timecontroller Constr");
	}
	@RequestMapping("/")
	
	public ModelAndView giveTime() {
		System.out.println("In givetime method");
		return new ModelAndView("testTS", "serverTS", LocalDateTime.now());
	}
}

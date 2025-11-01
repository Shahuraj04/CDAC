package com.ems.controller;

import org.eclipse.tags.shaded.org.apache.regexp.recompile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ems.service.DepartmentService;

@Controller
@RequestMapping("/department")
public class DepartmentController {

	private final TimeController timeController;

	public DepartmentController(TimeController timeController) {
		System.out.println("In DepartmentController constr");
		this.timeController = timeController;
	}

	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/list")
	public ModelAndView listAllDepts() {
		System.out.println("in list all contr");
		return new ModelAndView("dept/list", "department_list", departmentService.getAllDepartments()); // webinf/views/dept/list.jsp

	}

}

package com.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Fallback;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ems.Day15MvcBootApplication;
import com.ems.service.EmployeeService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/emps")
public class EmployeeController {

    private final Day15MvcBootApplication day15MvcBootApplication;
	//depcy
	@Autowired
	private EmployeeService employeeService;

    EmployeeController(Day15MvcBootApplication day15MvcBootApplication) {
        this.day15MvcBootApplication = day15MvcBootApplication;
    }
	/*
	 * Add req handling method - to render list of emps from dept
	 * URL - http://host:port/ctx_path/emps/list ,method=POST
	 * payload - departmentId =....
	 */
	@RequestMapping("/list")
	public String listEmpsByDepartment(Model modelAttrMap, 
			@RequestParam(required = false) Long departmentId)
	/*(name = "departmentId")*/
	//Request parameter arg annotation to bind incoming rq param->rq
	{
		System.out.println("in list emps " + modelAttrMap + " " + departmentId);// {}
		modelAttrMap.addAttribute("emp_list", employeeService.getEmpsByDeptId(departmentId));
		return "emps/list";//AVN - /WEB-INF/views/emps/list.jsp
		/*Handler rets explicitly -> LVN ->D.S.
		 * SC sends implicitly - model map->D.S.
		 * DS->LVN ->V.R.->AVN -> D.S.
		 * D.S. checks for model attributes -> present ->adds it under request scope
		 * ->forwards the client to view layer 
		 * */
		
	}
	@GetMapping("/delete")
	public String deleleEmpById(Model modelAttrMap,@RequestParam Long id,HttpSession session) {
		System.err.println("in delete method");
		session.setAttribute("message", employeeService.deleteEmpById(id));

		return "redirect:/emps/list";
	}

}

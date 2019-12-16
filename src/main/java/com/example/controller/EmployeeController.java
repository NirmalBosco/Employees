package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dao.EmployeeDao;
import com.example.dao.StudentDao;
import com.example.model.EmployeeModel;

@Controller
public class EmployeeController {

	@Autowired
	StudentDao StudentDao;

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String indexPage(Model m) {

		m.addAttribute("employees", new EmployeeModel());
		return "EmployeesRegisterForm";

	}

	@RequestMapping(value = "/empsave", method = RequestMethod.POST)
	public String saveEmployees(@ModelAttribute("employeeModel") EmployeeModel employeeModel) {
		StudentDao.empsave(employeeModel);

		return "redirect:empview";
	}

	@RequestMapping(value = "/empview", method = RequestMethod.GET)
	public String employeeList(Model m) {
		List<EmployeeModel> em = StudentDao.getEmployeesList();
		m.addAttribute("employees", em);
		return "viewEmployeesDetails";
	}
	
	@RequestMapping(value = "/empedit/{id}",method = RequestMethod.GET)
	public String editEmployee() {
		
		return null;
		
	}
}

package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dao.StudentDao;
import com.example.model.Student;

@Controller
@ComponentScan
public class StudentController {

	@Autowired
	StudentDao dao;

	@RequestMapping("/student")
	public String firstShow(Model m) {
		m.addAttribute("addStudent", new Student());
		return "addsts";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String addStudent(@ModelAttribute("stu") Student stu) {

		dao.save(stu);
		return "redirect:view";
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewStudent(Model m) {
		List<Student> list = dao.getStudents();
		m.addAttribute("list", list);

		return "viewStudent";

	}

	@RequestMapping(value = "/deleteStudent/{id}", method = RequestMethod.GET)
	public String deleteStudent(@PathVariable Long id) {
		dao.deleteStudent(id);
		return "redirect:/view";
	}

	@RequestMapping(value = "editemp/{id}", method = RequestMethod.GET)
	public String sutudentEdit(Model m, @PathVariable int id) {
		Student s = dao.getStuedentById(id);
		m.addAttribute("command", s);
		return "studentEdit";

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateStudent(@ModelAttribute("student") Student student) {
		dao.update(student);

		return "redirect:/view";

	}
}

package com.webapp.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.webapp.demo.entity.Employee;
import com.webapp.demo.service.EmpService;

import java.util.List;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService service;
	
	@GetMapping("/")
	public String home(Model m)
	{
		List<Employee> emp=service.getAllEmp();
		m.addAttribute("emp", emp);
		
		
		return "index";
	}
	
	@GetMapping("/addemp")
	public String addEmpForm() 
	{
		return "add_emp";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e, HttpSession session)
	{
		
		System.out.println(e);
		
		service.addEmp(e);
		session.setAttribute("msg", "Employee Addded Successfully..");
		
		return "redirect:/";
	}
	
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m)
	{
		
		Employee e=service.getEMpId(id);
		
		m.addAttribute("emp", e);
		
		return "edit";
	}
	
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute  Employee e,HttpSession session)
	{
		service.addEmp(e);
		session.setAttribute("msg", "Employee Data Update Sucessfully...");
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEMp(@PathVariable int id,HttpSession session)
	{
		
		service.deleteEMp(id);
		session.setAttribute("msg", "Employee Data delete Sucessfully...");
		return "redirect:/";
	}

}


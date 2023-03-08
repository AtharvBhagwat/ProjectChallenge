package com.jbk.TestProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.TestProject.model.Staff;
import com.jbk.TestProject.service.StaffService;

@RestController
public class StaffController {

	@Autowired
	StaffService ss;
	
	//1
	@GetMapping("/getallstaff")
	public List<Staff> getallStaffInfo() {
		
		List<Staff> staff=ss.getallStaffInfo();
		return staff;
	}
	
	//2
	@GetMapping("/getstaff=3")
	public List<Staff> getstaffinfo() {
		
		List<Staff> staff=ss.getstaffinfo();
		return staff;
	
	}
	
	//3
	@PostMapping("/insertStaff")
	public boolean insertStaffInfo(@RequestBody Staff staff) {
		return ss.insertStaffInfo(staff);
		
	}
	
	//4
	@GetMapping("/salarymorethan20")
	public List<Staff> getSpecialStaff() {
		List<Staff>staff=ss.getSpecialStaff();
		return staff;
	}
	
	
	//5
	@GetMapping("/expirancebetween10to20")
	public List<Staff> expirance() {
		List<Staff>staff=ss.expirance();
		return staff;
	}
	
	//6
	@GetMapping("/staffMaxSalary")
	public List<Staff> maxSalary() {
		return ss.maxSalary();
	}
	
	
	//7
	@PutMapping("/updateSalaryOfStaff4")
	public boolean updateSalary(@RequestBody int salary) {
		return ss.updateSalary(salary);
	}
	
	
	//8
	@GetMapping("/GetMinimumExpirance1212")
	public String getminExpirance() {
		return ss.getminExpirance();
		
	} 
	
	//9
	@GetMapping("/trainnerStaff")
	public List<Staff> trainner() {
		List<Staff>staff=ss.trainner();
		return staff;
	}
	
	//10
	@GetMapping("/notTrainnerStaff")
	public List<Staff> notTrainner() {
		List<Staff> staff=ss.notTrainner();
		return staff;
	}
	
}


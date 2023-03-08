package com.jbk.TestProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jbk.TestProject.dao.StaffDao;
import com.jbk.TestProject.model.Staff;

@Service
public class StaffService {

	@Autowired
	StaffDao ss;

	public List<Staff> getallStaffInfo() {

		List<Staff> staff=ss.getallStaffInfo();
		return staff;
	}


	public List<Staff> getstaffinfo() {

		List<Staff> staff =ss.getstaffinfo();
		return staff;
	}


	public boolean insertStaffInfo(Staff staff) {
	  return ss.insertStaffInfo(staff);
		
	}


	public List<Staff> getSpecialStaff() {
		List<Staff> staff=ss.getSpecialStaff();
		return staff;
 
		
	}


	public List<Staff> expirance() {
	return ss.expirance();
		
	}


	public List<Staff> maxSalary() {
		List<Staff> al=ss.maxSalary();
		return al;
	}


	public boolean updateSalary(int salary) {
		return ss.updateSalary(salary);
		
	}
	
	public String getminExpirance() {
		
		return ss.getminExpirance();
	}


	public List<Staff> trainner() {
		
	 return	ss.trainner();
	}


	public List<Staff> notTrainner() {
		
	return ss.notTrainner();
	}


	

}

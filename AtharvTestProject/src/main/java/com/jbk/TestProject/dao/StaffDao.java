package com.jbk.TestProject.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.TestProject.model.Staff;

@Repository
public class StaffDao {

	@Autowired
	SessionFactory sf;


	public List<Staff> getallStaffInfo() {

		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Staff.class);	
		List<Staff>staff=criteria.list();
		System.out.println(staff);
		session.close();
		return staff;
	}


	public List<Staff> getstaffinfo() {

		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Staff.class);
		criteria.add(Restrictions.idEq(3));
		List<Staff>staff=criteria.list();
		return staff;

	}


	public boolean insertStaffInfo(Staff staff) {
		Session session=sf.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(staff);

		transaction.commit();
		session.close();
		return true;
	}


	public List<Staff> getSpecialStaff() {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Staff.class);	
		criteria.add(Restrictions.gt("salary",20000));
		List<Staff>staff=criteria.list();
		session.close();
		return staff;
	}


	public List<Staff> expirance() {

		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Staff.class);
		criteria.add(Restrictions.between("experience", 10, 20));
		List<Staff>staff=criteria.list();
		session.close();
		return staff;
	}


	public List<Staff> maxSalary() {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Staff.class);
		criteria.addOrder(Order.desc("salary"));
		criteria.setMaxResults(1);
		List<Staff> al= criteria.list();

		String str=null;


		session.close();
		return al;
	}



	public boolean updateSalary(int salary) {
		Session session=sf.openSession();
		Transaction transaction=session.beginTransaction();
		session.save(salary);

		transaction.commit();
		session.close();
		return true;
	}


	public String getminExpirance() {

		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Staff.class);
		criteria.addOrder(Order.asc("experience"));
		criteria.setMaxResults(1);
		List<Staff> al= criteria.list();

		String str=null;
		for (Staff staff : al) {
			str=staff.getName();
		}


		return str;
	}


	public List<Staff> trainner() {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Staff.class);
		criteria.add(Restrictions.eq("profile", "trainer"));
		List<Staff> staff =criteria.list();

		session.close();
		return staff;
	}


	public List<Staff> notTrainner() {
		Session session=sf.openSession();
		Criteria criteria=session.createCriteria(Staff.class);
		criteria.add(Restrictions.ne("profile", "trainer"));
		List<Staff> staff =criteria.list();

		session.close();
		return staff;


	}

}


package com.ts.dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ts.dto.Patient;
import com.ts.db.HibernateTemplate;

public class PatientDao {
	private static SessionFactory sessionFactory;
	static {
		sessionFactory=new Configuration().configure().buildSessionFactory();
	}
	public int register(Patient patient) {
		System.out.println(patient); 
		return HibernateTemplate.addObject(patient);
	}
public static Object getPatientByUserPass(String userName,String password) {
		System.out.println("Inside Patient loginId:"+userName+"Passord"+password);
		String queryString = "from Patient where userName = :userName and password =:password";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setString("userName", userName);
		  query.setString("password", password);
		  Object queryResult = query.uniqueResult();
		  Patient patient = (Patient)queryResult;
		  return patient; 
		}
}
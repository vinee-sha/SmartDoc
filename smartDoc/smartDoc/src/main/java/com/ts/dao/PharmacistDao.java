package com.ts.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ts.db.HibernateTemplate;
import com.ts.dto.Patient;
import com.ts.dto.Pharmacist;

public class PharmacistDao {
private static SessionFactory sessionFactory;
	
	static {
		sessionFactory=new Configuration().configure().buildSessionFactory();
	}
	public int register(Pharmacist pharmacist) {
		System.out.println(pharmacist); 
		return HibernateTemplate.addObject(pharmacist);
	}
public static Object getPharmacistByUserPass(String loginId,String password) {
		
		String queryString = "from Pharmacist where userName = :loginId and password =:password";
		  Query query = sessionFactory.openSession().createQuery(queryString);
		  query.setString("loginId", loginId);
		  query.setString("password", password);
		  Object queryResult = query.uniqueResult();
		  Pharmacist pharmacist = (Pharmacist)queryResult;
		  return pharmacist; 
		}
}

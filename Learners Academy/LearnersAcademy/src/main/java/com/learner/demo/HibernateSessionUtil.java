package com.learner.demo;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
public class HibernateSessionUtil {
	private static SessionFactory sessionFactory;
		static {
		try {
			 StandardServiceRegistry registry= new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			 Metadata metadata=new MetadataSources(registry).getMetadataBuilder().build();
			 sessionFactory=metadata.getSessionFactoryBuilder().build();
			} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}

}

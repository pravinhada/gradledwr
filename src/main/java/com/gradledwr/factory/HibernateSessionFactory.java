package com.gradledwr.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateSessionFactory {
	private static final SessionFactory sessionFactory;

	static {
		try {
			// try AnnotationConfiguration for the Annotation Driven Entity
			sessionFactory = new AnnotationConfiguration().configure()
					.buildSessionFactory();
		} catch (Throwable ex) {
			System.err
					.println("Initial SessionFActory creation failded. " + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getCurrentSessionFactory() {
		return sessionFactory;
	}

}

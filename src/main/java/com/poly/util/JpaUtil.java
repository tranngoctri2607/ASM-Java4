package com.poly.util;

import javax.persistence.*;

public class JpaUtil {
	private static EntityManagerFactory factory;

	public static EntityManager getEntityManager() {
		if (factory == null || factory.isOpen()) {
			factory = Persistence.createEntityManagerFactory("ASMJava4");
		}
		return factory.createEntityManager();
	}
	
	public static void shutDown() {
	    if (factory != null && factory.isOpen()) {
	        factory.close();
	    }
	    factory = null;
	}
}

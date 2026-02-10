package com.jspider.hibernatetask;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Counttotalproductsanddisplay {
	public static void main(String[] args) {

        // 1️⃣ Create EntityManagerFactory
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("dev");

        // 2️⃣ Create EntityManager
        EntityManager manager = factory.createEntityManager();

        // 3️⃣ Create HQL COUNT query
        Query q = manager.createQuery(
                "select count(p) from Product p");

        // 4️⃣ Execute query
        Long count = (Long) q.getSingleResult();

        // 5️⃣ Display result
        System.out.println("✅ Total number of products = " + count);

        // 6️⃣ Close resources
        manager.close();
        factory.close();
    }
}


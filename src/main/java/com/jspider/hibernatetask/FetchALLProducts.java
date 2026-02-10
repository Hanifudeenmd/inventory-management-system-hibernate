package com.jspider.hibernatetask;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchALLProducts {
	
    public static void main(String[] args) {

        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("dev");
        EntityManager manager = factory.createEntityManager();

        // ✅ HQL query
        Query q = manager.createQuery("from Product");

        List<Product> list = q.getResultList();

        if (list.isEmpty()) {
            System.out.println("❌ No products found");
        } else {
            System.out.println("✅ Product List:");
            for (Product p : list) {
                System.out.println(
                        p.getProductid() + " | " +
                        p.getName() + " | " +
                        p.getCategory() + " | " +
                        p.getQuantity() + " | " +
                        p.getStatus()
                );
            }
        }

        manager.close();
        factory.close();
    }
}
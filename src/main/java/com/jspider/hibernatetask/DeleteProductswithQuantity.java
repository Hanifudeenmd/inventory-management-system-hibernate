package com.jspider.hibernatetask;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DeleteProductswithQuantity {
	 public static void main(String[] args) {

	        // 1️⃣ Create EntityManagerFactory
	        EntityManagerFactory factory =
	                Persistence.createEntityManagerFactory("dev");

	        // 2️⃣ Create EntityManager
	        EntityManager manager = factory.createEntityManager();
	        EntityTransaction transaction = manager.getTransaction();

	        // 3️⃣ Begin transaction (DELETE needs transaction)
	        transaction.begin();

	        // 4️⃣ Create HQL DELETE query
	        Query q = manager.createQuery(
	                "delete from Product p where p.quantity = 0");

	        // 5️⃣ Execute delete
	        int rows = q.executeUpdate();

	        // 6️⃣ Commit transaction
	        transaction.commit();

	        // 7️⃣ Result message
	        if (rows > 0) {
	            System.out.println("✅ " + rows + " product(s) with zero quantity deleted");
	        } else {
	            System.out.println("❌ No products found with zero quantity");
	        }

	        // 8️⃣ Close resources
	        manager.close();
	        factory.close();
	    }
	}


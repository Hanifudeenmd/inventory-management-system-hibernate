package com.jspider.hibernatetask;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdateProductStatuswhenQuantity {
    public static void main(String[] args) {

        // 1️⃣ Create EntityManagerFactory
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("dev");

        // 2️⃣ Create EntityManager
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        // 3️⃣ Begin transaction (UPDATE needs transaction)
        transaction.begin();

        // 4️⃣ Create HQL UPDATE query
        Query q = manager.createQuery(
                "update Product p set p.status = 'OUT_OF_STOCK' where p.quantity = 0");

        // 5️⃣ Execute update
        int rows = q.executeUpdate();

        // 6️⃣ Commit transaction
        transaction.commit();

        // 7️⃣ Display result
        if (rows > 0) {
            System.out.println("✅ Status updated to OUT_OF_STOCK for " + rows + " product(s)");
        } else {
            System.out.println("❌ No products found with quantity = 0");
        }

        // 8️⃣ Close resources
        manager.close();
        factory.close();
    }
}


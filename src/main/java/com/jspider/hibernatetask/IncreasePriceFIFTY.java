package com.jspider.hibernatetask;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class IncreasePriceFIFTY {
public static void main(String[] args) {

 

        // 1️⃣ Create EntityManagerFactory
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("dev");

        // 2️⃣ Create EntityManager
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        // 3️⃣ Take input from user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Category to increase price: ");
        String category = sc.nextLine();

        // 4️⃣ Begin transaction (UPDATE needs transaction)
        transaction.begin();

        // 5️⃣ Create HQL UPDATE query (DYNAMIC)
        Query q = manager.createQuery(
                "update Product p set p.price = p.price + 50 where p.category = :cat");

        // 6️⃣ Set parameter value
        q.setParameter("cat", category);

        // 7️⃣ Execute update
        int rows = q.executeUpdate();

        // 8️⃣ Commit transaction
        transaction.commit();

        // 9️⃣ Result message
        if (rows > 0) {
            System.out.println("✅ Price increased by 50 for " + rows +
                               " product(s) in category: " + category);
        } else {
            System.out.println("❌ No products found for category: " + category);
        }

        // 🔟 Close resources
        sc.close();
        manager.close();
        factory.close();
    }

}


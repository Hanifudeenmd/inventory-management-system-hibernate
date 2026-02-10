package com.jspider.hibernatetask;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchAllProducts1 {

    public static void main(String[] args) {

        // 1️⃣ Create EntityManagerFactory
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("dev");

        // 2️⃣ Create EntityManager
        EntityManager manager = factory.createEntityManager();

        // 3️⃣ Create HQL query
        Query q = manager.createQuery("from Product");

        // 4️⃣ Execute query and store result
        List<Product> list = q.getResultList();

        // 5️⃣ Display result
        if (list.isEmpty()) {
            System.out.println("No products found ❌");
        } else {
            System.out.println("Product Details:");
            System.out.println("-------------------------");

            for (Product p : list) {
                System.out.println("Product ID   : " + p.getProductid());
                System.out.println("Name         : " + p.getName());
                System.out.println("Category     : " + p.getCategory());
                System.out.println("Quantity     : " + p.getQuantity());
                System.out.println("Status       : " + p.getStatus());
                System.out.println("-------------------------");
            }
        }

        // 6️⃣ Close resources
        manager.close();
        factory.close();
    }
}

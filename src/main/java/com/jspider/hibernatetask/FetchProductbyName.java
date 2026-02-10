package com.jspider.hibernatetask;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FetchProductbyName {
	public static void main(String[] args) {

        // 1️⃣ Create EntityManagerFactory
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("dev");

        // 2️⃣ Create EntityManager
        EntityManager manager = factory.createEntityManager();

        // 3️⃣ Take product name from user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Product Name to search: ");
        String name = sc.nextLine();

        // 4️⃣ Create HQL query (DYNAMIC)
        Query q = manager.createQuery(
                "from Product p where p.name = :pname");

        // 5️⃣ Set parameter value
        q.setParameter("pname", name);

        // 6️⃣ Execute query
        List<Product> list = q.getResultList();

        // 7️⃣ Display result
        if (list.isEmpty()) {
            System.out.println("❌ Product not found with name: " + name);
        } else {
            System.out.println("✅ Product(s) found:");
            System.out.println("---------------------------------");

            for (Product p : list) {
                System.out.println("Product ID   : " + p.getProductid());
                System.out.println("Name         : " + p.getName());
                System.out.println("Category     : " + p.getCategory());
                System.out.println("Quantity     : " + p.getQuantity());
                System.out.println("Status       : " + p.getStatus());
                System.out.println("---------------------------------");
            }
        }

        // 8️⃣ Close resources
        sc.close();
        manager.close();
        factory.close();
    }
}


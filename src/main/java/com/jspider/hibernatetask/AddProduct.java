package com.jspider.hibernatetask;

import java.util.Scanner;
import javax.persistence.*;

public class AddProduct {

    public static void main(String[] args) {

        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("dev");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        Scanner sc = new Scanner(System.in);

        transaction.begin();

        for (int i = 1; i <= 1; i++) {

            System.out.println("\n--- Enter Product " + i + " Details ---");

            Product p = new Product();

            System.out.print("Enter Product ID: ");
            p.setProductid(sc.nextInt());
            sc.nextLine();

            System.out.print("Enter Product Name: ");
            p.setName(sc.nextLine());

            System.out.print("Enter Category: ");
            p.setCategory(sc.nextLine());

            System.out.print("Enter Price: ");
            p.setPrice(sc.nextDouble());

            System.out.print("Enter Quantity: ");
            int qty = sc.nextInt();
            p.setQuantity(qty);

            p.setStatus(qty == 0 ? "OUT_OF_STOCK" : "AVAILABLE");

            manager.persist(p);
        }

        transaction.commit();

        System.out.println("✅ Product inserted successfully");

        sc.close();
        manager.close();
        factory.close();
    }
}

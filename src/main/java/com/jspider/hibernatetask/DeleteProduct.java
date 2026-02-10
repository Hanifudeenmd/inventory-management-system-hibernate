package com.jspider.hibernatetask;

import java.util.Scanner;
import javax.persistence.*;

public class DeleteProduct {
    public static void main(String[] args) {

        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("dev");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Product Id to Delete: ");
        int id = sc.nextInt();

        // ✅ CORRECT: find result assigned
        Product p = manager.find(Product.class, id);

        if (p != null) {
            transaction.begin();
            manager.remove(p);   // ✅ remove()
            transaction.commit();

            System.out.println("✅ The product is deleted");
        } else {
            System.out.println("❌ The product is not found");
        }

        sc.close();
        manager.close();
        factory.close();
    }
}

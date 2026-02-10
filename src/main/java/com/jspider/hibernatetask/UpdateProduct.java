package com.jspider.hibernatetask;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UpdateProduct {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Product Id to Update");
		int id = sc.nextInt();
		sc.nextLine();
		// 🔍 find product first
		Product p = manager.find(Product.class, id);
		if (p != null) {
			System.out.println("Enter new Category:");
//			String category = sc.nextLine();
//			System.out.print("Enter New Quantity: ");
//			int quantity = sc.nextInt();
			transaction.begin();

//			p.setCategory(category);
//			p.setQuantity(quantity);
			// status logic
//			if (quantity == 0) {
//				p.setStatus("OUT_OF_STOCK");
//			} else {
//				p.setStatus("AVAILABLE");
//			}
			// ✅ merge()
			manager.merge(p);

			transaction.commit();

			System.out.println("\n✅ Category updated successfully");

		} else {
			System.out.println("\n❌ Product not found!");
		}

		sc.close();
		manager.close();
		factory.close();
	}
}

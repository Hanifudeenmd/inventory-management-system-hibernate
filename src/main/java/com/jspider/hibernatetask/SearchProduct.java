package com.jspider.hibernatetask;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class SearchProduct {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("dev");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Scanner sc = new Scanner(System.in);
		transaction.begin();
		System.out.print("Enter Product  Id To Search: ");
		int id = sc.nextInt();
		// findmethod
		Product p = manager.find(Product.class, id);
		if (p != null) {
			System.out.println("Product Id:" + p.getProductid());
			System.out.println("Product Name:" + p.getName());
			System.out.println("Category Name:" + p.getCategory());
			System.out.println("Quantity " + p.getQuantity());
		} else {
			System.out.println("\n❌product not found");
		}
		sc.close();
        manager.close();
        factory.close();
	}
}

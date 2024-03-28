package org.jsp.OneToManyBi;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Find_Products_By_Merchant_Phone_And_Password {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Merchant phone: ");
        long phone = sc.nextLong(); 

        System.out.print("Enter Merchant password: ");
        String password = sc.next();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("select p from Product p where p.merchant.phone = ?1 and p.merchant.password = ?2");
//        Query query = manager.createQuery("select m from Merchant m where m.phone = ?1 and m.password = ?2");
        query.setParameter(1, phone);
        query.setParameter(2, password);

        List<Product> products = query.getResultList();

        if (products.isEmpty()) {
            System.err.println("No products found for the given merchant phone and password.");
        } 
        else {
            System.out.println("Products for the given merchant phone and password:");
            for (Product product : products) {
                System.out.println(product);
            }
        }
        sc.close();
	}
}

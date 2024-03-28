package org.jsp.OneToManyBi;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Find_Products_By_Merchant_Id_And_Password {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Merchant Id: ");
        int id = sc.nextInt();

        System.out.print("Enter Merchant Password: ");
        String password = sc.next();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("select p from Product p where p.merchant.id = ?1 and p.merchant.password = ?2");
        query.setParameter("merchantId", id);
        query.setParameter("password", password);

        List<Product> products = query.getResultList();

        if (products.isEmpty()) {
            System.err.println("No products found for the given merchant id and password.");
        } else {
            System.out.println("Products for the given merchant id and password:");
            for (Product product : products) {
                System.out.println(product);
            }
        }
        sc.close();
    }
}

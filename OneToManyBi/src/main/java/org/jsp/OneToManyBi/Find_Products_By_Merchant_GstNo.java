package org.jsp.OneToManyBi;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Find_Products_By_Merchant_GstNo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter Merchant GstNo: ");
        String gst = sc.next();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("select p from Product p where p.merchant.gst_no = ?1");
        query.setParameter(1, gst);

        List<Product> products = query.getResultList();

        if (products.isEmpty()) {
            System.err.println("No products found for the given merchant gstNo");
        } else {
            System.out.println("Products for the given merchant gstNo:");
            for (Product product : products) {
                System.out.println(product);
            }
        }
        sc.close();
	}
}

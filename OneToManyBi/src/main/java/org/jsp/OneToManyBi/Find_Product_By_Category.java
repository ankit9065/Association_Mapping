package org.jsp.OneToManyBi;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Find_Product_By_Category {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Product Category: ");
        String category = sc.next();
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
        EntityManager manager = factory.createEntityManager();

        Query query = manager.createQuery("select p from Product p where p.category = ?1");
        query.setParameter(1, category);

        List<Product> products = query.getResultList();
        
        if (products.isEmpty()) {
            System.err.println("No products found for category");
        } 
        else {
            System.out.println("Products in category " + category + ":");
            for (Product product : products) {
                System.out.println(product);
            }
        }
        sc.close();
    }
}

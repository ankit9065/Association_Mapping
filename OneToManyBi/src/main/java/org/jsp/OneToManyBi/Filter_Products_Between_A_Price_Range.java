package org.jsp.OneToManyBi;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Filter_Products_Between_A_Price_Range {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the min price of the product: ");
        double minprice = sc.nextDouble();
        System.out.print("Enter the max price of the product: ");
        double maxprice = sc.nextDouble();
        
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
        EntityManager manager = factory.createEntityManager();
        Query q = manager.createQuery("select p from Product p where p.cost between ?1 and ?2");
        
        q.setParameter(1, minprice);
        q.setParameter(2, maxprice);
        try {
            List<Product> products = q.getResultList();
            if (products.size() > 0)
            	System.out.println("Products between " + minprice + " to " + maxprice); 
                for (Product p : products) 
            		System.out.println(p);
        } 
        catch (NoResultException e) {
            System.err.println("No products found within the specified price range");
        }
            sc.close(); 
    }
}


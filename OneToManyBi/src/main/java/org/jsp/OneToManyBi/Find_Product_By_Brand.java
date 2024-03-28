package org.jsp.OneToManyBi;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Find_Product_By_Brand {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter brand : ");
        String brand = sc.next();
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
            EntityManager manager = factory.createEntityManager();

            Query query = manager.createQuery("select p from Product p where p.brand = ?1");
            query.setParameter(1, brand);

            Product product = (Product) query.getSingleResult();
            System.out.println(product);
        } 
        catch (NoResultException e) {
            System.err.println("Invalid brand");
        }
        sc.close();
	}
}

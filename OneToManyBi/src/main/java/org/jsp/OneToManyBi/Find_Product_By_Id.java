package org.jsp.OneToManyBi;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Find_Product_By_Id {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter Product ID: ");
        int pId = sc.nextInt();
        try {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
            EntityManager manager = factory.createEntityManager();

            Query query = manager.createQuery("select p from Product p where p.id = ?1");
            query.setParameter(1, pId);

            Product product = (Product) query.getSingleResult();
            System.out.println(product);
        } 
        catch (NoResultException e) {
            System.err.println("Invalid product id");
        }
        sc.close();
	}
}

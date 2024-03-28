package org.jsp.OneToManyBi;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Verify_Merchant_By_Phone_And_Password {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter Merchant phone: ");
        long phone = sc.nextLong(); 

        System.out.print("Enter Merchant password: ");
        String password = sc.next();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
        EntityManager manager = factory.createEntityManager();

        Query q = manager.createQuery("select m from Merchant m where m.phone = ?1 and m.password = ?2");
        q.setParameter(1, phone);
        q.setParameter(2, password); 

        try {
            Merchant merchant = (Merchant) q.getSingleResult();
            System.out.println("Verify: " + merchant);
        } 
        catch (NoResultException e) {
            System.err.println("Invalid phone and password");
        }
            sc.close(); 
	}
}

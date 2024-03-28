package org.jsp.OneToManyBi;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;


public class Find_Merchant_By_Id {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Merchant id: ");
		int id = sc.nextInt();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();

		Query q = manager.createQuery("select m from Merchant m where m.id=?1");
		q.setParameter(1, id);

		try {
			Merchant merchant = (Merchant)q.getSingleResult();
			System.out.println(merchant);
		}
		catch(NoResultException e) {
			System.err.println("Invalid id!");
		}
	}
}

package org.jsp.OneToManyBi;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Find_Merchant_By_Name {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Merchant name: ");
        String name = sc.nextLine();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
        EntityManager manager = factory.createEntityManager();

        Query q = manager.createQuery("select m from Merchant m where m.name =?1");
        q.setParameter(1, name);

        try {
            Merchant merchant = (Merchant) q.getSingleResult();
            System.out.println(merchant);
        } 
        catch (NoResultException e) {
            System.err.println("Invalid name: " + name);
        }
            sc.close();
    }
}


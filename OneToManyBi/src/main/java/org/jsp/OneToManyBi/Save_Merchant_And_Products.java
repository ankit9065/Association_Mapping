package org.jsp.OneToManyBi;

import java.util.Arrays;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Save_Merchant_And_Products {
	public static void main(String[] args) {
		Merchant m = new Merchant();
		m.setGst_no("PQR987");
		m.setName("Suraj");
		m.setPhone(123456789);
		m.setPassword("bholu");
		
		Product p1 = new Product();
		p1.setBrand("Sony");
		p1.setName("T.V");
		p1.setCategory("Electronics");
		p1.setDescription("52 inch");
		p1.setCost(52000);
		p1.setMerchant(m);
		
		Product p2 = new Product();
		p2.setBrand("BlueStar");
		p2.setName("A.C");
		p2.setCategory("Home Accessories");
		p2.setDescription("Thanda-Thanda cool-cool");
		p2.setCost(35000);
		p2.setMerchant(m);
		
		m.setProducts(Arrays.asList(p1,p2));
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("development");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction t = manager.getTransaction();
		manager.persist(m);
		t.begin();
		t.commit();
	}
}

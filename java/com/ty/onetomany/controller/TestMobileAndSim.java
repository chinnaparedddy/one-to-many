package com.ty.onetomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetomany.dto.Mobile;
import com.ty.onetomany.dto.Sim;

public class TestMobileAndSim {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("naresh");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		Mobile  mobile=new Mobile();
		mobile.setName("vivo");
		mobile.setCost(20000);
		
		Sim sim1=new Sim();
		sim1.setProvider("Jio");
		sim1.setType("4G");
		
		Sim sim2=new Sim();
		sim2.setProvider("Airtel");
		sim2.setType("4G");
		
		List<Sim> sims=new ArrayList();
		sims.add(sim1);
		sims.add(sim2);
		
		mobile.setSims(sims);
		
		entityTransaction.begin();
		entityManager.persist(mobile);
		entityManager.persist(sim1);
		entityManager.persist(sim2);
		entityTransaction.commit();
		
		System.out.println("Inserted........!");
		
	}
}

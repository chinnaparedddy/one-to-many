package com.ty.onetomany.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetomany.dto.Mobile;
import com.ty.onetomany.dto.Sim;

public class GetBMobileById {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("naresh");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Mobile mobile = entityManager.find(Mobile.class, 6);
		if (mobile != null) {

			List<Sim> sims = mobile.getSims();

			System.out.println("-------------------------------");
			System.out.println("Mobile name is : " + mobile.getName());
			System.out.println("Mobile cost is : " + mobile.getCost());
			System.out.println("-------------------------------");

			for (Sim sim : sims) {

				System.out.println("Sim id : " + sim.getId());
				System.out.println("Sim Provider : " + sim.getProvider());
				System.out.println("Sim Type : " + sim.getType());
				System.out.println("****************************");
			}
		} else
			System.out.println("No Mobiule Sim details ...........!");

	}

}

package com.ty.onetomany.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetomany.dto.UserAccount;
import com.ty.onetomany.dto.Mobile;
import com.ty.onetomany.dto.Page;
import com.ty.onetomany.dto.Sim;
import com.ty.onetomany.dto.UserAccount;

public class TestAccountPageDelete {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("naresh");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		UserAccount account = entityManager.find(UserAccount.class, 1);
		
		List<Page> pages=account.getPage();
		
		entityTransaction.begin();
		for (Page page:pages) {
			
			entityManager.remove(page);
		}
		entityManager.remove(account);
		entityTransaction.commit();
		System.out.println("Account Records deleted...........!");
	}

}

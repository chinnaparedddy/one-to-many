package com.ty.onetomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetomany.dto.UserAccount;
import com.ty.onetomany.dto.Mobile;
import com.ty.onetomany.dto.Page;
import com.ty.onetomany.dto.UserAccount;

public class TestAccountPageSave {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("naresh");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		UserAccount account=new UserAccount();
		account.setEmail("nari@gmail.com");
		account.setPasword("naresh7845");
		account.setMobole(97845612);
		account.setName("Naresh");
		
	   Page page=new Page();
	   page.setName("firstPage");
	   page.setTittle("Java");
	   page.setDescriptin("you can learn the java Subject");
	   
	   Page page1=new Page();
	   page1.setName("secondPage");
	   page1.setTittle("J2EE");
	   page1.setDescriptin("you can learn the java Advance Subject");
	   
	   Page page2=new Page();
	   page2.setName("thirdPage");
	   page2.setTittle("J2EE");
	   page2.setDescriptin("you can learn the hibernet Subject");
	   List<Page> pages = new ArrayList<Page>();
	   pages.add(page);
	   pages.add(page1);
	   pages.add(page2);
	   account.setPage(pages);
	   entityTransaction.begin();
	   entityManager.persist(account);
	   entityManager.persist(page);
	   entityManager.persist(page1);
	   entityTransaction.commit();
	}

}

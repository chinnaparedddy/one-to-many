package com.ty.onetomany.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetomany.dto.BankAccount;
import com.ty.onetomany.dto.Person;


public class TestSavePersonBankAccount {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("naresh");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person person=new Person();
		person.setName("NareshReddy");
		person.setMail("naresh@gmail.com");
		person.setPhone(9989452181l);
		
		BankAccount bankAccount=new BankAccount();
		bankAccount.setBankname("STATE BANK");
		bankAccount.setIsfcCode("sbin00123");
		bankAccount.setAccountNumber(4521874124124l);
		
		BankAccount bankAccounrt1=new BankAccount();
		bankAccounrt1.setBankname("Bank Of Baroda");
		bankAccounrt1.setIsfcCode("BOB00123");
		bankAccounrt1.setAccountNumber(452187124124l);
		
		BankAccount bankAccount2=new BankAccount();
		bankAccount2.setBankname("AXIS Bank");
		bankAccount2.setIsfcCode("AXIS00123");
		bankAccount2.setAccountNumber(521874124124l);
		
		List<BankAccount> list=new ArrayList();
		list.add(bankAccount);
		list.add(bankAccounrt1);
		list.add(bankAccount2);
		person.setBankAccounts(list);
		entityTransaction.begin();
		entityManager.persist(bankAccount);
		entityManager.persist(bankAccounrt1);
		entityManager.persist(bankAccount2);
		entityManager.persist(person);
		entityTransaction.commit();
		
	}

}

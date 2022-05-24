package com.ty.onetomany.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.onetomany.dto.BankAccount;
import com.ty.onetomany.dto.Person;


public class TestDeletePersonAndBankAccount {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("naresh");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
        Person person=entityManager.find(Person.class, 1);
        List<BankAccount> bankAccounts=person.getBankAccounts();
        
        	entityTransaction.begin();
        	entityManager.remove(bankAccounts);
        	entityManager.remove(person);
        	entityTransaction.commit();
        
        System.out.println("Deleted");
	}

}

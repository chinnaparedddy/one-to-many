package com.ty.onetomany.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.ty.onetomany.dto.BankAccount;
import com.ty.onetomany.dto.Person;

public class TestGetAllPersonAndBankAccounts {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("naresh");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Person persons=entityManager.find(Person.class, 2);
		System.out.println("Person Id :"+persons.getId());
		System.out.println("person Name:"+persons.getName());
		System.out.println("Person email :"+persons.getMail());
		System.out.println("Person phone :"+persons.getPhone());
		System.out.println("*********************************");
				
		List<BankAccount> bankAccounts=persons.getBankAccounts();
		for(BankAccount bankAccount:bankAccounts) {
			System.out.println("Bank Account id: "+bankAccount.getId());
			System.out.println("Bank Account Number : "+bankAccount.getAccountNumber());
			System.out.println("Bank Name id: "+bankAccount.getBankname());
			System.out.println("Bank Isf Code is: "+bankAccount.getIsfcCode());
			System.out.println("===================================");
		}
	}

}

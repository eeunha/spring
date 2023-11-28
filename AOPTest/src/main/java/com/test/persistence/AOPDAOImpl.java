package com.test.persistence;

import org.springframework.stereotype.Repository;

@Repository
public class AOPDAOImpl implements AOPDAO {
	@Override
	public void list() {
		System.out.println("DAO.list()");
	}

	@Override
	public void add() {
		System.out.println("DAO.add()");

	}
	
	@Override
	public void view() {
		System.out.println("DAO.add()");
		
	}
}

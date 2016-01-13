package com.lds.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import util.JPAUtil;

import com.lds.entidades.Hino;

public class HinoDAO {
	
	@SuppressWarnings("unchecked")
	public List<Hino> findAll() {
		EntityManager manager = JPAUtil.getEntityManager();
		Query query = manager.createQuery("select h from Hino h");
		return query.getResultList();
	}

	public void salvar(Hino hino) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction(); 
		tx.begin();
		manager.persist(hino);
		tx.commit();
		manager.close();
	}

}

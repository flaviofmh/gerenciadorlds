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
	
	public void remover(Long id) {
		EntityManager manager = JPAUtil.getEntityManager();
		EntityTransaction tx = manager.getTransaction();
		Hino hino = manager.getReference(Hino.class, id);
		tx.begin(); 
		manager.remove(hino); 
		tx.commit();
	}
	
	public Hino carregarHino(Long id) {
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		Hino hinoCarregado = manager.find(Hino.class, id);
		manager.close();
		return hinoCarregado;
	}
	
	public void atualizarHino(Hino hino) {
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		manager.merge(hino);
		manager.getTransaction().commit();

	}

}

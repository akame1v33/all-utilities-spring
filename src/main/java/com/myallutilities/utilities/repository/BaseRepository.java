package com.myallutilities.utilities.repository;

import com.myallutilities.utilities.utilities.ReflectionUtils;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
public abstract class BaseRepository<T, ID> implements CRUDRepository<T, ID> {
	
	@PersistenceContext
	protected EntityManager em;
	
	protected Session session() {
		return em.unwrap(Session.class);
	}


	@Override
	public void saveOrUpdate(T entity) {
		session().saveOrUpdate(entity);
	}

	private String getModelName(){
		return  ReflectionUtils.getFirstGenerics(getClass()).getSimpleName();
	}

	@Override
	public T findById(ID id) {
		return (T) em.createQuery("SELECT model FROM "+getModelName()+" model").getSingleResult();
	}

	@Override
	public List<T> findAll() {
		return em.createQuery("SELECT model FROM "+getModelName()+" model").getResultList();
	}

}

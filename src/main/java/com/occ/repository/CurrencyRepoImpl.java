package com.occ.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.occ.model.Currency;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class CurrencyRepoImpl implements  CurrencyRepository{

	@Autowired
	private EntityManager entitymanager;
	
	@Override
	public Currency save(Currency currency) {
		entitymanager.persist(currency);
		return currency;
	}

	@Override
	public Currency findByCode(String code) {
		Query query = entitymanager.createQuery("from Currency WHERE code =?1");
		query.setParameter(1, code);
		return (Currency) query.getSingleResult();
	}

	@Override
	public List<Currency> findAll() {
		Query query = entitymanager.createQuery("from Currency");
		return query.getResultList();
	}

}

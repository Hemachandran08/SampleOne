package com.occ.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.occ.model.Currency;

public interface CurrencyRepository {

	public Currency save(Currency currency);

	public Currency findByCode(String code);

	public List<Currency> findAll();

}

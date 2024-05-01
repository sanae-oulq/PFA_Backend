package com.postgresql.ytdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postgresql.ytdemo.dao.IDao;
import com.postgresql.ytdemo.entities.ProprieteRurale;
import com.postgresql.ytdemo.repositories.ProprieteRuraleRepository;

@Service
public class ProprieteRuraleService implements IDao<ProprieteRurale>{
	
	@Autowired
	private ProprieteRuraleRepository repository;

	@Override
	public ProprieteRurale create(ProprieteRurale o) {
		return repository.save(o);
	}

	@Override
	public boolean delete(ProprieteRurale o) {
		try {
			repository.delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public ProprieteRurale update(ProprieteRurale o) {
		return repository.save(o);
	}

	@Override
	public ProprieteRurale findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<ProprieteRurale> findAll() {
		return repository.findAll();
	}

}

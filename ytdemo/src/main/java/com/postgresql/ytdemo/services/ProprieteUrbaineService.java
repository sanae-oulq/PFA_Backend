package com.postgresql.ytdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postgresql.ytdemo.dao.IDao;
import com.postgresql.ytdemo.entities.ProprieteUrbaine;
import com.postgresql.ytdemo.repositories.ProprieteUrbaineRepository;

@Service
public class ProprieteUrbaineService implements IDao<ProprieteUrbaine>{
	
	@Autowired
	private ProprieteUrbaineRepository repository;

	@Override
	public ProprieteUrbaine create(ProprieteUrbaine o) {
		return repository.save(o);
	}

	@Override
	public boolean delete(ProprieteUrbaine o) {
		try {
			repository.delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public ProprieteUrbaine update(ProprieteUrbaine o) {
		return repository.save(o);
	}

	@Override
	public ProprieteUrbaine findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<ProprieteUrbaine> findAll() {
		return repository.findAll();
	}

}

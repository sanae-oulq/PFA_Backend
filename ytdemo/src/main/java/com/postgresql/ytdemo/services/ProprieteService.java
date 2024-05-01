package com.postgresql.ytdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postgresql.ytdemo.dao.IDao;
import com.postgresql.ytdemo.entities.Propriete;
import com.postgresql.ytdemo.repositories.ProprieteRepository;

@Service
public class ProprieteService implements IDao<Propriete>{
	
	@Autowired
	private ProprieteRepository repository;

	@Override
	public Propriete create(Propriete o) {
		return repository.save(o);
	}

	@Override
	public boolean delete(Propriete o) {
		try {
			repository.delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Propriete update(Propriete o) {
		return repository.save(o);
	}

	@Override
	public Propriete findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Propriete> findAll() {
		return repository.findAll();
	}

}

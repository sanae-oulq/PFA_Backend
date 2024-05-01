package com.postgresql.ytdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postgresql.ytdemo.dao.IDao;
import com.postgresql.ytdemo.entities.Historique;
import com.postgresql.ytdemo.repositories.HistoriqueRepository;

@Service
public class HistoriqueService implements IDao<Historique>{
	
	@Autowired
	private HistoriqueRepository repository;

	@Override
	public Historique create(Historique o) {
		return repository.save(o);
	}

	@Override
	public boolean delete(Historique o) {
		try {
			repository.delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Historique update(Historique o) {
		return repository.save(o);
	}

	@Override
	public Historique findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Historique> findAll() {
		return repository.findAll();
	}

}

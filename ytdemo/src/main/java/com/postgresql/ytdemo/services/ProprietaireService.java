package com.postgresql.ytdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postgresql.ytdemo.dao.IDao;
import com.postgresql.ytdemo.entities.Proprietaire;
import com.postgresql.ytdemo.repositories.ProprietaireRepository;

@Service
public class ProprietaireService implements IDao<Proprietaire>{
	
	@Autowired
	private ProprietaireRepository repository;

	@Override
	public Proprietaire create(Proprietaire o) {
		return repository.save(o);
	}

	@Override
	public boolean delete(Proprietaire o) {
		try {
			repository.delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Proprietaire update(Proprietaire o) {
		return repository.save(o);
	}

	@Override
	public Proprietaire findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Proprietaire> findAll() {
		return repository.findAll();
	}

}

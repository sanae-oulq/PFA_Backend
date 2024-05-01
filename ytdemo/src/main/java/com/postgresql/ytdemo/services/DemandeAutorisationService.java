package com.postgresql.ytdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postgresql.ytdemo.dao.IDao;
import com.postgresql.ytdemo.entities.DemandeAutorisation;
import com.postgresql.ytdemo.entities.DemandeAutorisation;
import com.postgresql.ytdemo.repositories.DemandeAutorisationRepository;
import com.postgresql.ytdemo.repositories.DemandeAutorisationRepository;

@Service
public class DemandeAutorisationService implements IDao<DemandeAutorisation>{

	@Autowired
	private DemandeAutorisationRepository repository;

	@Override
	public DemandeAutorisation create(DemandeAutorisation o) {
		return repository.save(o);
	}

	@Override
	public boolean delete(DemandeAutorisation o) {
		try {
			repository.delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public DemandeAutorisation update(DemandeAutorisation o) {
		return repository.save(o);
	}

	@Override
	public DemandeAutorisation findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<DemandeAutorisation> findAll() {
		return repository.findAll();
	}
	
}
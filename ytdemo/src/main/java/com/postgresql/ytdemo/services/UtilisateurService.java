package com.postgresql.ytdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postgresql.ytdemo.dao.IDao;
import com.postgresql.ytdemo.entities.Utilisateur;
import com.postgresql.ytdemo.repositories.UtilisateurRepository;

@Service
public class UtilisateurService implements IDao<Utilisateur>{
	
	@Autowired
	private UtilisateurRepository repository;

	@Override
	public Utilisateur create(Utilisateur o) {
		return repository.save(o);
	}

	@Override
	public boolean delete(Utilisateur o) {
		try {
			repository.delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Utilisateur update(Utilisateur o) {
		return repository.save(o);
	}

	@Override
	public Utilisateur findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Utilisateur> findAll() {
		return repository.findAll();
	}

}

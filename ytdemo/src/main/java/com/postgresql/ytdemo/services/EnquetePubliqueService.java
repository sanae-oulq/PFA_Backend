package com.postgresql.ytdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postgresql.ytdemo.dao.IDao;
import com.postgresql.ytdemo.entities.EnquetePublique;
import com.postgresql.ytdemo.entities.EnquetePublique;
import com.postgresql.ytdemo.repositories.EnquetePubliqueRepository;

@Service
public class EnquetePubliqueService implements IDao<EnquetePublique>{
	
	@Autowired
	private EnquetePubliqueRepository repository;

	@Override
	public EnquetePublique create(EnquetePublique o) {
		return repository.save(o);
	}

	@Override
	public boolean delete(EnquetePublique o) {
		try {
			repository.delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public EnquetePublique update(EnquetePublique o) {
		return repository.save(o);
	}

	@Override
	public EnquetePublique findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<EnquetePublique> findAll() {
		return repository.findAll();
	}

}

package com.postgresql.ytdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.postgresql.ytdemo.dao.IDao;
import com.postgresql.ytdemo.entities.Document;
import com.postgresql.ytdemo.repositories.DocumentRepository;

@Service
public class DocumentService implements IDao<Document> {

	@Autowired
	private DocumentRepository repository;

	@Override
	public Document create(Document o) {
		return repository.save(o);
	}

	@Override
	public boolean delete(Document o) {
		try {
			repository.delete(o);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Document update(Document o) {
		return repository.save(o);
	}

	@Override
	public Document findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public List<Document> findAll() {
		return repository.findAll();
	}

}

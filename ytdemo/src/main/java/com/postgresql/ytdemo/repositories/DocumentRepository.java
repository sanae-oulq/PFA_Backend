package com.postgresql.ytdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postgresql.ytdemo.entities.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long>{

}

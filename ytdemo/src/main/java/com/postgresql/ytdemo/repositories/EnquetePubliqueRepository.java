package com.postgresql.ytdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postgresql.ytdemo.entities.EnquetePublique;

@Repository
public interface EnquetePubliqueRepository extends JpaRepository<EnquetePublique, Long>{

}

package com.postgresql.ytdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postgresql.ytdemo.entities.Propriete;

@Repository
public interface ProprieteRepository extends JpaRepository<Propriete, Long>{

}

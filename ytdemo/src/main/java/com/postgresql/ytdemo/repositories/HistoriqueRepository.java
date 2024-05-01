package com.postgresql.ytdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postgresql.ytdemo.entities.Historique;

@Repository
public interface HistoriqueRepository extends JpaRepository<Historique, Long>{

}

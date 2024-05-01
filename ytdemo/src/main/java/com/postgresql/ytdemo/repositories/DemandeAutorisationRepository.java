package com.postgresql.ytdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postgresql.ytdemo.entities.DemandeAutorisation;


@Repository
public interface DemandeAutorisationRepository extends JpaRepository<DemandeAutorisation, Long>{

}

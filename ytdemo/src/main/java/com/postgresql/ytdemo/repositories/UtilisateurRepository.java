package com.postgresql.ytdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postgresql.ytdemo.entities.Utilisateur;


@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
}

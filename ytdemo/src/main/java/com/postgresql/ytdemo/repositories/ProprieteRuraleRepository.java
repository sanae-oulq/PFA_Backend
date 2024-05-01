package com.postgresql.ytdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postgresql.ytdemo.entities.ProprieteRurale;


@Repository
public interface ProprieteRuraleRepository extends JpaRepository<ProprieteRurale, Long>{

}

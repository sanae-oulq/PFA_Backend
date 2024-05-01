package com.postgresql.ytdemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.postgresql.ytdemo.entities.ProprieteUrbaine;

@Repository
public interface ProprieteUrbaineRepository extends JpaRepository<ProprieteUrbaine, Long>{

}

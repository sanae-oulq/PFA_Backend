package com.postgresql.ytdemo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "propriete_id")
public class ProprieteUrbaine extends Propriete {
    private String lib_bacha;

	public ProprieteUrbaine(String nom_propriete, double surface, String lib_prov, String lib_comm, String adresse,
			String genre, Proprietaire proprietaire, String lib_bacha) {
		super(nom_propriete, surface, lib_prov, lib_comm, adresse, genre, proprietaire);
		this.lib_bacha = lib_bacha;
	}

	public String getLib_bacha() {
		return lib_bacha;
	}

	public void setLib_bacha(String lib_bacha) {
		this.lib_bacha = lib_bacha;
	}
    
    
}


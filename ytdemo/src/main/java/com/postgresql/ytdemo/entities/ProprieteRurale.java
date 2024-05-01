package com.postgresql.ytdemo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "propriete_id")
public class ProprieteRurale extends Propriete {
    private String lib_cercle;
    private String lib_quiada;
	public ProprieteRurale(String nom_propriete, double surface, String lib_prov, String lib_comm, String adresse,
			String genre, Proprietaire proprietaire, String lib_cercle, String lib_quiada) {
		super(nom_propriete, surface, lib_prov, lib_comm, adresse, genre, proprietaire);
		this.lib_cercle = lib_cercle;
		this.lib_quiada = lib_quiada;
	}
	public String getLib_cercle() {
		return lib_cercle;
	}
	public void setLib_cercle(String lib_cercle) {
		this.lib_cercle = lib_cercle;
	}
	public String getLib_quiada() {
		return lib_quiada;
	}
	public void setLib_quiada(String lib_quiada) {
		this.lib_quiada = lib_quiada;
	}
    
    

}


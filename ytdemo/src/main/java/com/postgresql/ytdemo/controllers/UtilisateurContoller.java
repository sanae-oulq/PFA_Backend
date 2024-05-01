package com.postgresql.ytdemo.controllers;

import com.postgresql.ytdemo.services.UtilisateurService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.postgresql.ytdemo.entities.Utilisateur;

@RestController
@RequestMapping("/api/Utilisateurs")
public class UtilisateurContoller {
	
	@Autowired
    private UtilisateurService UtilisateurService;

    @PostMapping("")
    public ResponseEntity<Object> create(@RequestBody Utilisateur UtilisateurDetails) {
        Utilisateur Utilisateur = UtilisateurService.create(UtilisateurDetails);
        if (Utilisateur == null) {
            return new ResponseEntity<>("Invalid request Data", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(Utilisateur, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Utilisateur Utilisateur = UtilisateurService.findById(id);
        if (Utilisateur == null) {
            return new ResponseEntity<>("Utilisateur not found", HttpStatus.NOT_FOUND);
        } else {
            boolean deleted = UtilisateurService.delete(Utilisateur);
            if (deleted) {
                return new ResponseEntity<>("Utilisateur deleted successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Utilisateur associated to a user", HttpStatus.BAD_REQUEST);
            }
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Utilisateur Utilisateur) {
        if (UtilisateurService.findById(id) == null) {
            return new ResponseEntity<>("Utilisateur not found", HttpStatus.NOT_FOUND);
        } else {
            Utilisateur.setId(id);
            return new ResponseEntity<>(UtilisateurService.update(Utilisateur), HttpStatus.OK);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Utilisateur>> findAll() {
        return new ResponseEntity<>(UtilisateurService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        Utilisateur Utilisateur = UtilisateurService.findById(id);
        if (Utilisateur == null) {
            return new ResponseEntity<>("Utilisateur not found", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(Utilisateur, HttpStatus.OK);
        }
    }

}

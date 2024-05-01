package com.postgresql.ytdemo.controllers;

import com.postgresql.ytdemo.entities.Proprietaire;
import com.postgresql.ytdemo.services.ProprietaireService;

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

@RestController
@RequestMapping("/api/Proprietaires")
public class ProprietaireController {
	
	@Autowired
    private ProprietaireService ProprietaireService;

    @PostMapping("")
    public ResponseEntity<Object> create(@RequestBody Proprietaire ProprietaireDetails) {
        Proprietaire Proprietaire = ProprietaireService.create(ProprietaireDetails);
        if (Proprietaire == null) {
            return new ResponseEntity<>("Invalid request Data", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(Proprietaire, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Proprietaire Proprietaire = ProprietaireService.findById(id);
        if (Proprietaire == null) {
            return new ResponseEntity<>("Proprietaire not found", HttpStatus.NOT_FOUND);
        } else {
            boolean deleted = ProprietaireService.delete(Proprietaire);
            if (deleted) {
                return new ResponseEntity<>("Proprietaire deleted successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Proprietaire associated to a user", HttpStatus.BAD_REQUEST);
            }
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Proprietaire Proprietaire) {
        if (ProprietaireService.findById(id) == null) {
            return new ResponseEntity<>("Proprietaire not found", HttpStatus.NOT_FOUND);
        } else {
            Proprietaire.setId(id);
            return new ResponseEntity<>(ProprietaireService.update(Proprietaire), HttpStatus.OK);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Proprietaire>> findAll() {
        return new ResponseEntity<>(ProprietaireService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        Proprietaire Proprietaire = ProprietaireService.findById(id);
        if (Proprietaire == null) {
            return new ResponseEntity<>("Proprietaire not found", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(Proprietaire, HttpStatus.OK);
        }
    }

}

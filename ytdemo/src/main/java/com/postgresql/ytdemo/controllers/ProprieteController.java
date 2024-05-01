package com.postgresql.ytdemo.controllers;

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

import com.postgresql.ytdemo.entities.Propriete;

@RestController
@RequestMapping("/api/Proprietes")
public class ProprieteController {
	
	@Autowired
    private com.postgresql.ytdemo.services.ProprieteService ProprieteService;

    @PostMapping("")
    public ResponseEntity<Object> create(@RequestBody Propriete ProprieteDetails) {
        Propriete Propriete = ProprieteService.create(ProprieteDetails);
        if (Propriete == null) {
            return new ResponseEntity<>("Invalid request Data", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(Propriete, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Propriete Propriete = ProprieteService.findById(id);
        if (Propriete == null) {
            return new ResponseEntity<>("Propriete not found", HttpStatus.NOT_FOUND);
        } else {
            boolean deleted = ProprieteService.delete(Propriete);
            if (deleted) {
                return new ResponseEntity<>("Propriete deleted successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Propriete associated to a user", HttpStatus.BAD_REQUEST);
            }
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Propriete Propriete) {
        if (ProprieteService.findById(id) == null) {
            return new ResponseEntity<>("Propriete not found", HttpStatus.NOT_FOUND);
        } else {
            Propriete.setId(id);
            return new ResponseEntity<>(ProprieteService.update(Propriete), HttpStatus.OK);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Propriete>> findAll() {
        return new ResponseEntity<>(ProprieteService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        Propriete Propriete = ProprieteService.findById(id);
        if (Propriete == null) {
            return new ResponseEntity<>("Propriete not found", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(Propriete, HttpStatus.OK);
        }
    }

}

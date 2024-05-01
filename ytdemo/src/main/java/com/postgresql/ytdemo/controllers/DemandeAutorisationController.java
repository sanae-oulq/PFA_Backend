package com.postgresql.ytdemo.controllers;

import com.postgresql.ytdemo.entities.DemandeAutorisation;
import com.postgresql.ytdemo.services.DemandeAutorisationService;

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
@RequestMapping("/api/DemandeAutorisations")
public class DemandeAutorisationController {
	
	@Autowired
    private DemandeAutorisationService DemandeAutorisationService;

    @PostMapping("")
    public ResponseEntity<Object> create(@RequestBody DemandeAutorisation DemandeAutorisationDetails) {
        DemandeAutorisation DemandeAutorisation = DemandeAutorisationService.create(DemandeAutorisationDetails);
        if (DemandeAutorisation == null) {
            return new ResponseEntity<>("Invalid request Data", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(DemandeAutorisation, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        DemandeAutorisation DemandeAutorisation = DemandeAutorisationService.findById(id);
        if (DemandeAutorisation == null) {
            return new ResponseEntity<>("DemandeAutorisation not found", HttpStatus.NOT_FOUND);
        } else {
            boolean deleted = DemandeAutorisationService.delete(DemandeAutorisation);
            if (deleted) {
                return new ResponseEntity<>("DemandeAutorisation deleted successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("DemandeAutorisation associated to a user", HttpStatus.BAD_REQUEST);
            }
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody DemandeAutorisation DemandeAutorisation) {
        if (DemandeAutorisationService.findById(id) == null) {
            return new ResponseEntity<>("DemandeAutorisation not found", HttpStatus.NOT_FOUND);
        } else {
            DemandeAutorisation.setId(id);
            return new ResponseEntity<>(DemandeAutorisationService.update(DemandeAutorisation), HttpStatus.OK);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<DemandeAutorisation>> findAll() {
        return new ResponseEntity<>(DemandeAutorisationService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        DemandeAutorisation DemandeAutorisation = DemandeAutorisationService.findById(id);
        if (DemandeAutorisation == null) {
            return new ResponseEntity<>("DemandeAutorisation not found", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(DemandeAutorisation, HttpStatus.OK);
        }
    }

}

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

import com.postgresql.ytdemo.entities.Historique;

@RestController
@RequestMapping("/api/Historiques")
public class HistoriqueController {
	
	@Autowired
    private com.postgresql.ytdemo.services.HistoriqueService HistoriqueService;

    @PostMapping("")
    public ResponseEntity<Object> create(@RequestBody Historique HistoriqueDetails) {
        Historique Historique = HistoriqueService.create(HistoriqueDetails);
        if (Historique == null) {
            return new ResponseEntity<>("Invalid request Data", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(Historique, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Historique Historique = HistoriqueService.findById(id);
        if (Historique == null) {
            return new ResponseEntity<>("Historique not found", HttpStatus.NOT_FOUND);
        } else {
            boolean deleted = HistoriqueService.delete(Historique);
            if (deleted) {
                return new ResponseEntity<>("Historique deleted successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Historique associated to a user", HttpStatus.BAD_REQUEST);
            }
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Historique Historique) {
        if (HistoriqueService.findById(id) == null) {
            return new ResponseEntity<>("Historique not found", HttpStatus.NOT_FOUND);
        } else {
            Historique.setId(id);
            return new ResponseEntity<>(HistoriqueService.update(Historique), HttpStatus.OK);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Historique>> findAll() {
        return new ResponseEntity<>(HistoriqueService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        Historique Historique = HistoriqueService.findById(id);
        if (Historique == null) {
            return new ResponseEntity<>("Historique not found", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(Historique, HttpStatus.OK);
        }
    }

}

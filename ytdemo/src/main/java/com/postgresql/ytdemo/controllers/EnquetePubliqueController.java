package com.postgresql.ytdemo.controllers;

import com.postgresql.ytdemo.entities.EnquetePublique;
import com.postgresql.ytdemo.services.EnquetePubliqueService;

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
@RequestMapping("/api/EnquetePubliques")
public class EnquetePubliqueController {
	
	@Autowired
    private EnquetePubliqueService EnquetePubliqueService;

    @PostMapping("")
    public ResponseEntity<Object> create(@RequestBody EnquetePublique EnquetePubliqueDetails) {
        EnquetePublique EnquetePublique = EnquetePubliqueService.create(EnquetePubliqueDetails);
        if (EnquetePublique == null) {
            return new ResponseEntity<>("Invalid request Data", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(EnquetePublique, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        EnquetePublique EnquetePublique = EnquetePubliqueService.findById(id);
        if (EnquetePublique == null) {
            return new ResponseEntity<>("EnquetePublique not found", HttpStatus.NOT_FOUND);
        } else {
            boolean deleted = EnquetePubliqueService.delete(EnquetePublique);
            if (deleted) {
                return new ResponseEntity<>("EnquetePublique deleted successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("EnquetePublique associated to a user", HttpStatus.BAD_REQUEST);
            }
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody EnquetePublique EnquetePublique) {
        if (EnquetePubliqueService.findById(id) == null) {
            return new ResponseEntity<>("EnquetePublique not found", HttpStatus.NOT_FOUND);
        } else {
            EnquetePublique.setId(id);
            return new ResponseEntity<>(EnquetePubliqueService.update(EnquetePublique), HttpStatus.OK);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<EnquetePublique>> findAll() {
        return new ResponseEntity<>(EnquetePubliqueService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        EnquetePublique EnquetePublique = EnquetePubliqueService.findById(id);
        if (EnquetePublique == null) {
            return new ResponseEntity<>("EnquetePublique not found", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(EnquetePublique, HttpStatus.OK);
        }
    }

}

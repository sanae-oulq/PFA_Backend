package com.postgresql.ytdemo.controllers;

import com.postgresql.ytdemo.entities.ProprieteRurale;
import com.postgresql.ytdemo.services.ProprieteRuraleService;

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
@RequestMapping("/api/ProprieteRurales")
public class ProprieteRuraleController {
	
	@Autowired
    private ProprieteRuraleService ProprieteRuraleService;

    @PostMapping("")
    public ResponseEntity<Object> create(@RequestBody ProprieteRurale ProprieteRuraleDetails) {
        ProprieteRurale ProprieteRurale = ProprieteRuraleService.create(ProprieteRuraleDetails);
        if (ProprieteRurale == null) {
            return new ResponseEntity<>("Invalid request Data", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(ProprieteRurale, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        ProprieteRurale ProprieteRurale = ProprieteRuraleService.findById(id);
        if (ProprieteRurale == null) {
            return new ResponseEntity<>("ProprieteRurale not found", HttpStatus.NOT_FOUND);
        } else {
            boolean deleted = ProprieteRuraleService.delete(ProprieteRurale);
            if (deleted) {
                return new ResponseEntity<>("ProprieteRurale deleted successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("ProprieteRurale associated to a user", HttpStatus.BAD_REQUEST);
            }
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody ProprieteRurale ProprieteRurale) {
        if (ProprieteRuraleService.findById(id) == null) {
            return new ResponseEntity<>("ProprieteRurale not found", HttpStatus.NOT_FOUND);
        } else {
            ProprieteRurale.setId(id);
            return new ResponseEntity<>(ProprieteRuraleService.update(ProprieteRurale), HttpStatus.OK);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<ProprieteRurale>> findAll() {
        return new ResponseEntity<>(ProprieteRuraleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        ProprieteRurale ProprieteRurale = ProprieteRuraleService.findById(id);
        if (ProprieteRurale == null) {
            return new ResponseEntity<>("ProprieteRurale not found", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(ProprieteRurale, HttpStatus.OK);
        }
    }

}

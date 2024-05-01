package com.postgresql.ytdemo.controllers;

import com.postgresql.ytdemo.entities.ProprieteUrbaine;
import com.postgresql.ytdemo.services.ProprieteUrbaineService;

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
@RequestMapping("/api/ProprieteUrbaines")
public class ProprieteUrbaineController {
	
	@Autowired
    private ProprieteUrbaineService ProprieteUrbaineService;

    @PostMapping("")
    public ResponseEntity<Object> create(@RequestBody ProprieteUrbaine ProprieteUrbaineDetails) {
        ProprieteUrbaine ProprieteUrbaine = ProprieteUrbaineService.create(ProprieteUrbaineDetails);
        if (ProprieteUrbaine == null) {
            return new ResponseEntity<>("Invalid request Data", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(ProprieteUrbaine, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        ProprieteUrbaine ProprieteUrbaine = ProprieteUrbaineService.findById(id);
        if (ProprieteUrbaine == null) {
            return new ResponseEntity<>("ProprieteUrbaine not found", HttpStatus.NOT_FOUND);
        } else {
            boolean deleted = ProprieteUrbaineService.delete(ProprieteUrbaine);
            if (deleted) {
                return new ResponseEntity<>("ProprieteUrbaine deleted successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("ProprieteUrbaine associated to a user", HttpStatus.BAD_REQUEST);
            }
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody ProprieteUrbaine ProprieteUrbaine) {
        if (ProprieteUrbaineService.findById(id) == null) {
            return new ResponseEntity<>("ProprieteUrbaine not found", HttpStatus.NOT_FOUND);
        } else {
            ProprieteUrbaine.setId(id);
            return new ResponseEntity<>(ProprieteUrbaineService.update(ProprieteUrbaine), HttpStatus.OK);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<ProprieteUrbaine>> findAll() {
        return new ResponseEntity<>(ProprieteUrbaineService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        ProprieteUrbaine ProprieteUrbaine = ProprieteUrbaineService.findById(id);
        if (ProprieteUrbaine == null) {
            return new ResponseEntity<>("ProprieteUrbaine not found", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(ProprieteUrbaine, HttpStatus.OK);
        }
    }

}

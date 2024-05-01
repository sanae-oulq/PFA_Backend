package com.postgresql.ytdemo.controllers;

import com.postgresql.ytdemo.entities.Document;
import com.postgresql.ytdemo.services.DocumentService;

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
@RequestMapping("/api/Documents")
public class DocumentController {
	
	@Autowired
    private DocumentService DocumentService;

    @PostMapping("")
    public ResponseEntity<Object> create(@RequestBody Document DocumentDetails) {
        Document Document = DocumentService.create(DocumentDetails);
        if (Document == null) {
            return new ResponseEntity<>("Invalid request Data", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(Document, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Document Document = DocumentService.findById(id);
        if (Document == null) {
            return new ResponseEntity<>("Document not found", HttpStatus.NOT_FOUND);
        } else {
            boolean deleted = DocumentService.delete(Document);
            if (deleted) {
                return new ResponseEntity<>("Document deleted successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Document associated to a user", HttpStatus.BAD_REQUEST);
            }
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Document Document) {
        if (DocumentService.findById(id) == null) {
            return new ResponseEntity<>("Document not found", HttpStatus.NOT_FOUND);
        } else {
            Document.setId(id);
            return new ResponseEntity<>(DocumentService.update(Document), HttpStatus.OK);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Document>> findAll() {
        return new ResponseEntity<>(DocumentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        Document Document = DocumentService.findById(id);
        if (Document == null) {
            return new ResponseEntity<>("Document not found", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(Document, HttpStatus.OK);
        }
    }

}

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

import com.postgresql.ytdemo.entities.Role;
import com.postgresql.ytdemo.services.RoleService;

@RestController
@RequestMapping("/api/Roles")
public class RoleController {
	
	@Autowired
    private RoleService RoleService;

    @PostMapping("")
    public ResponseEntity<Object> create(@RequestBody Role RoleDetails) {
        Role Role = RoleService.create(RoleDetails);
        if (Role == null) {
            return new ResponseEntity<>("Invalid request Data", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(Role, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        Role Role = RoleService.findById(id);
        if (Role == null) {
            return new ResponseEntity<>("Role not found", HttpStatus.NOT_FOUND);
        } else {
            boolean deleted = RoleService.delete(Role);
            if (deleted) {
                return new ResponseEntity<>("Role deleted successfully", HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Role associated to a user", HttpStatus.BAD_REQUEST);
            }
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Role Role) {
        if (RoleService.findById(id) == null) {
            return new ResponseEntity<>("Role not found", HttpStatus.NOT_FOUND);
        } else {
            Role.setId(id);
            return new ResponseEntity<>(RoleService.update(Role), HttpStatus.OK);
        }
    }

    @GetMapping("")
    public ResponseEntity<List<Role>> findAll() {
        return new ResponseEntity<>(RoleService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id) {
        Role Role = RoleService.findById(id);
        if (Role == null) {
            return new ResponseEntity<>("Role not found", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(Role, HttpStatus.OK);
        }
    }

}

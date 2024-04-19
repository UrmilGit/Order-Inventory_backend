package com.orderinventory.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderinventory.dto.AdminDto;
import com.orderinventory.exceptions.NotFoundException;
import com.orderinventory.services.AdminService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/admin")
@CrossOrigin(origins = "http://localhost:3000/")
public class AdminController {
	
	@Autowired
	AdminService service;
	
	@PostMapping("/")
    public ResponseEntity<Void> createAdmin(@Valid @RequestBody AdminDto admin) {
        service.addAdmin(admin);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
	
	@GetMapping("/search/{username}")
	public ResponseEntity<AdminDto> getAdminByUserName(@PathVariable("username") String userName) throws NotFoundException {
		return new ResponseEntity<AdminDto>(service.getAdminByUserName(userName), HttpStatus.OK);
	}
}

package com.orderinventory.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.orderinventory.dto.AdminDto;
import com.orderinventory.entities.Admin;
import com.orderinventory.exceptions.NotFoundException;
import com.orderinventory.repo.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	AdminRepository repo;

	@Override
	public void addAdmin(AdminDto admin) {
		Admin a = new Admin();
		a.setUserID(admin.getUserid());
		a.setUserName(admin.getUsername());
		a.setEmailAddress(admin.getEmail());
		a.setPassword(admin.getPassword());
		repo.save(a);
		
	}

	@Override
	public AdminDto getAdminByUserName(String userName) throws NotFoundException {
AdminDto adminDto = new AdminDto();
	    
	    
	    Optional<Admin> userOptional = repo.findAll().stream()
	                                         .filter(u -> u.getUserName().equals(userName))
	                                         .findFirst();
	    
	   
	
	    Admin ad = userOptional.orElseThrow(() -> new NotFoundException("User not found with username: " + userName));
 
	    
	    // Set properties from the found user entity to the DTO
	    adminDto.setUserid(ad.getUserID());
	   adminDto.setUsername(ad.getUserName());
	    adminDto.setEmail(ad.getEmailAddress());
	    adminDto.setPassword(ad.getPassword());
	    
	    return adminDto;
	}

}

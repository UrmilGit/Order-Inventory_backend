package com.orderinventory.services;

import com.orderinventory.dto.AdminDto;
import com.orderinventory.exceptions.NotFoundException;

public interface AdminService {
	void addAdmin(AdminDto admin);
	AdminDto getAdminByUserName(String userName)throws NotFoundException ;
	
}

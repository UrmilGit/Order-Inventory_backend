package com.orderinventory.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.orderinventory.entities.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {

}

package com.office.repositorySuperAdmin;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.office.modelSuperAdmin.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {
	Admin findByEmailAndPassword(String email,String password);

	Optional<Admin> findById(Long id);
	
	Admin findByEmail(String email);
	
	Boolean existsByEmailAndPassword(String email,String password);

	Admin findByEmailAndPasswordAndStatus(String email, String password, String status);
}

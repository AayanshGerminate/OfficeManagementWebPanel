package com.office.serviceSuperAdmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.modelSuperAdmin.Admin;
import com.office.repositorySuperAdmin.AdminRepository;


@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	public Admin validateAdmin(String email,String password)
	{
		String status = "Active";
		 return adminRepository.findByEmailAndPasswordAndStatus(email, password, status);
	}
	
	public Admin getById(Long id)
	{
		return adminRepository.findById(id).get();
	}
	
	public Admin getByEmail(String email)
	{
		return adminRepository.findByEmail(email);
	}
	
	public Admin saveAdmin(Admin admin)
	{
		return adminRepository.save(admin);
	}
	
	public Boolean checkUserByEmailAndPasword(String email, String password)
	{
		return adminRepository.existsByEmailAndPassword(email, password);
	}
	
}

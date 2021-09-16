package com.office.serviceSuperAdmin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.modelSuperAdmin.Lead;
import com.office.repositorySuperAdmin.LeadRepository;

@Service
public class LeadService {
	@Autowired
	LeadRepository leadRepository;
	
	
	public List<Lead> getAllLead() {
		return leadRepository.findAll();

	}

	public void saveLead(Lead lead) {
		leadRepository.save(lead);

	}

	public Optional<Lead> getLead(Long id) {
		return leadRepository.findById(id);

	}

	public void deleteLead(Long id) {
		leadRepository.deleteById(id);
	}

}

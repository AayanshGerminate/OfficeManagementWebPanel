package com.office.serviceSuperAdmin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.modelSuperAdmin.Leads;
import com.office.repositorySuperAdmin.LeadRepository;

@Service
public class LeadService {
	
	@Autowired
	LeadRepository leadRepository;
	
	public List<Leads> getAllLead() {
		return leadRepository.findAll();

	}

	public void saveLead(Leads leads) {
		leadRepository.save(leads);

	}

	public Optional<Leads> getLead(Long id) {
		return leadRepository.findById(id);

	}

	public void deleteLead(Long id) {
		leadRepository.deleteById(id);
	}

}

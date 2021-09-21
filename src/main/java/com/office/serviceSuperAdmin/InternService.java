package com.office.serviceSuperAdmin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.modelSuperAdmin.Intern;
import com.office.modelSuperAdmin.Leaves;
import com.office.repositorySuperAdmin.InternRepository;
import com.office.webResponse.LeaveResponse;

@Service
public class InternService {
	@Autowired
	InternRepository internRepository;

	public List<Intern> getAllIntern() {
		return internRepository.findAll();

	}

	public void saveIntern(Intern intern) {
		internRepository.save(intern);

	}

	public Optional<Intern> getIntern(Long id) {
		return internRepository.findById(id);

	}

	public void deleteIntern(Long id) {
		internRepository.deleteById(id);
	}

}

package com.office.serviceSuperAdmin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.modelSuperAdmin.AgplExpense;
import com.office.repositorySuperAdmin.AgplExpenseRepository;

@Service
public class AgplExpenseService {

	@Autowired
	private AgplExpenseRepository agplExpenseRExpenseRepository;

	public List<AgplExpense> getAllAgplExpense() {
		return agplExpenseRExpenseRepository.findAll();

	}

	public void saveExpense(AgplExpense expense) {
		agplExpenseRExpenseRepository.save(expense);

	}

	public Optional<AgplExpense> getExpense(Long id) {
		return agplExpenseRExpenseRepository.findById(id);

	}

	public void deleteExpense(Long id) {
		agplExpenseRExpenseRepository.deleteById(id);
	}

}

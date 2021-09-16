package com.office.serviceSuperAdmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.repositorySuperAdmin.FinancialRepository;

@Service
public class FinancialService {

	@Autowired
	FinancialRepository financialRepository;
	
}

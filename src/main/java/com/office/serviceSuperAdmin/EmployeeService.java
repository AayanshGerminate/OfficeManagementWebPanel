package com.office.serviceSuperAdmin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.modelSuperAdmin.Employee;
import com.office.repositorySuperAdmin.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	public void saveEmployee(Employee employee) {
		employeeRepository.save(employee);

	}

	public Employee getEmployee(Long id) {
		return employeeRepository.findById(id).get();

	}

	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}

	public List<Employee> getEmployeeList() {
		return employeeRepository.findAll();

	}

}

package com.office.serviceSuperAdmin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.modelSuperAdmin.Employee;
import com.office.repositorySuperAdmin.EmployeeRepository;
import com.office.webResponse.EmployeeResponse;

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

	public Employee validateAdmin(String email, String password) {
		String status = "Active";
		return employeeRepository.findByEmailAndPasswordAndStatus(email, password, status);
	}

	public Boolean checkUserByEmailAndPasword(String email, String password) {
		return employeeRepository.existsByEmailAndPassword(email, password);
	}

	public Employee getByEmail(String email) {
		return employeeRepository.findByEmail(email);
	}

	public Employee getById(Long id) {
		return employeeRepository.getById(id);

	}
	
	public List<EmployeeResponse> getAllEmployeeIdAndName(){
	 return employeeRepository.getAllEmployeeIdAndName();
	}
}

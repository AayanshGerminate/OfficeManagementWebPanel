package com.office.repositorySuperAdmin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.office.modelSuperAdmin.Employee;
import com.office.webResponse.EmployeeResponse;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
Employee findByEmail(String email);
	
	Boolean existsByEmailAndPassword(String email,String password);

	Employee findByEmailAndPasswordAndStatus(String email, String password, String status);
	
	@Query("SELECT new com.office.webResponse.EmployeeResponse(id,name) from Employee")
	List<EmployeeResponse> getAllEmployeeIdAndName();
	
}

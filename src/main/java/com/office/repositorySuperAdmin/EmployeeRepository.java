package com.office.repositorySuperAdmin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.office.modelSuperAdmin.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
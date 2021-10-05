package com.office.repositorySuperAdmin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.office.modelSuperAdmin.ToDoList;

@Repository
public interface ToDoListRepository  extends JpaRepository<ToDoList,Long>{

	
	List<ToDoList> findByEmployeeId(Long employeeId);
	
}

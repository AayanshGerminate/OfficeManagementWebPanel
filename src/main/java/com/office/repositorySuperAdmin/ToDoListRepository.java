package com.office.repositorySuperAdmin;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.office.modelSuperAdmin.ToDoList;
import com.office.webResponse.ToDoResponse;

@Repository
public interface ToDoListRepository  extends JpaRepository<ToDoList,Long>{

	
	List<ToDoList> findTop3ByEmployeeIdOrderByUpdatedDateDesc(Long employeeId);
	
	List<ToDoList> findTop10ByEmployeeIdOrderByUpdatedDateDesc(Long employeeId);
	
}

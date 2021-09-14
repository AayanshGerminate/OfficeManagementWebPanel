package com.office.repositorySuperAdmin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.office.modelSuperAdmin.ToDoList;

@Repository
public interface ToDoListRepository  extends JpaRepository<ToDoList,Long>{

}

package com.office.serviceSuperAdmin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.modelSuperAdmin.ToDoList;
import com.office.repositorySuperAdmin.ToDoListRepository;
import com.office.webResponse.ToDoResponse;

@Service
public class ToDoListService {
	@Autowired
	private ToDoListRepository toDoListRepository;

	public List<ToDoList> getAllToDoList() {
		return toDoListRepository.findAll();

	}

	public void saveToDoListt(ToDoList toDoList) {
		toDoListRepository.save(toDoList);

	}

	public Optional<ToDoList> getToDoList(Long id) {
		return toDoListRepository.findById(id);

	}
	
	public List<ToDoList> getTop3ToDoListByEmployeeIdAndUpdatedDate(Long employeeId) {
		
		return  toDoListRepository.findTop3ByEmployeeIdOrderByUpdatedDateDesc(employeeId);
		
	}

	public List<ToDoList> getTop10ToDoListByEmployeeIdAndUpdatedDate(Long employeeId) {
		
		return  toDoListRepository.findTop10ByEmployeeIdOrderByUpdatedDateDesc(employeeId);
		
	}

	public void deleteToDiList(Long id) {
		toDoListRepository.deleteById(id);
	}

}

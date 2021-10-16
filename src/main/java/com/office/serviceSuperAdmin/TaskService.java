package com.office.serviceSuperAdmin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.modelSuperAdmin.Task;
import com.office.repositorySuperAdmin.TaskRepository;
import com.office.webResponse.TaskResponse;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	public List<TaskResponse> getAllTasksByEmployeeId(Long employeeId) {
		return taskRepository.getTaskListByEmployeeId(employeeId);

	}

	public void saveTask(Task task) {
		taskRepository.save(task);

	}

	public Optional<Task> getTask(Long id) {
		return taskRepository.findById(id);

	}

	public void deleteTask(Long id) {
		taskRepository.deleteById(id);
	}

}

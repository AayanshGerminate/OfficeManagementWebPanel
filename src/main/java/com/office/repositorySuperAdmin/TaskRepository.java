package com.office.repositorySuperAdmin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.office.modelSuperAdmin.Task;
import com.office.webResponse.TaskResponse;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {
	
	List<Task> findAllByEmployeeId(Long employeeId);
													
	@Query("SELECT new com.office.webResponse.TaskResponse(t.id,p.projectName,e.name,t.date,t.scheduledTask,t.unScheduledTask,t.scheduledTime,t.actualTime,t.priority,t.status,t.updatedDate)FROM Task t JOIN Project p ON t.projectId=p.id JOIN Employee e ON t.employeeId=e.id WHERE t.employeeId=:employeeId" )
	List<TaskResponse> getTaskListByEmployeeId(Long employeeId);
}

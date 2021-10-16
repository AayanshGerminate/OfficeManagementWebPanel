package com.office.repositorySuperAdmin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.office.modelSuperAdmin.Project;
import com.office.webResponse.ProjectResponse;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {

	
	@Query("SELECT new com.office.webResponse.ProjectResponse(id,projectName) from Project")
	List<ProjectResponse> getAllProjectIdAndName();
	
	

}

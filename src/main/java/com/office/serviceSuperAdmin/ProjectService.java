package com.office.serviceSuperAdmin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.modelSuperAdmin.Project;
import com.office.repositorySuperAdmin.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	public List<Project> getAllProject() {
		return projectRepository.findAll();

	}

	public void saveProject(Project project) {
		projectRepository.save(project);

	}

	public Optional<Project> getProject(Long id) {
		return projectRepository.findById(id);

	}

	public void deleteProject(Long id) {
		projectRepository.deleteById(id);
	}

}

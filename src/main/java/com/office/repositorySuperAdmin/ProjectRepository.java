package com.office.repositorySuperAdmin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.office.modelSuperAdmin.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {

}

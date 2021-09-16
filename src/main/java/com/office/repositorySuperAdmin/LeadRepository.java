package com.office.repositorySuperAdmin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.office.modelSuperAdmin.Lead;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Long> {

}

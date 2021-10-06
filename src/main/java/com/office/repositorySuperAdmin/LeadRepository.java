package com.office.repositorySuperAdmin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.office.modelSuperAdmin.Leads;

@Repository
public interface LeadRepository extends JpaRepository<Leads, Long> {
	

}

package com.office.repositorySuperAdmin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.office.modelSuperAdmin.Intern;

@Repository
public interface InternRepository extends JpaRepository<Intern, Long> {

}

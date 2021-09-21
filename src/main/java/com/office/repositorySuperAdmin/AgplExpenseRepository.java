package com.office.repositorySuperAdmin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.office.modelSuperAdmin.AgplExpense;

@Repository
public interface AgplExpenseRepository extends JpaRepository<AgplExpense,Long> {

}

package com.office.repositorySuperAdmin;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.office.modelSuperAdmin.Leaves;
import com.office.webResponse.LeaveResponse;

@Repository
public interface LeaveRepository extends JpaRepository<Leaves, Long> {

List<Leaves> findByEmployeeId(Long employeeId);


@Query("SELECT new com.office.webResponse.LeaveResponse(l.id,e.name,l.department,l.fromDate,l.toDate,l.description) FROM Leaves l LEFT JOIN Employee e ON l.employeeId=e.id  WHERE l.employeeId=:employeeId")
List<LeaveResponse> getLeaveList(Long employeeId);

}

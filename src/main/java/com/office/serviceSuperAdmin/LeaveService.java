package com.office.serviceSuperAdmin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.modelSuperAdmin.Leaves;
import com.office.repositorySuperAdmin.LeaveRepository;
import com.office.webResponse.LeaveResponse;

@Service
public class LeaveService {
	@Autowired
	LeaveRepository leaveRepository;

	public List<Leaves> getAllLeaves() {
		return leaveRepository.findAll();

	}
	public List<LeaveResponse> getEmployeeLeaves(Long employeeId) {
		return leaveRepository.getLeaveList(employeeId);

	}
	

	public void saveLeaves(Leaves Leaves) {
		leaveRepository.save(Leaves);

	}

	public Optional<Leaves> getLeaves(Long id) {
		return leaveRepository.findById(id);

	}

	public void deleteLeaves(Long id) {
		leaveRepository.deleteById(id);
	}

}

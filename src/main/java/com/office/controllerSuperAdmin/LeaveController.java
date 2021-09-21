package com.office.controllerSuperAdmin;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.office.modelSuperAdmin.Leaves;
import com.office.serviceSuperAdmin.LeaveService;
import com.office.webResponse.JsonResponse;
import com.office.webResponse.LeaveResponse;

@Controller
public class LeaveController {

	@Autowired
	LeaveService leaveService;

	@RequestMapping("/manage-leave")
	public String fetchBookProjects(Model model, HttpSession session) {
		if (session.getAttribute("sign-in-user") != null) {
			return "admin/manage-leave";
		}
		return "redirect:/sign-in";

	}

	@RequestMapping(value = "/fetch-all-leave-list", method = RequestMethod.GET)
	@ResponseBody
	public List<Leaves> leaveList() {
		return leaveService.getAllLeaves();
	}
	
	@RequestMapping(value = "/fetch-all--employeeleave-list", method = RequestMethod.GET)
	@ResponseBody
	public List<LeaveResponse> employeeLeaveList(HttpSession session) {
		Long employeeId=(Long) session.getAttribute("sign-in-userId");
		System.out.println(employeeId);
		return leaveService.getEmployeeLeaves(employeeId);
		
		
	}

	@RequestMapping(value = "/save-leave", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse saveLead(Leaves leave, HttpSession session) {
		// Project.setUpdatedName(session.getAttribute("sign-in-user").toString());
		
		Long employeeId=(Long) session.getAttribute("sign-in-userId");
		leave.setEmployeeId(employeeId);
		leaveService.saveLeaves(leave);
		JsonResponse resp = new JsonResponse();

		resp.setMessage("Leave Inserted Successfully");
		resp.setStatus("True");
		return resp;
	}

	@RequestMapping("/get-leave")
	@ResponseBody
	public Optional<Leaves> getLead(Long Id) {
		return leaveService.getLeaves(Id);

	}

	@RequestMapping(value = "/update-leave", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse updateLeave(Leaves leave, HttpSession session) {
		// Project.setUpdatedName(session.getAttribute("sign-in-user").toString());
		Long employeeId=(Long) session.getAttribute("sign-in-userId");
		leave.setEmployeeId(employeeId);
		leaveService.saveLeaves(leave);

		JsonResponse resp = new JsonResponse();
		resp.setMessage("Leave Updated Successfully");
		resp.setStatus("True");
		return resp;
	}

	@RequestMapping(value = "/delete-leave", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse deleteLeave(Long Id) {
		leaveService.deleteLeaves(Id);
		JsonResponse resp = new JsonResponse();
		resp.setMessage("Leave Deleted Successfully");
		resp.setStatus("True");
		return resp;
	}

}

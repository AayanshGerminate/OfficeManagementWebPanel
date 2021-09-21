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

import com.office.modelSuperAdmin.Lead;
import com.office.serviceSuperAdmin.LeadService;
import com.office.webResponse.JsonResponse;

@Controller
public class LeadController {

	@Autowired
	LeadService leadService;

	@RequestMapping("/manage-lead")
	public String fetchBookProjects(Model model, HttpSession session) {
		if (session.getAttribute("sign-in-user") != null) {
			return "admin/manage-lead";
		}
		return "redirect:/sign-in";

	}

	@RequestMapping(value = "/fetch-all-lead-list", method = RequestMethod.GET)
	@ResponseBody
	public List<Lead> ProjectList() {
		return leadService.getAllLead();
	}

	@RequestMapping(value = "/save-lead", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse saveLead(Lead lead, HttpSession session) {
		// Project.setUpdatedName(session.getAttribute("sign-in-user").toString());
		leadService.saveLead(lead);
		JsonResponse resp = new JsonResponse();

		resp.setMessage("Lead Inserted Successfully");
		resp.setStatus("True");
		return resp;
	}

	@RequestMapping("/get-lead")
	@ResponseBody
	public Optional<Lead> getLead(Long Id) {
		return leadService.getLead(Id);

	}

	@RequestMapping(value = "/update-lead", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse updateLead(Lead lead, HttpSession session) {
		// Project.setUpdatedName(session.getAttribute("sign-in-user").toString());

		leadService.saveLead(lead);

		JsonResponse resp = new JsonResponse();
		resp.setMessage("Lead Updated Successfully");
		resp.setStatus("True");
		return resp;
	}

	@RequestMapping(value = "/delete-lead", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse deleteLead(Long Id) {
		leadService.deleteLead(Id);
		JsonResponse resp = new JsonResponse();
		resp.setMessage("Lead Deleted Successfully");
		resp.setStatus("True");
		return resp;
	}

}

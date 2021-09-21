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

import com.office.modelSuperAdmin.Intern;
import com.office.serviceSuperAdmin.InternService;
import com.office.webResponse.JsonResponse;

@Controller
public class InternController {
	
	@Autowired
	InternService internService;
	
	
	@RequestMapping("/manage-intern-income")
	public String fetchInternIncome(Model model, HttpSession session) {
		if (session.getAttribute("sign-in-user") != null) {
			return "admin/manage-intern-income";
		}
		return "redirect:/sign-in";

	}

	
	@RequestMapping("/manage-project-income")
	public String fetchProjectIncome(Model model, HttpSession session) {
		if (session.getAttribute("sign-in-user") != null) {
			return "admin/manage-project-income";
		}
		return "redirect:/sign-in";

	}

	@RequestMapping(value = "/fetch-all-intern-list", method = RequestMethod.GET)
	@ResponseBody
	public List<Intern> getAllInternList() {
		return internService.getAllIntern();
		
	}

	@RequestMapping(value = "/save-intern", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse saveIntern(Intern intern, HttpSession session) {
		// Project.setUpdatedName(session.getAttribute("sign-in-user").toString());
		internService.saveIntern(intern);
		JsonResponse resp = new JsonResponse();

		resp.setMessage("Intern Inserted Successfully");
		resp.setStatus("True");
		return resp;
	}

	@RequestMapping("/get-intern")
	@ResponseBody
	public Optional<Intern> getIntern(Long Id) {
		return internService.getIntern(Id);

	}

	@RequestMapping(value = "/update-intern", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse updateLead(Intern intern, HttpSession session) {
		// Project.setUpdatedName(session.getAttribute("sign-in-user").toString());

		internService.saveIntern(intern);

		JsonResponse resp = new JsonResponse();
		resp.setMessage("Intern Updated Successfully");
		resp.setStatus("True");
		return resp;
	}

	@RequestMapping(value = "/delete-intern", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse deleteIntern(Long Id) {
		internService.deleteIntern(Id);
		JsonResponse resp = new JsonResponse();
		resp.setMessage("Intern Deleted Successfully");
		resp.setStatus("True");
		return resp;
	}

}

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

import com.office.modelSuperAdmin.AgplExpense;
import com.office.serviceSuperAdmin.AgplExpenseService;
import com.office.webResponse.JsonResponse;

@Controller
public class AgplExpenseController {

	@Autowired
	AgplExpenseService agplExpenseService;

	@RequestMapping("/manage-agpl-expense")
	public String fetchBookProjects(Model model, HttpSession session) {
		if (session.getAttribute("sign-in-user") != null) {
			return "admin/manage-agpl-expense";
		}
		return "redirect:/sign-in";

	}

	@RequestMapping(value = "/fetch-all-agpl-expense-list", method = RequestMethod.GET)
	@ResponseBody
	public List<AgplExpense> ProjectList() {
		return agplExpenseService.getAllAgplExpense();

	}

	@RequestMapping(value = "/save-agpl-expense", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse saveAgplExpense(AgplExpense expense, HttpSession session) {
		// Project.setUpdatedName(session.getAttribute("sign-in-user").toString());
		agplExpenseService.saveExpense(expense);
		JsonResponse resp = new JsonResponse();

		resp.setMessage("Expense Inserted Successfully");
		resp.setStatus("True");
		return resp;
	}

	@RequestMapping("/get-agpl-expense")
	@ResponseBody
	public Optional<AgplExpense> getAgplExpense(Long Id) {
		return agplExpenseService.getExpense(Id);

	}

	@RequestMapping(value = "/update-agpl-expense", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse updateLead(AgplExpense expense, HttpSession session) {
		// Project.setUpdatedName(session.getAttribute("sign-in-user").toString());

		agplExpenseService.saveExpense(expense);

		JsonResponse resp = new JsonResponse();
		resp.setMessage("Expense Updated Successfully");
		resp.setStatus("True");
		return resp;
	}

	@RequestMapping(value = "/delete-agpl-expense", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse deleteAgplExpense(Long Id) {
		agplExpenseService.deleteExpense(Id);
		JsonResponse resp = new JsonResponse();
		resp.setMessage("Expense Deleted Successfully");
		resp.setStatus("True");
		return resp;
	}

}

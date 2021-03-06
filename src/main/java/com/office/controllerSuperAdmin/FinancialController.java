package com.office.controllerSuperAdmin;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.office.serviceSuperAdmin.FinancialService;
import com.office.webResponse.DocumentResponse;

@Controller
public class FinancialController {

	@Autowired
	FinancialService financialService;

	@RequestMapping("/income-dashboard")
	public String incomedashboard(Model model, HttpSession session) {
		if (session.getAttribute("sign-in-user") != null) {

			return "admin/income-dashboard";
		}

		return "redirect:/sign-in";

	}
	
	@RequestMapping("/intern-income")
	public String internIncome(Model model, HttpSession session) {
		if (session.getAttribute("sign-in-user") != null) {

			return "intern-income";
		}

		return "redirect:/sign-in";

	}

}

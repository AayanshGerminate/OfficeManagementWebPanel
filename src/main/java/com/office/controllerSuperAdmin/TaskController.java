package com.office.controllerSuperAdmin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.office.modelSuperAdmin.ToDoList;
import com.office.serviceSuperAdmin.ToDoListService;
import com.office.webResponse.JsonResponse;

@Controller
public class TaskController {

	@Autowired
	ToDoListService toDoListService;

	@RequestMapping("/manage-task")
	public String fetchBookProjects(Model model, HttpSession session) {
		if (session.getAttribute("sign-in-user") != null) {
			return "admin/manage-task";
		}
		return "redirect:/sign-in";

	}
	
}

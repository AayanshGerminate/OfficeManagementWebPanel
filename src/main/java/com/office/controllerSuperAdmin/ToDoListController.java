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

import com.office.modelSuperAdmin.ToDoList;
import com.office.serviceSuperAdmin.ToDoListService;
import com.office.webResponse.JsonResponse;

@Controller
public class ToDoListController {

	@Autowired
	ToDoListService toDoListService;

	@RequestMapping("/manage-todo-list")
	public String fetchBookProjects(Model model, HttpSession session) {
		if (session.getAttribute("sign-in-user") != null) {
			return "admin/manage-todo-list";
		}
		return "redirect:/sign-in";

	}
	
	@RequestMapping("/to-do-list")
	public String toDoList(Model model, HttpSession session) {
		if (session.getAttribute("sign-in-user") != null) {
			Long id = (Long)session.getAttribute("sign-in-userId");
			model.addAttribute("todoList", toDoListService.getTop10ToDoListByEmployeeIdAndUpdatedDate(id));
			return "admin/to-do-list";
		}
		return "redirect:/sign-in";

	}

	@RequestMapping(value = "/fetch-all-todo-list", method = RequestMethod.GET)
	@ResponseBody
	public List<ToDoList> ProjectList() {
		return toDoListService.getAllToDoList();

	}

	@RequestMapping(value = "/save-todo-list", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse saveProject(ToDoList toDoList, HttpSession session) {
		// Project.setUpdatedName(session.getAttribute("sign-in-user").toString());

		Long employeeId = (Long) session.getAttribute("sign-in-userId");
		toDoList.setEmployeeId(employeeId);
		toDoListService.saveToDoListt(toDoList);
		JsonResponse resp = new JsonResponse();

		resp.setMessage("To do List Inserted Successfully");
		resp.setStatus("True");
		return resp;
	}

	@RequestMapping("/get-todo-list")
	@ResponseBody
	public Optional<ToDoList> getProject(Long Id) {
		return toDoListService.getToDoList(Id);

	}

	@RequestMapping(value = "/update-todo-list", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse updateProject(ToDoList toDoList, HttpSession session) {
		// Project.setUpdatedName(session.getAttribute("sign-in-user").toString());
		Long employeeId = (Long) session.getAttribute("sign-in-userId");
		toDoList.setEmployeeId(employeeId);
		toDoListService.saveToDoListt(toDoList);

		JsonResponse resp = new JsonResponse();
		resp.setMessage("toDoList Updated Successfully");
		resp.setStatus("True");
		return resp;
	}

	@RequestMapping(value = "/delete-todo-list", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse deleteProject(Long Id) {
		toDoListService.deleteToDiList(Id);
		JsonResponse resp = new JsonResponse();
		resp.setMessage("toDoList Deleted Successfully");
		resp.setStatus("True");
		return resp;
	}
}

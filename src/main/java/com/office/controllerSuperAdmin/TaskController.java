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

import com.office.modelSuperAdmin.Task;
import com.office.serviceSuperAdmin.TaskService;
import com.office.webResponse.JsonResponse;
import com.office.webResponse.TaskResponse;

@Controller
public class TaskController {

	@Autowired
	TaskService taskService;

	@RequestMapping("/manage-task")
	public String fetchBookProjects(Model model, HttpSession session) {
		if (session.getAttribute("sign-in-user") != null) {
			return "admin/manage-task";
		}
		return "redirect:/sign-in";

	}
	
	@RequestMapping(value = "/fetch-all-task-list-by-emp-id", method = RequestMethod.GET)
	@ResponseBody
	public List<TaskResponse> getTaskListByEmployeeId(HttpSession session) {
		Long employeeId = (long) session.getAttribute("sign-in-userId");
		return taskService.getAllTasksByEmployeeId(employeeId);
	}

	@RequestMapping(value = "/save-task", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse saveTask(Task task, HttpSession session) {
		// Project.setUpdatedName(session.getAttribute("sign-in-user").toString());
		taskService.saveTask(task);
		JsonResponse resp = new JsonResponse();
		resp.setMessage("Task Inserted Successfully");
		resp.setStatus("True");
		return resp;
	}

	@RequestMapping("/get-task")
	@ResponseBody
	public Optional<Task> getTask(Long id) {
		return taskService.getTask(id);

	}

	@RequestMapping(value = "/update-task", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse updateTask(Task task, HttpSession session) {
		// Project.setUpdatedName(session.getAttribute("sign-in-user").toString());
		
		taskService.saveTask(task);
		JsonResponse resp = new JsonResponse();
		resp.setMessage("Task Updated Successfully");
		resp.setStatus("True");
		return resp;
	}

	@RequestMapping(value = "/delete-task", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse deleteTask(Long Id) {
		taskService.deleteTask(Id);
		JsonResponse resp = new JsonResponse();
		resp.setMessage("Task Deleted Successfully");
		resp.setStatus("True");
		return resp;
	}
	
}

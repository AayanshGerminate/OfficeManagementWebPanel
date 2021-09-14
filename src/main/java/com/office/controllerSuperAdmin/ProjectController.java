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

import com.office.modelSuperAdmin.Project;
import com.office.serviceSuperAdmin.ProjectService;
import com.office.webResponse.JsonResponse;

@Controller
public class ProjectController {

	@Autowired
	ProjectService projectService;

	@RequestMapping("/admin/manage-project")
	public String fetchBookProjects(Model model, HttpSession session) {
		if (session.getAttribute("sign-in-user") != null) {
			return "admin/manage-project";
		}
		return "redirect:/admin/sign-in";

	}

	@RequestMapping(value = "/fetch-all-project-list", method = RequestMethod.GET)
	@ResponseBody
	public List<Project> ProjectList() {
		return projectService.getAllProject();
	}

	@RequestMapping(value = "/save-project", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse saveProject(Project Project, HttpSession session) {
		// Project.setUpdatedName(session.getAttribute("sign-in-user").toString());
		projectService.saveProject(Project);
		JsonResponse resp = new JsonResponse();

		resp.setMessage("Project Inserted Successfully");
		resp.setStatus("True");
		return resp;
	}

	@RequestMapping("/get-project")
	@ResponseBody
	public Optional<Project> getProject(Long Id) {
		return projectService.getProject(Id);

	}

	@RequestMapping(value = "/update-project", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse updateProject(Project project, HttpSession session) {
		// Project.setUpdatedName(session.getAttribute("sign-in-user").toString());
		
		projectService.saveProject(project);

		JsonResponse resp = new JsonResponse();
		resp.setMessage("Project Updated Successfully");
		resp.setStatus("True");
		return resp;
	}

	@RequestMapping(value = "/delete-project", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse deleteProject(Long Id) {
		projectService.deleteProject(Id);
		JsonResponse resp = new JsonResponse();
		resp.setMessage("Project Deleted Successfully");
		resp.setStatus("True");
		return resp;
	}

//	@RequestMapping(value = "/fetch-all-book-Projects", method = RequestMethod.GET)
//	@ResponseBody
//	public List<BookProjectResponse> allProjectList() {
//		return ProjectService.findAllProjects();
//	}

}

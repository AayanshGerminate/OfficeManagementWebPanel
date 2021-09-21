package com.office.controllerSuperAdmin;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.office.serviceSuperAdmin.AdminService;

@Controller
//@RequestMapping(value = "/admin")
public class AdminApplicationController {
	String adminProfileDirectotry = System.getProperty("user.dir") + "/uploads/adminProfile/";

	@Autowired
	private AdminService adminService;
//
//	@RequestMapping("/dashboard")
//	public String dashboard(Model model, HttpSession session) {
//		if (session.getAttribute("sign-in-user") != null) {
////			Long societyCount = societyService.getSocietyCount();
////			Long flatCount = flatMasterService.getFlatCount();
////			Long vendorCount = vendorService.getVendorCount();
////			model.addAttribute("societyCount", societyCount);
////			model.addAttribute("flatCount", flatCount);
////			model.addAttribute("vendorCount", vendorCount);
////				model.addAttribute("flatCount", String.format("%05d", flatCount));
//
//			return "admin/index";
//		}
//		return "redirect:/sign-in";
//
//	}
	

//	@RequestMapping("/logout")
//	public String logout(HttpSession session) {
//		session.setAttribute("sign-in-user", null);
//		session.invalidate();
//		return "redirect:/sign-in";
//
//	}

//	@RequestMapping("/sign-in")
//	public String admin() {
//		return "admin/sign-in";
//	}
//
//	@RequestMapping("/do-admin-sign-in")
//	public String doSignIn(RedirectAttributes redireAttributes, HttpServletRequest request, HttpSession session,
//			@RequestParam("email") String email, @RequestParam("password") String password) {
//		Admin user = adminService.validateAdmin(email, password);
//
//		if (user != null) {
//			if (user.getStatus().equals("Active")) {
//				session.setAttribute("sign-in-user", user.getName());
//				session.setAttribute("sign-in-userId", user.getId());
//				session.setAttribute("sign-in-userEmail", user.getEmail());
//				session.setAttribute("admin-id", user.getId());
//
//				session.setAttribute("profileImage1", user.getProfileImage());
//
//				return "redirect:/admin/dashboard";
//			} else {
//				redireAttributes.addFlashAttribute("message", "Account Inactive");
//				return "redirect:/sign-in";
//			}
//		}
//
//		redireAttributes.addFlashAttribute("message", "Invalid Credintials");
//		return "redirect:/sign-in";
//
//	}

	@RequestMapping("/uploads/adminProfile/{profileImage}")
	public String getProfileImage(@PathVariable("profileImage") String profileImage, HttpServletResponse response) {
		try {
			byte b[] = Files.readAllBytes(Paths.get(adminProfileDirectotry + profileImage));
			response.setContentLength(b.length);
			response.setContentType("image/jpg");
			ServletOutputStream os = response.getOutputStream();
			os.write(b);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

//	@RequestMapping("/manage-admin-profile")
//	public String manageAdminProfile(HttpSession session, Model model) {
//
//		if (session.getAttribute("sign-in-userEmail") != null) {
//			File f = new File(adminProfileDirectotry);
//			if (!f.exists()) {
//				f.mkdirs();
//			}
//
//			String username = session.getAttribute("sign-in-userEmail").toString();
//			Admin user = adminService.getByEmail(username);
//
//			model.addAttribute("name", user.getName());
//			model.addAttribute("email", user.getEmail());
//			// model.addAttribute("mobile", user.get);
//			model.addAttribute("profileImage", user.getProfileImage());
//			model.addAttribute("id", user.getId());
//
//			return "admin/manage-admin-profile";
//		}
//		return "redirect:/sign-in";
//
//	}
//
//	@RequestMapping("/manage-admin-password")
//	public String changeAdminPassword() {
//
//		return "admin/manage-admin-password";
//	}
//
//	@RequestMapping("/change-admin-password")
//	@ResponseBody
//	public JsonResponse changeAdminPassword(Model model, HttpSession session, @RequestParam("newPass") String newPass) {
//
//		String username = (String) session.getAttribute("sign-in-userEmail");
//		JsonResponse resp = new JsonResponse();
//
//		if (!username.equals(null)) {
//			Admin user = adminService.getByEmail(username);
//			user.setPassword(newPass);
//
//			adminService.saveAdmin(user);
//
//			resp.setStatus("True");
//		} else {
//			resp.setStatus("False");
//		}
//
//		return resp;
//	}
//
//	@RequestMapping(value = "/check-old-password", method = RequestMethod.POST)
//	@ResponseBody
//	public JsonResponse changePassword(String oldPass, Model model, HttpSession session) {
//		String username = (String) session.getAttribute("sign-in-userEmail");
//		Boolean isExist = adminService.checkUserByEmailAndPasword(username, oldPass);
//
//		JsonResponse jsonResponse = new JsonResponse();
//
//		if (isExist) {
////			User user = userService.findByUserNameAndPassword(username, oldPass);
////			System.out.println(user.getUserName());
////			System.out.println(user.getPassword());
//
//			jsonResponse.setMessage("Old password exist");
//			jsonResponse.setStatus("True");
//		} else {
//			jsonResponse.setMessage("Please enter valid old Password");
//			jsonResponse.setStatus("False");
//		}
//
//		return jsonResponse;
//
//	}
//
//	@RequestMapping(value = "/update-admin-profile", method = RequestMethod.POST)
//	@ResponseBody
//	public JsonResponse updateAdminProfile(Admin user, BindingResult bindingResult,
//			@RequestParam("profileImage") MultipartFile profileImage, HttpSession session) {
//
//		Admin user1 = adminService.getById(user.getId());
//
//		if (!profileImage.isEmpty() && profileImage != null) {
//			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
//			String originalFileName = dateName + "-"
//					+ profileImage.getOriginalFilename().replace(" ", "-").toLowerCase();
//			Path fileNameAndPath = Paths.get(adminProfileDirectotry, originalFileName);
//			try {
//				Files.write(fileNameAndPath, profileImage.getBytes());
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//
//			user1.setProfileImage(originalFileName);
//			user1.setName(user.getName());
//		} else {
//			user1.setName(user.getName());
//		}
//
//		JsonResponse resp = new JsonResponse();
//		adminService.saveAdmin(user1);
//
//		Long id = user1.getId();
//		Admin admin = adminService.getById(id);
//		session.setAttribute("profileImage1", admin.getProfileImage());
//
//		resp.setMessage("profileImage inserted");
//		resp.setStatus("True");
//		return resp;
//	}
}

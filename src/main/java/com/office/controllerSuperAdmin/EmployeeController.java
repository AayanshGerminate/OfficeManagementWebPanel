package com.office.controllerSuperAdmin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.office.modelSuperAdmin.Admin;
import com.office.modelSuperAdmin.Employee;
import com.office.serviceSuperAdmin.EmployeeService;
import com.office.serviceSuperAdmin.ToDoListService;
import com.office.webResponse.JsonResponse;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	ToDoListService toDoListService;
	

	String profileImageDirectory = System.getProperty("user.dir") + "/uploads/employee/profileImage/";

	String offerLetterDirectory = System.getProperty("user.dir") + "/uploads/employee/offerLetter/";
	String appointmentLetterDirectory = System.getProperty("user.dir") + "/uploads/employee/appointmentLetter/";
	String promotionLetterDirectory = System.getProperty("user.dir") + "/uploads/employee/promotionLetter/";
	String ndaLetterDirectory = System.getProperty("user.dir") + "/uploads/employee/ndaLetter/";
	String terminationLetterDirectory = System.getProperty("user.dir") + "/uploads/employee/terminationLetter/";
	String backGroundVerificationLetterDirectory = System.getProperty("user.dir")
			+ "/uploads/employee/backGroundVerificationLetter/";
	String sscCertificateDirectory = System.getProperty("user.dir") + "/uploads/employee/sscCertificate/";
	String hscCertificateDirectory = System.getProperty("user.dir") + "/uploads/employee/hscCertificate/";

	String graduationCertificateDirectory = System.getProperty("user.dir") + "/uploads/employee/graduationCertificate/";
	String postGraduationCertificateDirectory = System.getProperty("user.dir")
			+ "/uploads/employee/postGraduationCertificate/";
	String panCardDirectory = System.getProperty("user.dir") + "/uploads/employee/panCard/";
	String adharCardDirectory = System.getProperty("user.dir") + "/uploads/employee/adharCard/";
	String passportDirectory = System.getProperty("user.dir") + "/uploads/employee/passport/";
	
	

	@RequestMapping("/manage-employee")
	public String fetchBookProjects(Model model, HttpSession session) {
		if (session.getAttribute("sign-in-user") != null) {

			File f = new File(profileImageDirectory);
			if (!f.exists()) {
				f.mkdirs();
			}

			File f1 = new File(offerLetterDirectory);
			if (!f1.exists()) {
				f1.mkdirs();
			}

			File f2 = new File(appointmentLetterDirectory);
			if (!f2.exists()) {
				f2.mkdirs();
			}

			File f3 = new File(promotionLetterDirectory);
			if (!f3.exists()) {
				f3.mkdirs();
			}

			File f4 = new File(ndaLetterDirectory);
			if (!f4.exists()) {
				f4.mkdirs();
			}

			File f5 = new File(terminationLetterDirectory);
			if (!f5.exists()) {
				f5.mkdirs();
			}

			File f6 = new File(backGroundVerificationLetterDirectory);
			if (!f6.exists()) {
				f6.mkdirs();
			}

			File f7 = new File(sscCertificateDirectory);
			if (!f7.exists()) {
				f7.mkdirs();
			}

			File f8 = new File(hscCertificateDirectory);
			if (!f8.exists()) {
				f8.mkdirs();
			}

			File f9 = new File(graduationCertificateDirectory);
			if (!f9.exists()) {
				f9.mkdirs();
			}

			File f10 = new File(postGraduationCertificateDirectory);
			if (!f10.exists()) {
				f10.mkdirs();
			}

			File f11 = new File(panCardDirectory);
			if (!f11.exists()) {
				f11.mkdirs();
			}

			File f12 = new File(adharCardDirectory);
			if (!f12.exists()) {
				f12.mkdirs();
			}

			File f13 = new File(passportDirectory);
			if (!f13.exists()) {
				f13.mkdirs();
			}
			return "admin/manage-employee";

		}
		return "redirect:/sign-in";

	}

	@RequestMapping(value = "/fetch-all-employee-list", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> employeeList() {
		return employeeService.getEmployeeList();

	}

	@RequestMapping(value = "/save-employee", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse saveEmployee( @RequestParam("profileImage") MultipartFile profileImage,Employee employee,BindingResult bindingResult,
			@RequestParam("offerLetter") MultipartFile offerLetter,
			@RequestParam("appointmentLetter") MultipartFile appointmentLetter,
			@RequestParam("promotionLetter") MultipartFile promotionLetter,
			@RequestParam("ndaLetter") MultipartFile ndaLetter,
			@RequestParam("terminationLetter") MultipartFile terminationLetter,
			@RequestParam("backGroundVerificationLetter") MultipartFile backGroundVerificationLetter,
			@RequestParam("sscCertificate") MultipartFile sscCertificate,
			@RequestParam("hscCertificate") MultipartFile hscCertificate,
			@RequestParam("graduationCertificate") MultipartFile graduationCertificate,

			@RequestParam("postGraduationCertificate") MultipartFile postGraduationCertificate,
			@RequestParam("panCard") MultipartFile panCard, @RequestParam("adharCard") MultipartFile adharCard,
			@RequestParam("passport") MultipartFile passport,

			HttpSession session) {

		
		System.out.println(profileImage.getOriginalFilename());
		if (!profileImage.isEmpty() && profileImage!=null) {
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-"
					+ profileImage.getOriginalFilename().replace(" ", "-").toLowerCase();
			Path fileNameAndPath = Paths.get(profileImageDirectory, originalFileName);
			try {
				Files.write(fileNameAndPath, profileImage.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			employee.setProfileImage(originalFileName);
		} else {
			employee.setProfileImage("");
		}

		if (!offerLetter.isEmpty()) {
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-"
					+ offerLetter.getOriginalFilename().replace(" ", "-").toLowerCase();
			Path fileNameAndPath = Paths.get(offerLetterDirectory, originalFileName);
			try {
				Files.write(fileNameAndPath, offerLetter.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			employee.setOfferLetter(originalFileName);
		} else {
			employee.setOfferLetter("");
		}

		if (!appointmentLetter.isEmpty()) {
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-"
					+ appointmentLetter.getOriginalFilename().replace(" ", "-").toLowerCase();
			Path fileNameAndPath = Paths.get(appointmentLetterDirectory, originalFileName);
			try {
				Files.write(fileNameAndPath, appointmentLetter.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			employee.setAppointmentLetter(originalFileName);
		} else {
			employee.setAppointmentLetter("");
		}

		if (!promotionLetter.isEmpty()) {
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-"
					+ promotionLetter.getOriginalFilename().replace(" ", "-").toLowerCase();
			Path fileNameAndPath = Paths.get(promotionLetterDirectory, originalFileName);
			try {
				Files.write(fileNameAndPath, promotionLetter.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			employee.setPromotionLetter(originalFileName);
		} else {
			employee.setPromotionLetter("");
		}

		if (!ndaLetter.isEmpty()) {
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-" + ndaLetter.getOriginalFilename().replace(" ", "-").toLowerCase();
			Path fileNameAndPath = Paths.get(ndaLetterDirectory, originalFileName);
			try {
				Files.write(fileNameAndPath, ndaLetter.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			employee.setNdaLetter(originalFileName);
		} else {
			employee.setNdaLetter("");
		}

		if (!terminationLetter.isEmpty()) {
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-"
					+ terminationLetter.getOriginalFilename().replace(" ", "-").toLowerCase();
			Path fileNameAndPath = Paths.get(terminationLetterDirectory, originalFileName);
			try {
				Files.write(fileNameAndPath, terminationLetter.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			employee.setTerminationLetter(originalFileName);
		} else {
			employee.setTerminationLetter("");
		}

		if (!backGroundVerificationLetter.isEmpty()) {
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-"
					+ backGroundVerificationLetter.getOriginalFilename().replace(" ", "-").toLowerCase();
			Path fileNameAndPath = Paths.get(backGroundVerificationLetterDirectory, originalFileName);
			try {
				Files.write(fileNameAndPath, backGroundVerificationLetter.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			employee.setBackGroundVerificationLetter(originalFileName);
		} else {
			employee.setBackGroundVerificationLetter("");
		}

		if (!sscCertificate.isEmpty()) {
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-"
					+ sscCertificate.getOriginalFilename().replace(" ", "-").toLowerCase();
			Path fileNameAndPath = Paths.get(sscCertificateDirectory, originalFileName);
			try {
				Files.write(fileNameAndPath, sscCertificate.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			employee.setSscCertificate(originalFileName);
		} else {
			employee.setSscCertificate("");
		}

		if (!hscCertificate.isEmpty()) {
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-"
					+ hscCertificate.getOriginalFilename().replace(" ", "-").toLowerCase();
			Path fileNameAndPath = Paths.get(hscCertificateDirectory, originalFileName);
			try {
				Files.write(fileNameAndPath, hscCertificate.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			employee.setHscCertificate(originalFileName);
		} else {
			employee.setHscCertificate("");
		}

		if (!graduationCertificate.isEmpty()) {
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-"
					+ graduationCertificate.getOriginalFilename().replace(" ", "-").toLowerCase();
			Path fileNameAndPath = Paths.get(graduationCertificateDirectory, originalFileName);
			try {
				Files.write(fileNameAndPath, graduationCertificate.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			employee.setGraduationCertificate(originalFileName);
		} else {
			employee.setGraduationCertificate("");
		}

		if (!postGraduationCertificate.isEmpty()) {
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-"
					+ postGraduationCertificate.getOriginalFilename().replace(" ", "-").toLowerCase();
			Path fileNameAndPath = Paths.get(postGraduationCertificateDirectory, originalFileName);
			try {
				Files.write(fileNameAndPath, postGraduationCertificate.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			employee.setPostGraduationCertificate(originalFileName);
		} else {
			employee.setPostGraduationCertificate("");
		}

		if (!postGraduationCertificate.isEmpty()) {
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-"
					+ postGraduationCertificate.getOriginalFilename().replace(" ", "-").toLowerCase();
			Path fileNameAndPath = Paths.get(postGraduationCertificateDirectory, originalFileName);
			try {
				Files.write(fileNameAndPath, postGraduationCertificate.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			employee.setPostGraduationCertificate(originalFileName);
		} else {
			employee.setPostGraduationCertificate("");
		}

		if (!panCard.isEmpty()) {
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-" + panCard.getOriginalFilename().replace(" ", "-").toLowerCase();
			Path fileNameAndPath = Paths.get(panCardDirectory, originalFileName);
			try {
				Files.write(fileNameAndPath, panCard.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			employee.setPanCard(originalFileName);
		} else {
			employee.setPanCard("");
		}

		if (!adharCard.isEmpty()) {
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-" + adharCard.getOriginalFilename().replace(" ", "-").toLowerCase();
			Path fileNameAndPath = Paths.get(adharCardDirectory, originalFileName);
			try {
				Files.write(fileNameAndPath, adharCard.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			employee.setAdharCard(originalFileName);
		} else {
			employee.setAdharCard("");
		}

		if (!passport.isEmpty()) {
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-" + passport.getOriginalFilename().replace(" ", "-").toLowerCase();
			Path fileNameAndPath = Paths.get(passportDirectory, originalFileName);
			try {
				Files.write(fileNameAndPath, passport.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			employee.setPassport(originalFileName);
		} else {
			employee.setPassport("");
		}

		// Project.setUpdatedName(session.getAttribute("sign-in-user").toString());
		employeeService.saveEmployee(employee);
		JsonResponse resp = new JsonResponse();

		resp.setMessage("Employee Inserted Successfully");
		resp.setStatus("True");
		return resp;
	}

	@RequestMapping("/get-employee")
	@ResponseBody
	public Employee getEmployee(Long Id) {
		System.out.println(employeeService.getEmployee(Id));

		return employeeService.getEmployee(Id);

	}

	@RequestMapping(value = "/update-employee", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse updateEmployee( @RequestParam("profileImage") MultipartFile profileImage,Employee employee,BindingResult bindingResult,
			@RequestParam("offerLetter") MultipartFile offerLetter,
			@RequestParam("appointmentLetter") MultipartFile appointmentLetter,
			@RequestParam("promotionLetter") MultipartFile promotionLetter,
			@RequestParam("ndaLetter") MultipartFile ndaLetter,
			@RequestParam("terminationLetter") MultipartFile terminationLetter,
			@RequestParam("backGroundVerificationLetter") MultipartFile backGroundVerificationLetter,
			@RequestParam("sscCertificate") MultipartFile sscCertificate,
			@RequestParam("hscCertificate") MultipartFile hscCertificate,
			@RequestParam("graduationCertificate") MultipartFile graduationCertificate,

			@RequestParam("postGraduationCertificate") MultipartFile postGraduationCertificate,
			@RequestParam("panCard") MultipartFile panCard, @RequestParam("adharCard") MultipartFile adharCard,
			@RequestParam("passport") MultipartFile passport,
 HttpSession session) {
		
		Employee getEmployee=employeeService.getEmployee(employee.getId());
		
		
		// Project.setUpdatedName(session.getAttribute("sign-in-user").toString());
		if (!profileImage.isEmpty() && profileImage!=null) {
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-"
					+ profileImage.getOriginalFilename().replace(" ", "-").toLowerCase();
			Path fileNameAndPath = Paths.get(profileImageDirectory, originalFileName);
			try {
				Files.write(fileNameAndPath, profileImage.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			employee.setProfileImage(originalFileName);
		} else {
			employee.setProfileImage(getEmployee.getProfileImage());
		}

		if (!offerLetter.isEmpty()) {
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-"
					+ offerLetter.getOriginalFilename().replace(" ", "-").toLowerCase();
			Path fileNameAndPath = Paths.get(offerLetterDirectory, originalFileName);
			try {
				Files.write(fileNameAndPath, offerLetter.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			employee.setOfferLetter(originalFileName);
		} else {
			employee.setOfferLetter(getEmployee.getOfferLetter());
		}

		if (!appointmentLetter.isEmpty()) {
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-"
					+ appointmentLetter.getOriginalFilename().replace(" ", "-").toLowerCase();
			Path fileNameAndPath = Paths.get(appointmentLetterDirectory, originalFileName);
			try {
				Files.write(fileNameAndPath, appointmentLetter.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			employee.setAppointmentLetter(originalFileName);
		} else {
			employee.setAppointmentLetter(getEmployee.getAppointmentLetter());
		}

		if (!promotionLetter.isEmpty()) {
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-"
					+ promotionLetter.getOriginalFilename().replace(" ", "-").toLowerCase();
			Path fileNameAndPath = Paths.get(promotionLetterDirectory, originalFileName);
			try {
				Files.write(fileNameAndPath, promotionLetter.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			employee.setPromotionLetter(originalFileName);
		} else {
			employee.setPromotionLetter(getEmployee.getPromotionLetter());
		}

		if (!ndaLetter.isEmpty()) {
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-" + ndaLetter.getOriginalFilename().replace(" ", "-").toLowerCase();
			Path fileNameAndPath = Paths.get(ndaLetterDirectory, originalFileName);
			try {
				Files.write(fileNameAndPath, ndaLetter.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			employee.setNdaLetter(originalFileName);
		} else {
			employee.setNdaLetter(getEmployee.getNdaLetter());
		}

		if (!terminationLetter.isEmpty()) {
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-"
					+ terminationLetter.getOriginalFilename().replace(" ", "-").toLowerCase();
			Path fileNameAndPath = Paths.get(terminationLetterDirectory, originalFileName);
			try {
				Files.write(fileNameAndPath, terminationLetter.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			employee.setTerminationLetter(originalFileName);
		} else {
			employee.setTerminationLetter(getEmployee.getTerminationLetter());
		}

		if (!backGroundVerificationLetter.isEmpty()) {
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-"
					+ backGroundVerificationLetter.getOriginalFilename().replace(" ", "-").toLowerCase();
			Path fileNameAndPath = Paths.get(backGroundVerificationLetterDirectory, originalFileName);
			try {
				Files.write(fileNameAndPath, backGroundVerificationLetter.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			employee.setBackGroundVerificationLetter(originalFileName);
		} else {
			employee.setBackGroundVerificationLetter(getEmployee.getBackGroundVerificationLetter());
		}

		if (!sscCertificate.isEmpty()) {
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-"
					+ sscCertificate.getOriginalFilename().replace(" ", "-").toLowerCase();
			Path fileNameAndPath = Paths.get(sscCertificateDirectory, originalFileName);
			try {
				Files.write(fileNameAndPath, sscCertificate.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			employee.setSscCertificate(originalFileName);
		} else {
			employee.setSscCertificate(getEmployee.getSscCertificate());
		}

		if (!hscCertificate.isEmpty()) {
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-"
					+ hscCertificate.getOriginalFilename().replace(" ", "-").toLowerCase();
			Path fileNameAndPath = Paths.get(hscCertificateDirectory, originalFileName);
			try {
				Files.write(fileNameAndPath, hscCertificate.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			employee.setHscCertificate(originalFileName);
		} else {
			employee.setHscCertificate(getEmployee.getHscCertificate());
		}

		if (!graduationCertificate.isEmpty()) {
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-"
					+ graduationCertificate.getOriginalFilename().replace(" ", "-").toLowerCase();
			Path fileNameAndPath = Paths.get(graduationCertificateDirectory, originalFileName);
			try {
				Files.write(fileNameAndPath, graduationCertificate.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			employee.setGraduationCertificate(originalFileName);
		} else {
			employee.setGraduationCertificate(getEmployee.getGraduationCertificate());
		}

		if (!postGraduationCertificate.isEmpty()) {
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-"
					+ postGraduationCertificate.getOriginalFilename().replace(" ", "-").toLowerCase();
			Path fileNameAndPath = Paths.get(postGraduationCertificateDirectory, originalFileName);
			try {
				Files.write(fileNameAndPath, postGraduationCertificate.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			employee.setPostGraduationCertificate(originalFileName);
		} else {
			employee.setPostGraduationCertificate(getEmployee.getPostGraduationCertificate());
		}

		

		if (!panCard.isEmpty()) {
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-" + panCard.getOriginalFilename().replace(" ", "-").toLowerCase();
			Path fileNameAndPath = Paths.get(panCardDirectory, originalFileName);
			try {
				Files.write(fileNameAndPath, panCard.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			employee.setPanCard(originalFileName);
		} else {
			employee.setPanCard(getEmployee.getPanCard());
		}

		if (!adharCard.isEmpty()) {
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-" + adharCard.getOriginalFilename().replace(" ", "-").toLowerCase();
			Path fileNameAndPath = Paths.get(adharCardDirectory, originalFileName);
			try {
				Files.write(fileNameAndPath, adharCard.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			employee.setAdharCard(originalFileName);
		} else {
			employee.setAdharCard(getEmployee.getAdharCard());
		}

		if (!passport.isEmpty()) {
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-" + passport.getOriginalFilename().replace(" ", "-").toLowerCase();
			Path fileNameAndPath = Paths.get(passportDirectory, originalFileName);
			try {
				Files.write(fileNameAndPath, passport.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			employee.setPassport(originalFileName);
		} else {
			employee.setPassport(getEmployee.getPassport());
		}
		
		
		employeeService.saveEmployee(employee);

		JsonResponse resp = new JsonResponse();
		resp.setMessage("Employee Updated Successfully");
		resp.setStatus("True");
		return resp;
	}

	@RequestMapping(value = "/delete-employee", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse deleteEmployee(Long Id) {
		employeeService.deleteEmployee(Id);
		JsonResponse resp = new JsonResponse();
		resp.setMessage("Employee Deleted Successfully");
		resp.setStatus("True");
		return resp;
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model, HttpSession session) {
		if (session.getAttribute("sign-in-user") != null) {
//			Long societyCount = societyService.getSocietyCount();
//			Long flatCount = flatMasterService.getFlatCount();
//			Long vendorCount = vendorService.getVendorCount();
//			model.addAttribute("societyCount", societyCount);
//			model.addAttribute("flatCount", flatCount);
//			model.addAttribute("vendorCount", vendorCount);
//				model.addAttribute("flatCount", String.format("%05d", flatCount));
			
			

			return "admin/index";
		}
		return "redirect:/sign-in";

	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("sign-in-user", null);
		session.invalidate();
		return "redirect:/sign-in";

	}

	@RequestMapping("/sign-in")
	public String admin() {
		return "admin/sign-in";
	}

	@RequestMapping("/do-sign-in")
	public String doSignIn(RedirectAttributes redireAttributes, HttpServletRequest request, HttpSession session,
			@RequestParam("email") String email, @RequestParam("password") String password) {
		Employee user = employeeService.validateAdmin(email, password);

		if (user != null) {
			if (user.getStatus().equals("Active")) {
				session.setAttribute("sign-in-user", user.getName());
				session.setAttribute("sign-in-userId", user.getId());
				session.setAttribute("sign-in-userEmail", user.getEmail());
				session.setAttribute("admin-id", user.getId());

				session.setAttribute("profileImage1", user.getProfileImage());

				return "redirect:/dashboard";
			} else {
				redireAttributes.addFlashAttribute("message", "Account Inactive");
				return "redirect:/sign-in";
			}
		}

		redireAttributes.addFlashAttribute("message", "Invalid Credintials");
		return "redirect:/sign-in";

	}

//	@RequestMapping("/uploads/adminProfile/{profileImage}")
//	public String getProfileImage(@PathVariable("profileImage") String profileImage, HttpServletResponse response) {
//		try {
//			byte b[] = Files.readAllBytes(Paths.get(profileImageDirectory + profileImage));
//			response.setContentLength(b.length);
//			response.setContentType("image/jpg");
//			ServletOutputStream os = response.getOutputStream();
//			os.write(b);
//			os.flush();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

	@RequestMapping("/manage-employee-profile")
	public String manageAdminProfile(HttpSession session, Model model) {

		if (session.getAttribute("sign-in-userEmail") != null) {
			File f = new File(profileImageDirectory);
			if (!f.exists()) {
				f.mkdirs();
			}

			String username = session.getAttribute("sign-in-userEmail").toString();
			Employee user = employeeService.getByEmail(username);

			model.addAttribute("name", user.getName());
			model.addAttribute("email", user.getEmail());
			// model.addAttribute("mobile", user.get);
			model.addAttribute("profileImage", user.getProfileImage());
			model.addAttribute("id", user.getId());

			return "admin/manage-admin-profile";
		}
		return "redirect:/sign-in";

	}

	@RequestMapping("/manage-admin-password")
	public String changeAdminPassword() {

		return "admin/manage-admin-password";
	}

	@RequestMapping("/change-admin-password")
	@ResponseBody
	public JsonResponse changeAdminPassword(Model model, HttpSession session, @RequestParam("newPass") String newPass) {

		String username = (String) session.getAttribute("sign-in-userEmail");
		JsonResponse resp = new JsonResponse();

		if (!username.equals(null)) {
			Employee user = employeeService.getByEmail(username);
			user.setPassword(newPass);

			employeeService.saveEmployee(user);

			resp.setStatus("True");
		} else {
			resp.setStatus("False");
		}

		return resp;
	}

	@RequestMapping(value = "/check-old-password", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse changePassword(String oldPass, Model model, HttpSession session) {
		String username = (String) session.getAttribute("sign-in-userEmail");
		Boolean isExist = employeeService.checkUserByEmailAndPasword(username, oldPass);

		JsonResponse jsonResponse = new JsonResponse();

		if (isExist) {
//			User user = userService.findByUserNameAndPassword(username, oldPass);
//			System.out.println(user.getUserName());
//			System.out.println(user.getPassword());

			jsonResponse.setMessage("Old password exist");
			jsonResponse.setStatus("True");
		} else {
			jsonResponse.setMessage("Please enter valid old Password");
			jsonResponse.setStatus("False");
		}

		return jsonResponse;

	}

	@RequestMapping(value = "/update-profile", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse updateAdminProfile(Admin user, BindingResult bindingResult,
			@RequestParam("profileImage") MultipartFile profileImage, HttpSession session) {

		Employee user1 = employeeService.getById(user.getId());

		if (!profileImage.isEmpty() && profileImage != null) {
			String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			String originalFileName = dateName + "-"
					+ profileImage.getOriginalFilename().replace(" ", "-").toLowerCase();
			Path fileNameAndPath = Paths.get(profileImageDirectory, originalFileName);
			try {
				Files.write(fileNameAndPath, profileImage.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}

			user1.setProfileImage(originalFileName);
			user1.setName(user.getName());
		} else {
			user1.setName(user.getName());
		}

		JsonResponse resp = new JsonResponse();
		employeeService.saveEmployee(user1);

		Long id = user1.getId();
		Employee admin = employeeService.getById(id);
		session.setAttribute("profileImage1", admin.getProfileImage());

		resp.setMessage("profileImage inserted");
		resp.setStatus("True");
		return resp;
	}
	
	
	
	
	
	
	
	
	
	
}

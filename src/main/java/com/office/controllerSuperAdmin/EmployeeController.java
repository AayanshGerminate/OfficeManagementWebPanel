package com.office.controllerSuperAdmin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

import com.office.modelSuperAdmin.Employee;
import com.office.serviceSuperAdmin.EmployeeService;
import com.office.webResponse.JsonResponse;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

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

	@RequestMapping("/admin/manage-employee")
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
		return "redirect:/admin/sign-in";

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
		return employeeService.getEmployee(Id);

	}

	@RequestMapping(value = "/update-employee", method = RequestMethod.POST)
	@ResponseBody
	public JsonResponse updateEmployee(Employee employee, HttpSession session) {
		// Project.setUpdatedName(session.getAttribute("sign-in-user").toString());

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
}

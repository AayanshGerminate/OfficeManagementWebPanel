package com.office;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeImageReadController {

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

	@RequestMapping("/uploads/employee/profileImage/{profileImage}")
	public String getProfileImage(@PathVariable("profileImage") String profileImage, HttpServletResponse response) {
		try {
			byte b[] = Files.readAllBytes(Paths.get(profileImageDirectory + profileImage));
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

	@RequestMapping("/uploads/employee/appointmentLetter/{appointmentLetter}")
	public String getAppointmrentLetter(@PathVariable("appointmentLetter") String appointmentLetter,
			HttpServletResponse response) {
		try {
			byte b[] = Files.readAllBytes(Paths.get(appointmentLetterDirectory + appointmentLetter));
			response.setContentLength(b.length);
			response.setContentType("application/pdf");
			ServletOutputStream os = response.getOutputStream();
			os.write(b);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/uploads/employee/promotionLetter/{promotionLetter}")
	public String getPromotionLetter(@PathVariable("promotionLetter") String promotionLetter,
			HttpServletResponse response) {
		try {
			byte b[] = Files.readAllBytes(Paths.get(promotionLetterDirectory + promotionLetter));
			response.setContentLength(b.length);
			response.setContentType("application/pdf");
			ServletOutputStream os = response.getOutputStream();
			os.write(b);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/uploads/employee/offerLetter/{offerLetter}")
	public String geOfferLetter(@PathVariable("offerLetter") String offerLetter, HttpServletResponse response) {
		try {
			byte b[] = Files.readAllBytes(Paths.get(offerLetterDirectory + offerLetter));
			response.setContentLength(b.length);
			response.setContentType("application/pdf");
			ServletOutputStream os = response.getOutputStream();
			os.write(b);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/uploads/employee/ndaLetter/{ndaLetter}")
	public String getndaLetter(@PathVariable("ndaLetter") String ndaLetter, HttpServletResponse response) {
		try {
			byte b[] = Files.readAllBytes(Paths.get(ndaLetterDirectory + ndaLetter));
			response.setContentLength(b.length);
			response.setContentType("application/pdf");
			ServletOutputStream os = response.getOutputStream();
			os.write(b);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/uploads/employee/terminationLetter/{terminationLetter}")
	public String getTerminationLetterDirectory(@PathVariable("terminationLetter") String terminationLetter,
			HttpServletResponse response) {
		try {
			byte b[] = Files.readAllBytes(Paths.get(terminationLetterDirectory + terminationLetter));
			response.setContentLength(b.length);
			response.setContentType("application/pdf");
			ServletOutputStream os = response.getOutputStream();
			os.write(b);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/uploads/employee/backGroundVerificationLetter/{backGroundVerificationLetter}")
	public String getBackGroundVerificationLetter(
			@PathVariable("backGroundVerificationLetter") String backGroundVerificationLetter,
			HttpServletResponse response) {
		try {
			byte b[] = Files
					.readAllBytes(Paths.get(backGroundVerificationLetterDirectory + backGroundVerificationLetter));
			response.setContentLength(b.length);
			response.setContentType("application/pdf");
			ServletOutputStream os = response.getOutputStream();
			os.write(b);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/uploads/employee/sscCertificate/{sscCertificate}")
	public String getSscCertificateLetter(@PathVariable("sscCertificate") String sscCertificate,
			HttpServletResponse response) {
		try {
			byte b[] = Files.readAllBytes(Paths.get(sscCertificateDirectory + sscCertificate));
			response.setContentLength(b.length);
			response.setContentType("application/pdf");
			ServletOutputStream os = response.getOutputStream();
			os.write(b);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/uploads/employee/hscCertificate/{hscCertificate}")
	public String getHscCertificate(@PathVariable("hscCertificate") String hscCertificate,
			HttpServletResponse response) {
		try {
			byte b[] = Files.readAllBytes(Paths.get(hscCertificateDirectory + hscCertificate));
			response.setContentLength(b.length);
			response.setContentType("application/pdf");
			ServletOutputStream os = response.getOutputStream();
			os.write(b);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/uploads/employee/graduationCertificate/{graduationCertificate}")
	public String getGraduationCertificate(@PathVariable("graduationCertificate") String graduationCertificate,
			HttpServletResponse response) {
		try {
			byte b[] = Files.readAllBytes(Paths.get(graduationCertificateDirectory + graduationCertificate));
			response.setContentLength(b.length);
			response.setContentType("application/pdf");
			ServletOutputStream os = response.getOutputStream();
			os.write(b);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/uploads/employee/postGraduationCertificate/{postGraduationCertificate}")
	public String getPostGraduationCertificate(
			@PathVariable("postGraduationCertificate") String postGraduationCertificate, HttpServletResponse response) {
		try {
			byte b[] = Files.readAllBytes(Paths.get(postGraduationCertificateDirectory + postGraduationCertificate));
			response.setContentLength(b.length);
			response.setContentType("application/pdf");
			ServletOutputStream os = response.getOutputStream();
			os.write(b);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/uploads/employee/panCard/{panCard}")
	public String getpanCard(@PathVariable("panCard") String panCard, HttpServletResponse response) {
		try {
			byte b[] = Files.readAllBytes(Paths.get(panCardDirectory + panCard));
			response.setContentLength(b.length);
			response.setContentType("application/pdf");
			ServletOutputStream os = response.getOutputStream();
			os.write(b);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/uploads/employee/adharCard/{adharCard}")
	public String getadharCard(@PathVariable("adharCard") String adharCard, HttpServletResponse response) {
		try {
			byte b[] = Files.readAllBytes(Paths.get(adharCardDirectory + adharCard));
			response.setContentLength(b.length);
			response.setContentType("application/pdf");
			ServletOutputStream os = response.getOutputStream();
			os.write(b);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/uploads/employee/passport/{passport}")
	public String getPassport(@PathVariable("passport") String passport, HttpServletResponse response) {
		try {
			byte b[] = Files.readAllBytes(Paths.get(passportDirectory + passport));
			response.setContentLength(b.length);
			response.setContentType("application/pdf");
			ServletOutputStream os = response.getOutputStream();
			os.write(b);
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}

package com.office.controllerSuperAdmin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

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

import com.office.modelSuperAdmin.Documents;
import com.office.serviceSuperAdmin.DocumentService;
import com.office.webResponse.AppJsonResponse;
import com.office.webResponse.DocumentResponse;

@Controller
public class ManageDocument {

	@Autowired
	DocumentService documentService;

	String uploadProductDirectory = System.getProperty("user.dir") + "/uploads/documents/";

	@RequestMapping("/admin/manage-documents")
	public String fetchBookProjects(Model model, HttpSession session) {
		if (session.getAttribute("sign-in-user") != null) {

			File f = new File(uploadProductDirectory);
			if (!f.exists()) {
				f.mkdirs();
			}
			DocumentResponse document = documentService.getAllData();
			if (document != null) {

				model.addAttribute("document", document);
				return "admin/manage-documents";
			} else {
				DocumentResponse document1 = new DocumentResponse();
				document1.setId(null);
				document1.setInternOfferLetter("");
				document1.setInternProjectCompletion("");
				document1.setInternRecommendation("");
				document1.setEmployeeAppointment("");
				document1.setEmployeeAppraisal("");
				document1.setEmployeeNondisclosure("");
				document1.setEmployeeNotice("");
				document1.setEmployeeOffer("");
				document1.setEmployeePromotion("");
				document1.setEmployeeTermination("");
				document1.setEmployeeVerification("");
				document1.setLegalInvoice("");
				document1.setLegalQuotation("");
				model.addAttribute("document", document1);
				return "admin/manage-documents";
			}

		}
		return "redirect:/admin/sign-in";

	}

	@RequestMapping(value = "/save-document", method = RequestMethod.POST)
	@ResponseBody
	public AppJsonResponse saveProduct(Documents document, BindingResult bindingResult,
			@RequestParam("internOfferLetter") MultipartFile internOfferLetter,
			@RequestParam("internProjectCompletion") MultipartFile internProjectCompletion,
			@RequestParam("internRecommendation") MultipartFile internRecommendation,
			@RequestParam("employeeOffer") MultipartFile employeeOffer,
			@RequestParam("employeeAppointment") MultipartFile employeeAppointment,
			@RequestParam("employeeAppraisal") MultipartFile employeeAppraisal,
			@RequestParam("employeePromotion") MultipartFile employeePromotion,
			@RequestParam("employeeTermination") MultipartFile employeeTermination,
			@RequestParam("employeeNotice") MultipartFile employeeNotice,
			@RequestParam("employeeNondisclosure") MultipartFile employeeNondisclosure,
			@RequestParam("employeeVerification") MultipartFile employeeVerification,
			@RequestParam("legalInvoice") MultipartFile legalInvoice,
			@RequestParam("legalQuotation") MultipartFile legalQuotation, HttpSession session) throws IOException {

		Long id = document.getId();
		if (document.getId() != null) {
			if (!internOfferLetter.isEmpty() && internOfferLetter != null) {

				String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
				String originalFileName = dateName + "-"
						+ internOfferLetter.getOriginalFilename().replace(" ", "-").toLowerCase();

				Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);

				try {
					Files.write(fileNameAndPath, internOfferLetter.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}

				document.setInternOfferLetter(originalFileName);
				;
			} else {
				Documents getDocument = documentService.getDocumentById(id);
				document.setInternOfferLetter(getDocument.getInternOfferLetter());
			}

			if (!internProjectCompletion.isEmpty() && internProjectCompletion != null) {
				String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
				String originalFileName = dateName + "-"
						+ internProjectCompletion.getOriginalFilename().replace(" ", "-").toLowerCase();
				Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);
				try {
					Files.write(fileNameAndPath, internProjectCompletion.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}

				document.setInternProjectCompletion(originalFileName);
			} else {
				Documents getDocument = documentService.getDocumentById(id);
				document.setInternProjectCompletion(getDocument.getInternProjectCompletion());
			}

			if (!internRecommendation.isEmpty() && internRecommendation != null) {
				String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
				String originalFileName = dateName + "-"
						+ internRecommendation.getOriginalFilename().replace(" ", "-").toLowerCase();
				Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);
				try {
					Files.write(fileNameAndPath, internRecommendation.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}

				document.setInternRecommendation(originalFileName);
			} else {
				Documents getDocument = documentService.getDocumentById(id);
				document.setInternRecommendation(getDocument.getInternRecommendation());

			}
			if (!employeeOffer.isEmpty() && employeeOffer != null) {
				String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
				String originalFileName = dateName + "-"
						+ employeeOffer.getOriginalFilename().replace(" ", "-").toLowerCase();
				Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);
				try {
					Files.write(fileNameAndPath, employeeOffer.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}

				document.setEmployeeOffer(originalFileName);
			} else {
				Documents getDocument = documentService.getDocumentById(id);
				document.setEmployeeOffer(getDocument.getEmployeeOffer());

			}
			if (!employeeAppointment.isEmpty() && employeeAppointment != null) {
				String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
				String originalFileName = dateName + "-"
						+ employeeAppointment.getOriginalFilename().replace(" ", "-").toLowerCase();
				Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);
				try {
					Files.write(fileNameAndPath, employeeAppointment.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}

				document.setEmployeeAppointment(originalFileName);
			} else {
				Documents getDocument = documentService.getDocumentById(id);
				document.setEmployeeAppointment(getDocument.getEmployeeAppointment());

			}
			if (!employeeAppraisal.isEmpty() && employeeAppraisal != null) {
				String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
				String originalFileName = dateName + "-"
						+ employeeAppraisal.getOriginalFilename().replace(" ", "-").toLowerCase();
				Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);
				try {
					Files.write(fileNameAndPath, employeeAppraisal.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}

				document.setEmployeeAppraisal(originalFileName);
			} else {
				Documents getDocument = documentService.getDocumentById(id);
				document.setEmployeeAppraisal(getDocument.getEmployeeAppraisal());

			}
			if (!employeePromotion.isEmpty() && employeePromotion != null) {
				String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
				String originalFileName = dateName + "-"
						+ employeePromotion.getOriginalFilename().replace(" ", "-").toLowerCase();
				Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);
				try {
					Files.write(fileNameAndPath, employeePromotion.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}

				document.setEmployeePromotion(originalFileName);
			} else {
				Documents getDocument = documentService.getDocumentById(id);
				document.setEmployeePromotion(getDocument.getEmployeePromotion());

			}
			if (!employeeTermination.isEmpty() && employeeTermination != null) {
				String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
				String originalFileName = dateName + "-"
						+ employeeTermination.getOriginalFilename().replace(" ", "-").toLowerCase();
				Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);
				try {
					Files.write(fileNameAndPath, employeeTermination.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}

				document.setEmployeeTermination(originalFileName);
			} else {
				Documents getDocument = documentService.getDocumentById(id);
				document.setEmployeeTermination(getDocument.getEmployeeTermination());

			}
			if (!employeeNotice.isEmpty() && employeeNotice != null) {
				String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
				String originalFileName = dateName + "-"
						+ employeeNotice.getOriginalFilename().replace(" ", "-").toLowerCase();
				Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);
				try {
					Files.write(fileNameAndPath, employeeNotice.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}

				document.setEmployeeNotice(originalFileName);
			} else {
				Documents getDocument = documentService.getDocumentById(id);
				document.setEmployeeNotice(getDocument.getEmployeeNotice());

			}
			if (!employeeNondisclosure.isEmpty() && employeeNondisclosure != null) {
				String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
				String originalFileName = dateName + "-"
						+ employeeNondisclosure.getOriginalFilename().replace(" ", "-").toLowerCase();
				Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);
				try {
					Files.write(fileNameAndPath, employeeNondisclosure.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}

				document.setEmployeeNondisclosure(originalFileName);
			} else {
				Documents getDocument = documentService.getDocumentById(id);
				document.setEmployeeNondisclosure(getDocument.getEmployeeNondisclosure());

			}
			if (!employeeVerification.isEmpty() && employeeVerification != null) {
				String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
				String originalFileName = dateName + "-"
						+ employeeVerification.getOriginalFilename().replace(" ", "-").toLowerCase();
				Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);
				try {
					Files.write(fileNameAndPath, employeeVerification.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}

				document.setEmployeeVerification(originalFileName);
			} else {
				Documents getDocument = documentService.getDocumentById(id);
				document.setEmployeeVerification(getDocument.getEmployeeVerification());

			}
			if (!legalInvoice.isEmpty() && legalInvoice != null) {
				String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
				String originalFileName = dateName + "-"
						+ legalInvoice.getOriginalFilename().replace(" ", "-").toLowerCase();
				Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);
				try {
					Files.write(fileNameAndPath, legalInvoice.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}

				document.setLegalInvoice(originalFileName);
			} else {
				Documents getDocument = documentService.getDocumentById(id);
				document.setLegalInvoice(getDocument.getLegalInvoice());

			}
			if (!legalQuotation.isEmpty() && legalQuotation != null) {
				String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
				String originalFileName = dateName + "-"
						+ legalQuotation.getOriginalFilename().replace(" ", "-").toLowerCase();
				Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);
				try {
					Files.write(fileNameAndPath, legalQuotation.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}

				document.setLegalQuotation(originalFileName);
			} else {
				Documents getDocument = documentService.getDocumentById(id);
				document.setLegalQuotation(getDocument.getLegalQuotation());

			}
			documentService.saveDocument(document);
			AppJsonResponse resp = new AppJsonResponse();
			resp.setMessage("Document saved successfully");
			resp.setStatus("True");
			return resp;

		} else

		{
			if (!internOfferLetter.isEmpty() && internOfferLetter != null) {

				String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
				String originalFileName = dateName + "-"
						+ internOfferLetter.getOriginalFilename().replace(" ", "-").toLowerCase();

				Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);

				try {
					Files.write(fileNameAndPath, internOfferLetter.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}

				document.setInternOfferLetter(originalFileName);
				;
			} else {

				document.setInternOfferLetter("");
			}

			if (!internProjectCompletion.isEmpty() && internProjectCompletion != null) {
				String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
				String originalFileName = dateName + "-"
						+ internProjectCompletion.getOriginalFilename().replace(" ", "-").toLowerCase();
				Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);
				try {
					Files.write(fileNameAndPath, internProjectCompletion.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}

				document.setInternProjectCompletion(originalFileName);
			} else {

				document.setInternProjectCompletion("");
			}

			if (!internRecommendation.isEmpty() && internRecommendation != null) {
				String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
				String originalFileName = dateName + "-"
						+ internRecommendation.getOriginalFilename().replace(" ", "-").toLowerCase();
				Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);
				try {
					Files.write(fileNameAndPath, internRecommendation.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}

				document.setInternRecommendation(originalFileName);
			} else {
				document.setInternRecommendation("");

			}
			if (!employeeOffer.isEmpty() && employeeOffer != null) {
				String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
				String originalFileName = dateName + "-"
						+ employeeOffer.getOriginalFilename().replace(" ", "-").toLowerCase();
				Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);
				try {
					Files.write(fileNameAndPath, employeeOffer.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}

				document.setEmployeeOffer(originalFileName);
			} else {
				document.setEmployeeOffer("");

			}
			if (!employeeAppointment.isEmpty() && employeeAppointment != null) {
				String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
				String originalFileName = dateName + "-"
						+ employeeAppointment.getOriginalFilename().replace(" ", "-").toLowerCase();
				Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);
				try {
					Files.write(fileNameAndPath, employeeAppointment.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}

				document.setEmployeeAppointment(originalFileName);
			} else {
				document.setEmployeeAppointment("");

			}
			if (!employeeAppraisal.isEmpty() && employeeAppraisal != null) {
				String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
				String originalFileName = dateName + "-"
						+ employeeAppraisal.getOriginalFilename().replace(" ", "-").toLowerCase();
				Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);
				try {
					Files.write(fileNameAndPath, employeeAppraisal.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}

				document.setEmployeeAppraisal(originalFileName);
			} else {
				document.setEmployeeAppraisal("");

			}
			if (!employeePromotion.isEmpty() && employeePromotion != null) {
				String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
				String originalFileName = dateName + "-"
						+ employeePromotion.getOriginalFilename().replace(" ", "-").toLowerCase();
				Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);
				try {
					Files.write(fileNameAndPath, employeePromotion.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}

				document.setEmployeePromotion(originalFileName);
			} else {
				document.setEmployeePromotion("");

			}
			if (!employeeTermination.isEmpty() && employeeTermination != null) {
				String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
				String originalFileName = dateName + "-"
						+ employeeTermination.getOriginalFilename().replace(" ", "-").toLowerCase();
				Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);
				try {
					Files.write(fileNameAndPath, employeeTermination.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}

				document.setEmployeeTermination(originalFileName);
			} else {
				document.setEmployeeTermination("");

			}
			if (!employeeNotice.isEmpty() && employeeNotice != null) {
				String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
				String originalFileName = dateName + "-"
						+ employeeNotice.getOriginalFilename().replace(" ", "-").toLowerCase();
				Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);
				try {
					Files.write(fileNameAndPath, employeeNotice.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}

				document.setEmployeeNotice(originalFileName);
			} else {
				document.setEmployeeNotice("");

			}
			if (!employeeNondisclosure.isEmpty() && employeeNondisclosure != null) {
				String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
				String originalFileName = dateName + "-"
						+ employeeNondisclosure.getOriginalFilename().replace(" ", "-").toLowerCase();
				Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);
				try {
					Files.write(fileNameAndPath, employeeNondisclosure.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}

				document.setEmployeeNondisclosure(originalFileName);
			} else {
				document.setEmployeeNondisclosure("");

			}
			if (!employeeVerification.isEmpty() && employeeVerification != null) {
				String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
				String originalFileName = dateName + "-"
						+ employeeVerification.getOriginalFilename().replace(" ", "-").toLowerCase();
				Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);
				try {
					Files.write(fileNameAndPath, employeeVerification.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}

				document.setEmployeeVerification(originalFileName);
			} else {
				document.setEmployeeVerification("");

			}
			if (!legalInvoice.isEmpty() && legalInvoice != null) {
				String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
				String originalFileName = dateName + "-"
						+ legalInvoice.getOriginalFilename().replace(" ", "-").toLowerCase();
				Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);
				try {
					Files.write(fileNameAndPath, legalInvoice.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}

				document.setLegalInvoice(originalFileName);
			} else {
				document.setLegalInvoice("");

			}
			if (!legalQuotation.isEmpty() && legalQuotation != null) {
				String dateName = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
				String originalFileName = dateName + "-"
						+ legalQuotation.getOriginalFilename().replace(" ", "-").toLowerCase();
				Path fileNameAndPath = Paths.get(uploadProductDirectory, originalFileName);
				try {
					Files.write(fileNameAndPath, legalQuotation.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}

				document.setLegalQuotation(originalFileName);
			} else {

				document.setLegalQuotation("");

			}
		}
		documentService.saveDocument(document);
		AppJsonResponse resp = new AppJsonResponse();
		resp.setMessage("Document saved successfully");
		resp.setStatus("True");
		return resp;
	}

}

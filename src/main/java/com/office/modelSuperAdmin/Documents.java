package com.office.modelSuperAdmin;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Documents {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String internOfferLetter;
	private String internProjectCompletion;
	private String internRecommendation;
	private String employeeOffer;
	private String employeeAppointment;
	private String employeeAppraisal;
	private String employeePromotion;
	private String employeeTermination;
	private String employeeNotice;
	private String employeeNondisclosure;
	private String employeeVerification;
	private String legalInvoice;
	private String legalQuotation;


}

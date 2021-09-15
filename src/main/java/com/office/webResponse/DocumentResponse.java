package com.office.webResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DocumentResponse {

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

package com.office.repositorySuperAdmin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.office.modelSuperAdmin.Documents;
import com.office.webResponse.DocumentResponse;

@Repository
public interface DocumentRepository extends JpaRepository<Documents, Long>{

	@Query("SELECT new com.office.webResponse.DocumentResponse(id,internOfferLetter,internProjectCompletion,internRecommendation,employeeOffer,employeeAppointment,employeeAppraisal,employeePromotion,employeeTermination,employeeNotice,employeeNondisclosure,employeeVerification,legalInvoice,legalQuotation) FROM Documents")
	DocumentResponse getAllDocumentData();

	
}

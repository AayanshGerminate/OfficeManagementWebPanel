package com.office.serviceSuperAdmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.office.modelSuperAdmin.Documents;
import com.office.repositorySuperAdmin.DocumentRepository;
import com.office.webResponse.DocumentResponse;
import com.sun.xml.txw2.Document;

@Service
public class DocumentService {

	@Autowired
	DocumentRepository documentRepository;

	public void saveDocument(Documents document) {
		// TODO Auto-generated method stub
		documentRepository.save(document);
	}

	public DocumentResponse getAllData() {
		// TODO Auto-generated method stub
		return documentRepository.getAllDocumentData();
	}

	public Documents getDocumentById(Long id) {
		// TODO Auto-generated method stub
		return documentRepository.findById(id).get();
	}

	
}

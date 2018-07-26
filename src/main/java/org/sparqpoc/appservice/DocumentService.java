package org.sparqpoc.appservice;

import java.util.List;

import org.sparqpoc.appmodel.Document;
import org.sparqpoc.apprespository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {
	
	@Autowired
	DocumentRepository documentRepository;

	public List<Document> saveDocuments(List<Document> documnets) {
		
		return documentRepository.save(documnets);
	}

}

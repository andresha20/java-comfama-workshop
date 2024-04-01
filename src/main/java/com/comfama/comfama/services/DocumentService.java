package com.comfama.comfama.services;

import com.comfama.comfama.entities.Document;
import com.comfama.comfama.repositories.IDocumentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {
    private final IDocumentRepository documentRepository;

    @Autowired
    public DocumentService(IDocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    public Document createDocument(Document document) {
        return documentRepository.save(document);
    }

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    public Document getDocumentById(Long id) {
        return documentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Document not found with id: " + id));
    }

    public Document updateDocument(Document documentToUpdate) {
        Document document = getDocumentById(documentToUpdate.getDocumentId());
        document.setType(documentToUpdate.getType());
        document.setFilePath(documentToUpdate.getFilePath());
        document.setUploadTimestamp(documentToUpdate.getUploadTimestamp());
        // Update other fields as needed
        return documentRepository.save(document);
    }

    public void deleteDocument(Long id) {
        Document document = getDocumentById(id);
        documentRepository.delete(document);
    }
}
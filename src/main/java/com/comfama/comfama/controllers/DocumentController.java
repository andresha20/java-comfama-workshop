package com.comfama.comfama.controllers;

import com.comfama.comfama.dtos.DocumentDTO;
import com.comfama.comfama.entities.Document;
import com.comfama.comfama.mappers.DocumentMapper;
import com.comfama.comfama.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {
    private final DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping
    public ResponseEntity<DocumentDTO> createDocument(@RequestBody DocumentDTO documentDTO) {
        Document document = DocumentMapper.toEntity(documentDTO);
        Document createdDocument = documentService.createDocument(document);
        return ResponseEntity.ok(DocumentMapper.toDTO(createdDocument));
    }

    @GetMapping
    public ResponseEntity<List<DocumentDTO>> getAllDocuments() {
        List<DocumentDTO> documents = documentService.getAllDocuments().stream()
                .map(DocumentMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(documents);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentDTO> getDocumentById(@PathVariable Long id) {
        Document document = documentService.getDocumentById(id);
        return ResponseEntity.ok(DocumentMapper.toDTO(document));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentDTO> updateDocument(@PathVariable Long id, @RequestBody DocumentDTO documentDTO) {
        Document document = DocumentMapper.toEntity(documentDTO);
        document.setDocumentId(id); // Ensure the ID is set to the path variable
        Document updatedDocument = documentService.updateDocument(document);
        return ResponseEntity.ok(DocumentMapper.toDTO(updatedDocument));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocument(@PathVariable Long id) {
        documentService.deleteDocument(id);
        return ResponseEntity.ok().build();
    }
}

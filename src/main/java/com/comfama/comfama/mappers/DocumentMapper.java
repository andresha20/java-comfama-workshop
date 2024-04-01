package com.comfama.comfama.mappers;

import com.comfama.comfama.dtos.DocumentDTO;
import com.comfama.comfama.entities.Document;

public class DocumentMapper {
    public static DocumentDTO toDTO(Document document) {
        DocumentDTO dto = new DocumentDTO();
        dto.setDocumentId(document.getDocumentId());
        dto.setApplicationId(document.getApplication() != null ? document.getApplication().getApplicationId() : null);
        dto.setType(document.getType());
        dto.setFilePath(document.getFilePath());
        dto.setUploadTimestamp(document.getUploadTimestamp());
        return dto;
    }

    public static Document toEntity(DocumentDTO dto) {
        Document document = new Document();
        document.setDocumentId(dto.getDocumentId());
        // Skipping the setting of the Application as it requires a database entity
        document.setType(dto.getType());
        document.setFilePath(dto.getFilePath());
        document.setUploadTimestamp(dto.getUploadTimestamp());
        return document;
    }
}

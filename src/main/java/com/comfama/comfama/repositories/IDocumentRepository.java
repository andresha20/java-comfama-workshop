package com.comfama.comfama.repositories;

import com.comfama.comfama.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDocumentRepository extends JpaRepository<Document, Long> {
}

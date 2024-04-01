package com.comfama.comfama.repositories;

import com.comfama.comfama.entities.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IApplicantRepository extends JpaRepository<Applicant, Long> {
}
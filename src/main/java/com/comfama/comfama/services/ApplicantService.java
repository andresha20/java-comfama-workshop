package com.comfama.comfama.services;

import com.comfama.comfama.entities.Applicant;
import com.comfama.comfama.repositories.IApplicantRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {
    private final IApplicantRepository applicantRepository;

    @Autowired
    public ApplicantService(IApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    public Applicant createApplicant(Applicant applicant) {
        return applicantRepository.save(applicant);
    }

    public List<Applicant> getAllApplicants() {
        return applicantRepository.findAll();
    }

    public Applicant getApplicantById(Long id) {
        return applicantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Applicant not found with id: " + id));
    }

    public Applicant updateApplicant(Applicant applicantToUpdate) {
        Applicant applicant = getApplicantById(applicantToUpdate.getApplicantId());
        applicant.setName(applicantToUpdate.getName());
        applicant.setEmail(applicantToUpdate.getEmail());
        applicant.setPhone(applicantToUpdate.getPhone());
        applicant.setAffiliation(applicantToUpdate.getAffiliation());
        return applicantRepository.save(applicant);
    }

    public void deleteApplicant(Long id) {
        Applicant applicant = getApplicantById(id);
        applicantRepository.delete(applicant);
    }
}
package com.comfama.comfama.controllers;

import com.comfama.comfama.dtos.ApplicantDTO;
import com.comfama.comfama.entities.Applicant;
import com.comfama.comfama.mappers.ApplicantMapper;
import com.comfama.comfama.services.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/applicants")
public class ApplicantController {
    private final ApplicantService applicantService;

    @Autowired
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    @PostMapping
    public ResponseEntity<ApplicantDTO> createApplicant(@RequestBody ApplicantDTO applicantDTO) {
        Applicant applicant = ApplicantMapper.toEntity(applicantDTO);
        Applicant createdApplicant = applicantService.createApplicant(applicant);
        return ResponseEntity.ok(ApplicantMapper.toDTO(createdApplicant));
    }

    @GetMapping
    public ResponseEntity<List<ApplicantDTO>> getAllApplicants() {
        List<ApplicantDTO> applicants = applicantService.getAllApplicants().stream()
                .map(ApplicantMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(applicants);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplicantDTO> getApplicantById(@PathVariable Long id) {
        Applicant applicant = applicantService.getApplicantById(id);
        return ResponseEntity.ok(ApplicantMapper.toDTO(applicant));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApplicantDTO> updateApplicant(@PathVariable Long id, @RequestBody ApplicantDTO applicantDTO) {
        Applicant applicant = ApplicantMapper.toEntity(applicantDTO);
        applicant.setApplicantId(id); // Ensure the ID is set to the path variable
        Applicant updatedApplicant = applicantService.updateApplicant(applicant);
        return ResponseEntity.ok(ApplicantMapper.toDTO(updatedApplicant));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplicant(@PathVariable Long id) {
        applicantService.deleteApplicant(id);
        return ResponseEntity.ok().build();
    }
}
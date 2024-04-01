package com.comfama.comfama.mappers;

import com.comfama.comfama.dtos.ApplicantDTO;
import com.comfama.comfama.entities.Applicant;

public class ApplicantMapper {
    public static ApplicantDTO toDTO(Applicant applicant) {
        ApplicantDTO dto = new ApplicantDTO();
        dto.setApplicantId(applicant.getApplicantId());
        dto.setName(applicant.getName());
        dto.setEmail(applicant.getEmail());
        dto.setPhone(applicant.getPhone());
        dto.setAffiliation(applicant.getAffiliation());
        return dto;
    }

    public static Applicant toEntity(ApplicantDTO dto) {
        Applicant applicant = new Applicant();
        applicant.setApplicantId(dto.getApplicantId());
        applicant.setName(dto.getName());
        applicant.setEmail(dto.getEmail());
        applicant.setPhone(dto.getPhone());
        applicant.setAffiliation(dto.getAffiliation());
        return applicant;
    }
}

package com.comfama.comfama.mappers;

import com.comfama.comfama.dtos.ApplicationDTO;
import com.comfama.comfama.entities.Application;

public class ApplicationMapper {
    public static ApplicationDTO toDTO(Application application) {
        ApplicationDTO dto = new ApplicationDTO();
        dto.setApplicationId(application.getApplicationId());
        dto.setApplicantId(application.getApplicant() != null ? application.getApplicant().getApplicantId() : null);
        dto.setProjectDescription(application.getProjectDescription());
        dto.setStatus(application.getStatus());
        dto.setSubmissionDate(application.getSubmissionDate());
        return dto;
    }

    public static Application toEntity(ApplicationDTO dto) {
        Application application = new Application();
        application.setApplicationId(dto.getApplicationId());
        application.setProjectDescription(dto.getProjectDescription());
        application.setStatus(dto.getStatus());
        application.setSubmissionDate(dto.getSubmissionDate());
        return application;
    }
}

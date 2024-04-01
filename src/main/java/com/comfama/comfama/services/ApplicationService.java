package com.comfama.comfama.services;

import com.comfama.comfama.entities.Application;
import com.comfama.comfama.repositories.IApplicationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicationService {
    private final IApplicationRepository applicationRepository;

    @Autowired
    public ApplicationService(IApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    public Application createApplication(Application application) {
        return applicationRepository.save(application);
    }

    public List<Application> getAllApplications() {
        return applicationRepository.findAll();
    }

    public Application getApplicationById(Long id) {
        return applicationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Application not found with id: " + id));
    }

    public Application updateApplication(Application applicationToUpdate) {
        Application application = getApplicationById(applicationToUpdate.getApplicationId());
        application.setProjectDescription(applicationToUpdate.getProjectDescription());
        application.setStatus(applicationToUpdate.getStatus());
        application.setSubmissionDate(applicationToUpdate.getSubmissionDate());
        // Update other fields as needed
        return applicationRepository.save(application);
    }

    public void deleteApplication(Long id) {
        Application application = getApplicationById(id);
        applicationRepository.delete(application);
    }
}
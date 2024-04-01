package com.comfama.comfama.controllers;

import com.comfama.comfama.dtos.ApplicationDTO;
import com.comfama.comfama.entities.Application;
import com.comfama.comfama.mappers.ApplicationMapper;
import com.comfama.comfama.services.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {
    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping
    public ResponseEntity<ApplicationDTO> createApplication(@RequestBody ApplicationDTO applicationDTO) {
        Application application = ApplicationMapper.toEntity(applicationDTO);
        Application createdApplication = applicationService.createApplication(application);
        return ResponseEntity.ok(ApplicationMapper.toDTO(createdApplication));
    }

    @GetMapping
    public ResponseEntity<List<ApplicationDTO>> getAllApplications() {
        List<ApplicationDTO> applications = applicationService.getAllApplications().stream()
                .map(ApplicationMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(applications);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApplicationDTO> getApplicationById(@PathVariable Long id) {
        Application application = applicationService.getApplicationById(id);
        return ResponseEntity.ok(ApplicationMapper.toDTO(application));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApplicationDTO> updateApplication(@PathVariable Long id, @RequestBody ApplicationDTO applicationDTO) {
        Application application = ApplicationMapper.toEntity(applicationDTO);
        application.setApplicationId(id); // Ensure the ID is set to the path variable
        Application updatedApplication = applicationService.updateApplication(application);
        return ResponseEntity.ok(ApplicationMapper.toDTO(updatedApplication));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        applicationService.deleteApplication(id);
        return ResponseEntity.ok().build();
    }
}

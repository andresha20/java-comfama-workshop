package com.comfama.comfama.repositories;

import com.comfama.comfama.entities.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IApplicationRepository extends JpaRepository<Application, Long> {
}


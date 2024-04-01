package com.comfama.comfama.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long applicationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicantId")
    @Getter
    @Setter
    private Applicant applicant;
    @Getter
    @Setter
    private String projectDescription;
    @Getter
    @Setter
    private String status;
    @Getter
    @Setter
    private Date submissionDate;

    @OneToMany(mappedBy = "application", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Document> documents = new HashSet<>();

    // Constructors, getters, and setters...
}

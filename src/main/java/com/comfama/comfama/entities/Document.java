package com.comfama.comfama.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long documentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "applicationId")
    @Getter
    @Setter
    private Application application;
    @Getter
    @Setter
    private String type;
    @Getter
    @Setter
    private String filePath;
    @Getter
    @Setter
    private Date uploadTimestamp;
}

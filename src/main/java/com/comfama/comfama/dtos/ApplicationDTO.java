package com.comfama.comfama.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class ApplicationDTO {
    @Getter
    @Setter
    private Long applicationId;
    @Getter
    @Setter
    private Long applicantId;
    @Getter
    @Setter
    private String projectDescription;
    @Getter
    @Setter
    private String status;
    @Getter
    @Setter
    private Date submissionDate;

}

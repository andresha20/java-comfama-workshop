package com.comfama.comfama.dtos;

import lombok.Getter;
import lombok.Setter;

public class ApplicantDTO {
    @Getter
    @Setter
    private Long applicantId;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String phone;
    @Getter
    @Setter
    private String affiliation;
}

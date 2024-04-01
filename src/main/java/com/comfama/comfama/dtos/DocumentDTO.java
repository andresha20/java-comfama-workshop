package com.comfama.comfama.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class DocumentDTO {
    @Getter
    @Setter
    private Long documentId;
    @Getter
    @Setter
    private Long applicationId;
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

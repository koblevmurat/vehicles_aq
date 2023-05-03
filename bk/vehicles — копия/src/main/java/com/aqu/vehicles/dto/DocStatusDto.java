package com.aqu.vehicles.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocStatusDto {
    private String docUID;
    private String docStatus;
}

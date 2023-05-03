package com.aqu.vehicles.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Builder
public class VehicleDto {
    private LocalDateTime date;
    private String driver;
    private String docs;
    private String vehicle;
    private String veh_number;
    private String trailer;
    private String trailer_number;
    private String uidDoc;
    private String status;
    public LocalTime getTime() {
        return date.toLocalTime();
    }
}

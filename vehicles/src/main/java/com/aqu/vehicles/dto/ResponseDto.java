package com.aqu.vehicles.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ResponseDto {
    LocalDateTime dateTime;
    List<VehicleDto> responseData;

    public LocalDate getDateTime() {
        return dateTime.toLocalDate();
    }
}

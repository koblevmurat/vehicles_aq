package com.aqu.vehicles.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Response1c {
    String Data;
    Vehicle[] Dannie;
    public Vehicle[] getVehicles() {
        return this.Dannie;
    }

    public String getDate() {
        return this.Data;
        //LocalDate.parse(this.Data, DateTimeFormatter.ISO_DATE_TIME).toString().replace("-", ".");
    }
}

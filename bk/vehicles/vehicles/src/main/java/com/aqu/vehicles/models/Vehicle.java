package com.aqu.vehicles.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {

    String UID_Doc;
    String Tip_Doc;
    String Data_Podachi;
    String Voditel_Name;
    String Voditel_Documenti;
    String Transport_Name;
    String Transport_Nomer;
    String Transport_Pricep;
    String Transport_Pricep_Nomer;
    String Status_avto;
    String Status_avto_znacenie;
}


package com.aqu.vehicles.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocStatus {
    String UID_Doc;
    String Tip_Doc;
    String Status_avto_znacenie;
    String PC;
}

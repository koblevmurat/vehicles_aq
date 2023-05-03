package com.aqu.vehicles.service;

import com.aqu.vehicles.dto.VehicleDto;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface IVehicleService {
    List<VehicleDto> getAllVehicles() throws IOException, InterruptedException, URISyntaxException;
}

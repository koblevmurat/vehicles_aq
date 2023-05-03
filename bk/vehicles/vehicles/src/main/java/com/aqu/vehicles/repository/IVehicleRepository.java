package com.aqu.vehicles.repository;

import com.aqu.vehicles.models.Vehicle;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;

@Component
public interface IVehicleRepository {
    Optional<Vehicle> getAllVehicles() throws IOException, InterruptedException, URISyntaxException;
}

package com.aqu.vehicles.service;

import com.aqu.vehicles.dto.VehicleDto;
import com.aqu.vehicles.models.Vehicle;
import com.aqu.vehicles.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleSevice implements IVehicleService {

    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleSevice(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<VehicleDto> getAllVehicles() throws IOException, InterruptedException, URISyntaxException {
        Optional<Vehicle> vehicles = this.vehicleRepository.getAllVehicles();
        return vehicles.stream().map(vhcl -> mapVehicleDto(vhcl)).collect(Collectors.toList());
    }

    private VehicleDto mapVehicleDto(Vehicle vehicle) {
        VehicleDto vehicleDto = VehicleDto.builder().vehicle(vehicle.getTransport_Name())
                .driver(vehicle.getVoditel_Name())
                .veh_number(vehicle.getTransport_Nomer())
                .docs(vehicle.getVoditel_Documenti())
                .trailer(vehicle.getTransport_Pricep())
                .trailer_number(vehicle.getTransport_Pricep_Nomer())
                .date(LocalDateTime.parse(vehicle.getData_Podachi()))
                .build();
        return vehicleDto;
    }
}

//vehicleDto.setDate(java.util.Date
//        .from(java.sql.Date.valueOf(vehicle.getData_Podachi()).toInstant()));
//        vehicleDto.setVehicle(vehicle.getTransport_Name());
//        vehicleDto.setVeh_number(vehicle.getTransport_Nomer());
//        vehicleDto.setDriver(vehicle.getVoditel_Name());
//        vehicleDto.setDocs(vehicle.getVoditel_Documenti());
//        vehicleDto.setTrailer(vehicle.getTransport_Pricep());
//        vehicleDto.setTrailer_number(vehicle.getTransport_Pricep_Nomer());
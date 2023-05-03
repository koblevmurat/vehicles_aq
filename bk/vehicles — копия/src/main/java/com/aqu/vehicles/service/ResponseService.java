package com.aqu.vehicles.service;

import com.aqu.vehicles.dto.DocStatusDto;
import com.aqu.vehicles.dto.ResponseDto;
import com.aqu.vehicles.dto.VehicleDto;
import com.aqu.vehicles.models.DocStatus;
import com.aqu.vehicles.models.Response1c;
import com.aqu.vehicles.models.Vehicle;
import com.aqu.vehicles.repository.ResponseRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResponseService implements IResponseService {

    private ResponseRepository responseRepository;

    @Autowired
    public ResponseService(ResponseRepository responseRepository) {
        this.responseRepository = responseRepository;
    }

    @Override
    public List<ResponseDto> getResponse() throws URISyntaxException, IOException, InterruptedException {
        List<Response1c> response = this.responseRepository.getResponse();
        return response.stream().map(response1c -> mapResponseDto(response1c))
                .collect(Collectors.toList());
    }

    @Override
    public int UpdateDocStatus(DocStatusDto docStatusDto) throws URISyntaxException, IOException, InterruptedException {
        return responseRepository.UpdateDocument(mapDocStatus(docStatusDto));
    }

    private ResponseDto mapResponseDto(Response1c response1c) {
        ResponseDto responseDto = ResponseDto.builder()
                .dateTime(LocalDateTime.parse(response1c.getDate()))
                .responseData(Arrays.stream(response1c.getDannie()).toList().stream()
                        .map(dat-> mapVehicleDto(dat)).collect(Collectors.toList()))
                .build();
//        responseDto.setResponseData(
//        Arrays.stream(response1c.getDannie()).toList().stream().map(dat-> mapVehicleDto(dat)).collect(Collectors.toList()));
        return responseDto;
    }

    private VehicleDto mapVehicleDto(Vehicle vehicle) {
        VehicleDto vehicleDto = VehicleDto.builder().vehicle(vehicle.getTransport_Name())
                .driver(vehicle.getVoditel_Name())
                .veh_number(vehicle.getTransport_Nomer())
                .docs(vehicle.getVoditel_Documenti())
                .trailer(vehicle.getTransport_Pricep())
                .trailer_number(vehicle.getTransport_Pricep_Nomer())
                .date(LocalDateTime.parse(vehicle.getData_Podachi()))
                .status(vehicle.getStatus_avto_znacenie())
                .leftDateTime(LocalDateTime.parse(vehicle.getDateTime_left()))
                .missedDateTime(LocalDateTime.parse(vehicle.getDateTime_missed()))
                .uidDoc(vehicle.getUID_Doc())
                .build();
        return vehicleDto;
    }

    private DocStatus mapDocStatus (DocStatusDto docDto){
        DocStatus docStatus = DocStatus.builder()
                .Tip_Doc("ZayvkaNaPerevozku")
                .PC("web")
                .UID_Doc(docDto.getDocUID())
                .Status_avto_znacenie(docDto.getDocStatus())
                .build();
        return docStatus;
    }
}

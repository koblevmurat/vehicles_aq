package com.aqu.vehicles.service;

import com.aqu.vehicles.dto.DocStatusDto;
import com.aqu.vehicles.dto.ResponseDto;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface IResponseService {
    List<ResponseDto> getResponse() throws URISyntaxException, IOException, InterruptedException;

    int UpdateDocStatus(DocStatusDto docStatusDto) throws URISyntaxException, IOException, InterruptedException;
}

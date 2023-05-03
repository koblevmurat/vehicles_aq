package com.aqu.vehicles.repository;

import com.aqu.vehicles.models.Response1c;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@Component
public interface IResponseRepository {
    List<Response1c> getResponse() throws URISyntaxException, IOException, InterruptedException;

}

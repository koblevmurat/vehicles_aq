package com.aqu.vehicles.repository;

import com.aqu.vehicles.models.Response1c;
import com.aqu.vehicles.models.Vehicle;
import com.aqu.vehicles.repository.utils.SimpleAuthenticator;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@Component
public class VehicleRepository implements IVehicleRepository{

    @Value("${userName1c}")
    private String userName1c;

    @Value("${password1c}")
    private String password1c;

//    @Value("${url}")
//    private String url;
    @Override
    public Optional<Vehicle> getAllVehicles() throws IOException, InterruptedException, URISyntaxException {
//        String basicAuth = SimpleAuthenticator.getBasicAuthenticationHeader(userName1c, password1c);
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder().setHeader("Authorization", basicAuth).uri(new URI(url)).GET().build();
//        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//        String json = (String)response.body();
//        Response1c[] response1c = (Response1c[])(new Gson()).fromJson(json, Response1c[].class);
//        for(int i = 0; i < response1c.length; ++i) {
//            if (response1c[i].getVehicles().length > 0) {
////                List<VehicleDto> vehicleList = Arrays.stream(response1c[i].getVehicles()).map(p -> mapToDto(p))
////                        .collect(Collectors.toList());
////                allVehicleList.add(vehicleList);
//            }
//        }
        return Optional.empty();
    }
}

package com.aqu.vehicles.repository;

import com.aqu.vehicles.models.DocStatus;
import com.aqu.vehicles.models.Response1c;
import com.aqu.vehicles.repository.utils.SimpleAuthenticator;
import com.aqu.vehicles.repository.utils.TestData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

@Component
public class ResponseRepository implements IResponseRepository {

    @Value("${userName1c}")
    private String userName1c;

    @Value("${password1c}")
    private String password1c;

    @Value("${Url1c}")
    private String Url1c;// = "http://localhost/upr/hs/SpisokMachin";
    @Override
    public List<Response1c> getResponse() throws URISyntaxException, IOException, InterruptedException {
        String basicAuth = SimpleAuthenticator.getBasicAuthenticationHeader(userName1c, password1c);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .setHeader("Authorization", basicAuth)
                .uri(new URI(Url1c))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = (String)response.body();
//        String json = TestData.GetTestData();
        Response1c[] response1c = (Response1c[])(new Gson()).fromJson(json, Response1c[].class);
        return Arrays.stream(response1c).toList();
    }

    public void UpdateDocument(DocStatus mapDocStatus) throws URISyntaxException, IOException, InterruptedException {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String requestBody = objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(mapDocStatus);

            String basicAuth = SimpleAuthenticator.getBasicAuthenticationHeader(userName1c, password1c);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .setHeader("Authorization", basicAuth)
                    .uri(new URI(Url1c))
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }
}

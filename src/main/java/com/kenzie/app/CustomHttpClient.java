package com.kenzie.app;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class CustomHttpClient {

    //TODO: Write sendGET method that takes URL and returns response
    public static String sendGET(String URLString) {
        //** Start of GET request algorithm
        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create(URLString);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Accept", "application/json")
                .GET()
                .build();
        try {
            HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = httpResponse.statusCode();
            if (statusCode == 200) {
                return httpResponse.body();
            } else {
                return String.format("GET request failed: %d status code received", statusCode);
            }
        } catch (IOException | InterruptedException e) {
            return e.getMessage();
        }
    }

    public String getClueQuestion(String jsonString) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        CluesDTO cluesDTO = objectMapper.readValue(jsonString, CluesDTO.class);

        return cluesDTO.getQuestion();
    }

    public String getClueAnswer(String jsonString) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        CluesDTO cluesDTO = objectMapper.readValue(jsonString, CluesDTO.class);

        return cluesDTO.getAnswer();
    }

    public String getClueCategoryTitle(String jsonString) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        CluesDTO cluesDTO = objectMapper.readValue(jsonString, CluesDTO.class);

        return cluesDTO.getCategory().getTitle();
    }

    //Formats input to be used for getCluesList() method
    public String formatForList(String jsonString) {
        return jsonString.substring(jsonString.indexOf("[{"), jsonString.lastIndexOf('}'));
    }

    public static List<CluesDTO> getCluesList(String jsonString) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CluesDTO>> typeReferenceListCluesDTO = new TypeReference<>() {};
        List<CluesDTO> cluesList = objectMapper.readValue(jsonString, typeReferenceListCluesDTO);
        //List<CluesDTO> cluesList = new ObjectMapper().readValue(jsonAsString, new TypeReference<List<CluesDTO>>(){});

        return cluesList;
    }

    public static List<CluesDTO.Category> getCategoryList(String jsonString) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CluesDTO.Category>> typeReferenceListCluestDTO = new TypeReference<>() {};
        List<CluesDTO.Category> categoryList = objectMapper.readValue(jsonString, typeReferenceListCluestDTO);

        return categoryList;
    }

    public int getClueValue(String jsonString) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        CluesDTO cluesDTO = objectMapper.readValue(jsonString, CluesDTO.class);

        return cluesDTO.getValue();
    }
}

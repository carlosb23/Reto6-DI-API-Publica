package org.example;

import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consulta_1 {
    public static void main(String[] args) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://moviesminidatabase.p.rapidapi.com/series/idbyTitle/Dragon%20Ball/"))
                .header("X-RapidAPI-Key", APIConfig.API_KEY)
                .header("X-RapidAPI-Host", "moviesminidatabase.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        JSONObject json = new JSONObject(response.body());

        System.out.println(json.toString(2));
    }
}
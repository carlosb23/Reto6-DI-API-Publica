package org.example;

import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consulta_3 {

    public static void main(String[] args) {

        //System.out.println(getSerie());
        System.out.println(getEpisodio());
    }

    public static String getSerie() {
        String seriesId = "";
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://moviesminidatabase.p.rapidapi.com/series/idbyTitle/Dragon%20Ball/"))
                    .header("X-RapidAPI-Key", APIConfig.API_KEY)
                    .header("X-RapidAPI-Host", "moviesminidatabase.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonResponse = new JSONObject(response.body());
            System.out.println(jsonResponse.toString(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return seriesId;
    }

    public static String getEpisodio() {
        String episodio = "";
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://moviesminidatabase.p.rapidapi.com/series/id/tt0280249/season/3/episode/1/"))
                    .header("X-RapidAPI-Key", APIConfig.API_KEY)
                    .header("X-RapidAPI-Host", "moviesminidatabase.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject jsonResponse = new JSONObject(response.body());
            System.out.println(jsonResponse.toString(2));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return episodio;
    }
}

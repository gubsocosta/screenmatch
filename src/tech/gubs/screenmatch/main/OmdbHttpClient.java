package tech.gubs.screenmatch.main;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import tech.gubs.screenmatch.entities.Title;
import tech.gubs.screenmatch.entities.omdb.TitleOmdb;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class OmdbHttpClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter the movie's name: ");
        var movieName = reader.nextLine();
        String apiKey = "8549c132";
        String url = "http://www.omdbapi.com?apikey=" + apiKey + "&t=" + movieName;
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        String bodyRaw = response.body();
        System.out.println(bodyRaw);
//        Gson gson = new Gson();
//        Title title = gson.fromJson(bodyRaw, Title.class);
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();
        TitleOmdb titleOmdb = gson.fromJson(bodyRaw, TitleOmdb.class);
        Title title = new Title(titleOmdb);
        System.out.println(title);
    }
}

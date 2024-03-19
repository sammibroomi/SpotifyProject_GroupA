package edu.bsu.cs;

import org.json.JSONObject;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class API_Requests {

    public String searchForArtist(String token, String artistName) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.spotify.com/v1/search?q=" + URLEncoder.encode(artistName, "utf-8") + "&type=artist" + "&limit=5"))
                .header("Authorization", "Bearer " + token)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        int statusCode = response.statusCode();

        if (statusCode == 200) {
            String responseBody = response.body();
            JSONObject jsonObject = new JSONObject(responseBody);
            JSON_Formatter JSONFormatter = new JSON_Formatter();
            JSONFormatter.formatArtist(responseBody);

            System.out.println(responseBody);
            return responseBody;
        }
        return null;
    }

    public String searchForTrack(String token, String trackName) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.spotify.com/v1/search?q=" + URLEncoder.encode(trackName, "utf-8") + "&type=track" + "&limit=5"))
                .header("Authorization", "Bearer " + token)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        int statusCode = response.statusCode();

        if (statusCode == 200) {
            String responseBody = response.body();
            JSONObject jsonObject = new JSONObject(responseBody);
            //System.out.println(responseBody);
            JSON_Formatter JSONFormatter = new JSON_Formatter();
            JSONFormatter.formatTrack(responseBody);
            return responseBody;
        }
        return null;
    }

    public String getArtistFromID(String token, String artistID) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.spotify.com/v1/artists/" + artistID))
                .header("Authorization", "Bearer " + token)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        int statusCode = response.statusCode();
        System.out.println(statusCode);

        if (statusCode == 200) {
            String responseBody = response.body();
            JSONObject jsonObject = new JSONObject(responseBody);
            System.out.println(responseBody);
            return responseBody;
        }
        return null;
    }

    public String getTrackFromID(String token, String trackID) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://api.spotify.com/v1/tracks/" + trackID))
                .header("Authorization", "Bearer " + token)
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        int statusCode = response.statusCode();
        System.out.println(statusCode);

        if (statusCode == 200) {
            String responseBody = response.body();
            JSONObject jsonObject = new JSONObject(responseBody);
            System.out.println(responseBody);
            return responseBody;
        }
        return null;
    }

    public void searchForAlbum(String accessToken, String userInput) {
    }
}

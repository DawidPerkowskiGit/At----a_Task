package com.example.ata_task.githubapicaller;

import com.example.ata_task.githubapicaller.requestobject.GitHubRepository;
import com.example.ata_task.githubapicaller.requestobject.GitHubRequestObject;
import com.example.ata_task.githubapicaller.requestobject.GitHubUser;
import com.example.ata_task.githubapicaller.responseobject.Branch;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation for calling GitHub REST API
 */
public class GitHubApiCaller {

    /**
     * Calls GitHub REST API and retrieves GitHubUser data
     *
     * @param apiUrl URL to the API
     * @return Object of GitHubUser type
     */
    public GitHubUser callApiReturnUser(String apiUrl) {

        try {
            String apiResponseBody = getRequestBody(apiUrl);
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(apiResponseBody, GitHubUser.class);
        } catch (Exception e) {
            System.out.println("Exception occurred while trying to get REST API GitHubUser response body. Exception: " + e);
        }
        return new GitHubUser();
    }

    /**
     * Calls GitHub REST API and retrieves GitHubRepository data
     *
     * @param apiUrl URL to the API
     * @return Object of GitHubRepository type
     */

    public List<GitHubRepository> callApiReturnRepositories(String apiUrl) {

        try {
            String apiResponseBody = getRequestBody(apiUrl);
            ObjectMapper mapper = new ObjectMapper();

            return mapper.readValue(apiResponseBody, mapper.getTypeFactory().constructCollectionType(List.class, GitHubRepository.class));
        } catch (Exception e) {
            System.out.println("Exception occurred while trying to get REST API List<GitHubRepository> response body. Exception: " + e);
        }
        return new ArrayList<>();
    }

    /**
     * Calls GitHub REST API and retrieves Branch data
     *
     * @param apiUrl URL to the API
     * @return Object of Branch type
     */

    public List<Branch> callApiReturnBranches(String apiUrl) {

        try {
            String apiResponseBody = getRequestBody(apiUrl);
            ObjectMapper mapper = new ObjectMapper();

            return mapper.readValue(apiResponseBody, mapper.getTypeFactory().constructCollectionType(List.class, Branch.class));
        } catch (Exception e) {
            System.out.println("Exception occurred while trying to get REST API List<Branch> response body. Exception: " + e);
        }
        return new ArrayList<>();
    }

    /**
     * Calls GitHub REST API URL and fetches JSON body data
     *
     * @param apiUrl URL of the REST API
     * @return JSON data
     */
    private static String getRequestBody(String apiUrl) {
        String apiResponseBody = "";
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiUrl)).build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            apiResponseBody = response.body();
        } catch (Exception e) {
            System.out.println("Exception occurred when trying to request HTTP data");
        }
        return apiResponseBody;
    }

}

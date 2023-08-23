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
import java.util.List;

/**
 * Implementation for calling GitHub REST API
 */
public class GitHubApiCaller {

    public GitHubUser callApiReturnUser(String apiUrl, GitHubUser object) throws IOException, InterruptedException {

        String apiResponseBody = getRequestBody(apiUrl);
        ObjectMapper mapper = new ObjectMapper();
        GitHubUser requestObject = mapper.readValue(apiResponseBody, object.getClass());

        return requestObject;
    }



    public List<GitHubRepository> callApiReturnRepositories(String apiUrl, List<GitHubRepository> object) throws IOException, InterruptedException {

        String apiResponseBody = getRequestBody(apiUrl);
        ObjectMapper mapper = new ObjectMapper();
        List<GitHubRepository> requestList = mapper.readValue(apiResponseBody, mapper.getTypeFactory().constructCollectionType(List.class, GitHubRepository.class));

        return requestList;
    }

    public List<Branch> callApiReturnBranches(String apiUrl, List<Branch> object) throws IOException, InterruptedException {

        String apiResponseBody = getRequestBody(apiUrl);
        ObjectMapper mapper = new ObjectMapper();
        List<Branch> requestList = mapper.readValue(apiResponseBody, mapper.getTypeFactory().constructCollectionType(List.class, Branch.class));

        return requestList;
    }
    private static String getRequestBody(String apiUrl) throws IOException, InterruptedException {
        String apiResponseBody = "";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(apiUrl)).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        apiResponseBody = response.body();
        return apiResponseBody;
    }

}

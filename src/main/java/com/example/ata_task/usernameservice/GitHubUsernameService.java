package com.example.ata_task.usernameservice;

import com.example.ata_task.configuartion.GlobalVariables;
import com.example.ata_task.githubapicaller.GitHubApiCaller;
import com.example.ata_task.githubapicaller.requestobject.GitHubRepository;
import com.example.ata_task.githubapicaller.requestobject.GitHubUser;
import com.example.ata_task.githubapicaller.responseobject.Branch;
import com.example.ata_task.githubapicaller.responseobject.Repository;
import com.example.ata_task.githubapicaller.responseobject.User;
import com.example.ata_task.headerparser.GithubServiceHeaderParser;
import com.example.ata_task.headerparser.HeaderParser;
import com.example.ata_task.headerparser.pojotoserializable.GitHubServiceHeaderInterpreter;
import com.example.ata_task.headerparser.resultobject.HeaderParsingResultObject;
import com.example.ata_task.headerparser.resultobject.InvalidRequestJsonBody;
import com.example.ata_task.jsonresponse.CustomJsonSerializable;
import com.example.ata_task.jsonresponse.GitHubServiceJsonSerializer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Implementation of service returning GitHub's user repositories
 */
public class GitHubUsernameService implements UsernameService {

    /**
     * Service method for "/{username} endpoint
     *
     * @param username GitHub username
     * @param headers  HTTP headers
     * @return List of single user's GitHub repositories, their branches and latest commit SHA in JSON format
     */
    public String processRequest(String username, Map<String, String> headers) throws IOException, InterruptedException {
        HeaderParser headerParser = new GithubServiceHeaderParser(headers);
        HeaderParsingResultObject headerParsingResult = headerParser.parseHeaders();

        CustomJsonSerializable jsonSerializable = new InvalidRequestJsonBody();
        GitHubServiceJsonSerializer serializer = new GitHubServiceJsonSerializer();
        String json;

        /**
         * Return JSON body with information for requests with invalid HTTP headers.
         */
        try {
            if (headerParsingResult.ifValidated() == false) {
                GitHubServiceHeaderInterpreter headerInterpreter = new GitHubServiceHeaderInterpreter();
                jsonSerializable = headerInterpreter.parseHeaderInfoToSerializableObject(headerParsingResult);
                json = serializer.buildJsonFromPojo(jsonSerializable);
                return json;
            }
        } catch (Exception e) {
            System.out.println("Cannot return JSON data of invalid header information. Exception " + e);
        }

        /**
         * Check if gitHubUser exists
         */
        GitHubApiCaller gitHubApiCaller = new GitHubApiCaller();
        GitHubUser gitHubUser = new GitHubUser();

        if (headerParsingResult.ifValidated()) {
            try {
                gitHubUser = gitHubApiCaller.callApiReturnUser(GlobalVariables.API_URL + "/users/" + username, gitHubUser);

            } catch (Exception e) {
                System.out.println("Could not call the API. Exception: " + e);
            }
        }

        /**
         * If gitHubUser does not exist return error message in JSON format.
         */

        if (gitHubUser.getLogin() == null) {
            InvalidRequestJsonBody noUserInvalidRequest = new InvalidRequestJsonBody();
            noUserInvalidRequest.setStatus(404);
            noUserInvalidRequest.setMessage("User could not be found");
            return serializer.buildJsonFromPojo(noUserInvalidRequest);
        }

        /**
         * If gitHubUser exists, check if there is URL to repository list
         */

        if (gitHubUser.getRepos_url() == null) {
            InvalidRequestJsonBody noReposInvalidRequest = new InvalidRequestJsonBody();
            noReposInvalidRequest.setStatus(404);
            noReposInvalidRequest.setMessage("Could not find gitHubUser's repository list");
            return serializer.buildJsonFromPojo(noReposInvalidRequest);
        }

        /**
         * If repository URL is present, create User object and parse repositories
         */

        User user = new User();
        user.setUsername(gitHubUser.getName());

        List<GitHubRepository> repositoryList = new ArrayList<>();
        try {
            repositoryList = gitHubApiCaller.callApiReturnRepositories(gitHubUser.getRepos_url(), repositoryList);
        } catch (Exception e) {
            System.out.println("Could not extract repositories");
        }

        /**
         * Add repositories to user's list and fetch branches
         */


        for (GitHubRepository gitHubRepository: repositoryList
             ) {
            try {
                if (gitHubRepository.getFork() == false) {
                    Repository repository = new Repository();
                    repository.setName(gitHubRepository.getName());
                    repository.setOwner(gitHubRepository.getOwner().getLogin());
                    List<Branch> branchList = new ArrayList<>();
                    branchList = gitHubApiCaller.callApiReturnBranches(GlobalVariables.API_URL + "/repos/" + username + "/" + repository.getName() + "/branches", branchList);
                    repository.setBranches(branchList);
                    user.addRepository(repository);
                }

            } catch (Exception e) {
                System.out.println("Could not add the repository to user's list. Exception" + e);
            }
        }

        /**
         * Return parsed data
         */

        return serializer.buildJsonFromPojo(user);
    }
}
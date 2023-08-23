package com.example.ata_task.usernameservice;

import com.example.ata_task.headerparser.GithubServiceHeaderParser;
import com.example.ata_task.headerparser.HeaderParser;
import com.example.ata_task.headerparser.pojotoserialziable.GitHubServiceHeaderInterpreter;
import com.example.ata_task.headerparser.resultobject.HeaderParsingResultObject;
import com.example.ata_task.headerparser.resultobject.InvalidRequestJsonBody;
import com.example.ata_task.jsonresponse.CustomJsonSerializable;
import com.example.ata_task.jsonresponse.GitHubServiceJsonSerializer;

import java.util.Map;

/**
 * Implementation of service returning GitHub's user repositories
 */
public class GitHubUsernameService implements UsernameService{

    /**
     * Service method for "/{username} endpoint
     * @param username GitHub username
     * @param headers HTTP headers
     * @return List of single user's GitHub repositories, their branches and latest commit SHA in JSON format
     */
    public String processRequest(String username, Map<String, String> headers) {
        HeaderParser headerParser = new GithubServiceHeaderParser(headers);
        HeaderParsingResultObject headerParsingResult = headerParser.parseHeaders();

        CustomJsonSerializable jsonSerializable = new InvalidRequestJsonBody();
        GitHubServiceJsonSerializer serializer = new GitHubServiceJsonSerializer();
        String json;
        /**
         * Return JSON body with information for requests with invalid HTTP headers.
         */
        if (headerParsingResult.getValidated() == false) {
            GitHubServiceHeaderInterpreter headerInterpreter = new GitHubServiceHeaderInterpreter();
            jsonSerializable = headerInterpreter.parseHeaderInfoToSerializableObject(headerParsingResult);
            json = serializer.buildJsonFromPojo(jsonSerializable);
            return json;
        }






        return "";
    }
}

package com.example.ata_task.usernameservice;

import com.example.ata_task.headerparser.GithubServiceHeaderParser;
import com.example.ata_task.headerparser.HeaderParser;
import com.example.ata_task.headerparser.HeaderParsingResultObject;
import com.example.ata_task.jsonresponse.GitHubServiceJsonSerializer;
import com.example.ata_task.jsonresponse.JsonSerializable;

import java.util.Map;

/**
 * Implementation of service returning GitHub's user repositories
 */
public class GitHubUsernameService implements UsernameService{
    public String processRequest(String username, Map<String, String> headers) {
        HeaderParser headerParser = new GithubServiceHeaderParser(headers);
        HeaderParsingResultObject headerParsingResult = headerParser.parseHeaders();

        GitHubServiceJsonSerializer serializer = new GitHubServiceJsonSerializer();
        String json = serializer.buildJsonFromPojo(headerParsingResult);


        return json;
    }
}

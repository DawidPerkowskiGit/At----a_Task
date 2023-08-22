package com.example.ata_task.controllers;

import com.example.ata_task.usernameservice.GitHubUsernameService;
import com.example.ata_task.usernameservice.UsernameService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * REST API controller for GitHub Service API
 */
@RestController
public class ApiController {

    /**
     * Fetches user's GutHub repositories and filters out forked ones
     * @param headers List of headers
     * @return User's non-forked repositories and their latest commit SHA.
     */
    @GetMapping("/{username}")
    String getUserAndRepos(@RequestHeader Map<String, String> headers,
    @PathVariable String username) {
        UsernameService usernameService = new GitHubUsernameService();
        return usernameService.processRequest(username, headers);
    }
}

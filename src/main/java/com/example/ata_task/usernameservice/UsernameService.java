package com.example.ata_task.usernameservice;

import java.util.Map;

/**
 * Common interface for Username service
 */
public interface UsernameService {
    public String processRequest(String username, Map<String, String> headers);
}

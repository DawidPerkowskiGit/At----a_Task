package com.example.ata_task.jsonresponse;

import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Implementation of Serializer which converts Objects to JSON format.
 * This specific one converts GitHub service users and their repositories data or invalid header parser response.
 */
public class GitHubServiceJsonSerializer implements ObjectToJsonSerializer {

    /**
     * Returns an Object in JSON format
     *
     * @param object Java object containing Exchange or Currency data
     * @return Requested data in JSON format
     */

    public String buildJsonFromPojo(CustomJsonSerializable object) {
        ObjectMapper objectMapper = new ObjectMapper();
        String exchangesToJson = "";

        try {
            exchangesToJson = objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            System.out.println("Could not map object to JSON. Exception: " + e);
        }

        return exchangesToJson;
    }


}

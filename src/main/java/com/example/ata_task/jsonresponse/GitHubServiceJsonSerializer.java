package com.example.ata_task.jsonresponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of Serializer which converts Objects to JSON format.
 * This specific one converts GitHub service users and their repositories data or invalid header parser response.
 */
public class GitHubServiceJsonSerializer implements ObjectToJsonSerializer {

    /**
     * Returns list of JSON-parseable objects in JSON format
     *
     * @param pojoList Java List object containing Exchange or Currency data
     * @return Object list in JSON format
     */
    public String buildJsonFromPojo(List<JsonSerializable> pojoList) {
        ObjectMapper objectMapper = new ObjectMapper();
        String exchangesToJson = "";

        if (pojoList.size() == 1) {
            try {
                exchangesToJson = objectMapper.writeValueAsString(pojoList.get(0));
            } catch (Exception e) {
                System.out.println("Could not map object to JSON. Exception: " + e);
            }
        } else {
            try {
                exchangesToJson = objectMapper.writeValueAsString(pojoList);
            } catch (Exception e) {
                System.out.println("Could not map object to JSON. Exception: " + e);
            }
        }

        return exchangesToJson;
    }

    /**
     * Returns an Object in JSON format
     *
     * @param pojoElement Java object containing Exchange or Currency data
     * @return Requested data in JSON format
     */

    public String buildJsonFromPojo(JsonSerializable pojoElement) {

        List<JsonSerializable> list = new ArrayList<>();
        list.add(pojoElement);
        return buildJsonFromPojo(list);

    }
}

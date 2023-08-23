package com.example.ata_task.jsonresponse;

/**
 * Interface for Object => JSON serializers.
 */
public interface ObjectToJsonSerializer {

    /**
     * Java Object => JSON parser common interface
     * @param object Object to parse
     * @return Object converted to JSON.
     */

    public String buildJsonFromPojo(CustomJsonSerializable object);


}

package com.example.ata_task.jsonresponse;

import java.util.List;

/**
 * Interface for Object => JSON serializers.
 */
public interface ObjectToJsonSerializer {
    public String buildJsonFromPojo(List<JsonSerializable> pojoList);
}

package com.example.ata_task.githubapicaller.responseobject;

import com.example.ata_task.jsonresponse.CustomJsonSerializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Object which stores required Branch data.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Branch implements CustomJsonSerializable {

    private String name;
    private Commit commit;
}

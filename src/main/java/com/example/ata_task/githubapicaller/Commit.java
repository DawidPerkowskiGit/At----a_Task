package com.example.ata_task.githubapicaller;

import com.example.ata_task.jsonresponse.CustomJsonSerializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Object which stores required commit data
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Commit implements CustomJsonSerializable {
    private String sha;
}

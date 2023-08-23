package com.example.ata_task.githubapicaller.responseobject;

import com.example.ata_task.jsonresponse.CustomJsonSerializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Object which stores required username data
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements CustomJsonSerializable {

    private String username;

    private List<Repository> repositories = new ArrayList<>();

    public void addRepository(Repository repository) {
        this.repositories.add(repository);
    }
}

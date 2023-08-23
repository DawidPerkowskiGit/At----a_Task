package com.example.ata_task.githubapicaller;

import com.example.ata_task.jsonresponse.CustomJsonSerializable;
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
public class GitHubUser implements CustomJsonSerializable {

    private String username;

    private List<Repository> repositories = new ArrayList<>();

    public void addRepository(Repository repository) {
        this.repositories.add(repository);
    }
}

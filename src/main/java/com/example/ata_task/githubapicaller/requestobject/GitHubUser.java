package com.example.ata_task.githubapicaller.requestobject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Objects of this class store GitHub user's data
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubUser implements GitHubRequestObject{
    private String login;
    private String name;
    private String repos_url;
}

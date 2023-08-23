package com.example.ata_task.githubapicaller.requestobject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Objects of this class store GitHub repository owner data
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubRepoOwner implements GitHubRequestObject{
    private String login;
}

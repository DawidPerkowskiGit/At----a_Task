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
 * Object which stores required repository data
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Repository implements CustomJsonSerializable {

    private String name;

    private String owner;
    private List<Branch> branches = new ArrayList<>();

    public void addBranch(Branch branch) {
        this.branches.add(branch);
    }

}

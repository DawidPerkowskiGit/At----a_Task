package com.example.ata_task.githubapicaller;

import com.example.ata_task.jsonresponse.CustomJsonSerializable;
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
public class Repository implements CustomJsonSerializable {
    private List<Branch> branches = new ArrayList<>();

    public void addBranch(Branch branch) {
        this.branches.add(branch);
    }

}

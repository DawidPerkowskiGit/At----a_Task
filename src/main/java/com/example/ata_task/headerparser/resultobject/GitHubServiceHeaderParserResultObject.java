package com.example.ata_task.headerparser.resultobject;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * Stores returned data paring data of GitHub Header Parsing Service
 */
@NoArgsConstructor
@AllArgsConstructor
public class GitHubServiceHeaderParserResultObject implements HeaderParsingResultObject {
    private String validationResult;

    private int status;

    private Boolean validated;

    public String getValidationResult() {
        return validationResult;
    }

    public void setValidationResult(String validationResult) {
        this.validationResult = validationResult;
    }

    public Boolean getValidated() {
        return validated;
    }

    public void setValidated(Boolean validated) {
        this.validated = validated;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

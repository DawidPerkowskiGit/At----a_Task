package com.example.ata_task.headerparser;

import com.example.ata_task.jsonresponse.JsonSerializable;

/**
 * Implementation of this interface store data returned by HeaderParsing services
 */
public interface HeaderParsingResultObject extends JsonSerializable {

    public void setValidated(Boolean value);

    public Boolean getValidated();

    public void setStatus(int value);

    public int getStatus();

    public void setValidationResult(String value);

    public String getValidationResult();

}

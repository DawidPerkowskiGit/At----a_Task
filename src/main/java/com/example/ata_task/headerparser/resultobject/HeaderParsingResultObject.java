package com.example.ata_task.headerparser.resultobject;

import com.example.ata_task.jsonresponse.CustomJsonSerializable;

/**
 * Implementation of this interface store data returned by HeaderParsing services
 */
public interface HeaderParsingResultObject extends CustomJsonSerializable {

    public void setValidated(Boolean value);

    public Boolean getValidated();

    public void setStatus(int value);

    public int getStatus();

    public void setValidationResult(String value);

    public String getValidationResult();

}

package com.example.ata_task.headerparser;

import com.example.ata_task.headerparser.resultobject.HeaderParsingResultObject;

/**
 * Common interface for parsing headers
 */
public interface HeaderParser {
    public HeaderParsingResultObject parseHeaders();
}

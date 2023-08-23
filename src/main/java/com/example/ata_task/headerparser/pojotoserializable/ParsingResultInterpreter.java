package com.example.ata_task.headerparser.pojotoserializable;

import com.example.ata_task.headerparser.resultobject.HeaderParsingResultObject;
import com.example.ata_task.jsonresponse.CustomJsonSerializable;

/**
 * Interface for  converter which parses header response to responseobject ready to be serialized.
 */
public interface ParsingResultInterpreter {

    /**
     * Parses Heder information
     * @param headerInfo header information responseobject
     * @return Object ready for JSON serialization
     */
   CustomJsonSerializable parseHeaderInfoToSerializableObject(HeaderParsingResultObject headerInfo);
}

package com.example.ata_task.headerparser.pojotoserializable;

import com.example.ata_task.headerparser.resultobject.HeaderParsingResultObject;
import com.example.ata_task.headerparser.resultobject.InvalidRequestJsonBody;
import com.example.ata_task.jsonresponse.CustomJsonSerializable;

/**
 * Implementation fo GitHubService header interpreter
 */
public class GitHubServiceHeaderInterpreter implements ParsingResultInterpreter {

    /**
     * Implementation for GitHub service header serialization
     * @param headerInfo header information responseobject
     * @return GitHub Service header information ready for serialization
     */
    @Override
    public CustomJsonSerializable parseHeaderInfoToSerializableObject(HeaderParsingResultObject headerInfo) {
        InvalidRequestJsonBody invalidRequestJsonBody = new InvalidRequestJsonBody();
        invalidRequestJsonBody.setStatus(headerInfo.getStatus());
        invalidRequestJsonBody.setMessage(headerInfo.getValidationResult());
        return invalidRequestJsonBody;
    }
}

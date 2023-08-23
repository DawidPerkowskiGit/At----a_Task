package com.example.ata_task.headerparser;

import com.example.ata_task.configuartion.GlobalVariables;
import com.example.ata_task.headerparser.resultobject.GitHubServiceHeaderParserResultObject;
import com.example.ata_task.headerparser.resultobject.HeaderParsingResultObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Implementation of Header parsing Service for GitHub
 */
@Component

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GithubServiceHeaderParser implements HeaderParser {

    Map<String, String> headers;

    /**
     * Parses the headers of the request
     * @return Result of parsing depending on if the "Accept" header was present and on its value.
     */

    public HeaderParsingResultObject parseHeaders() {

        HeaderParsingResultObject parsingResult = new GitHubServiceHeaderParserResultObject();

        /**
         * Missing "Accept" header
         */
        if (this.headers.containsKey(GlobalVariables.VALID_GH_SERVICE_HEADER) == false) {
            parsingResult.setValidated(false);
            parsingResult.setStatus(400);
            parsingResult.setValidationResult("Missing header information");
            return parsingResult;
        }

        /**
         * "Accept" header value is valid
         */
        if (this.headers.get(GlobalVariables.VALID_GH_SERVICE_HEADER).equals(GlobalVariables.VALID_GH_SERVICE_HEADER_FORMAT_VALUE)) {
            parsingResult.setValidated(true);
            parsingResult.setStatus(200);
            parsingResult.setValidationResult("Provided valid header information");
            return parsingResult;
        }

        /**
         * "Accept" header value is invalid
         */
        if (this.headers.get(GlobalVariables.VALID_GH_SERVICE_HEADER).equals(GlobalVariables.INVALID_GH_SERVICE_HEADER_FORMAT_VALUE)) {
            parsingResult.setValidated(false);
            parsingResult.setStatus(406);
            parsingResult.setValidationResult("XML format is unavailable");
            return parsingResult;
        }

        /**
         * "Accept" header value is unrecognizable
         */
        parsingResult.setValidated(false);
        parsingResult.setStatus(400);
        parsingResult.setValidationResult("Unrecognizable request, header value is invalid");
        return parsingResult;

    }
}

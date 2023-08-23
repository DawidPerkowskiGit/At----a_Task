package com.example.ata_task.headerparsertests;

import com.example.ata_task.headerparser.resultobject.GitHubServiceHeaderParserResultObject;
import com.example.ata_task.headerparser.GithubServiceHeaderParser;
import com.example.ata_task.headerparser.resultobject.HeaderParsingResultObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Testing the GitHubServiceHeaderParsing service
 */
@JsonTest
public class GitHubServiceHeaderParsingTests {

    public Map<String, String> headers = new HashMap<>();

    GithubServiceHeaderParser parser;
    @BeforeEach
    void setup() {
        headers.put("content-type", "application/xml;charset=utf-8");
        headers.put("content-length", "79");
        headers.put("date", "tue, 22 aug 2023 12:29:09 gmt");
        headers.put("keep-alive", "timeout=60");
        headers.put("connection", "keep-alive");
    }

    @Test
    @DirtiesContext
    void shouldReturnMissingHeaderInformationResponse() {
        HeaderParsingResultObject correctResult = new GitHubServiceHeaderParserResultObject();
        correctResult.setValidated(false);
        correctResult.setStatus(400);
        correctResult.setValidationResult("Missing header information");

        parser = new GithubServiceHeaderParser(headers);
        HeaderParsingResultObject parsingResult = parser.parseHeaders();
        assertThat(correctResult.getValidationResult()).isEqualTo(parsingResult.getValidationResult());
        assertThat(correctResult.getStatus()).isEqualTo(parsingResult.getStatus());
        assertThat(correctResult.getValidated()).isEqualTo(parsingResult.getValidated());
    }

    @Test
    @DirtiesContext
    void shouldReturnInvalidHeaderInformationResponse() {
        HeaderParsingResultObject correctResult = new GitHubServiceHeaderParserResultObject();
        correctResult.setValidated(true);
        correctResult.setStatus(200);
        correctResult.setValidationResult("Provided valid header information");
        headers.put("accept", "application/json");

        parser = new GithubServiceHeaderParser(headers);
        HeaderParsingResultObject parsingResult = parser.parseHeaders();
        assertThat(correctResult.getValidationResult()).isEqualTo(parsingResult.getValidationResult());
        assertThat(correctResult.getStatus()).isEqualTo(parsingResult.getStatus());
        assertThat(correctResult.getValidated()).isEqualTo(parsingResult.getValidated());
    }

    @Test
    @DirtiesContext
    void shouldReturnXmlFormatUnavailableResponse() {
        HeaderParsingResultObject correctResult = new GitHubServiceHeaderParserResultObject();
        correctResult.setValidated(false);
        correctResult.setStatus(406);
        correctResult.setValidationResult("XML format is unavailable");
        headers.put("accept", "application/xml");

        parser = new GithubServiceHeaderParser(headers);
        HeaderParsingResultObject parsingResult = parser.parseHeaders();
        assertThat(correctResult.getValidationResult()).isEqualTo(parsingResult.getValidationResult());
        assertThat(correctResult.getStatus()).isEqualTo(parsingResult.getStatus());
        assertThat(correctResult.getValidated()).isEqualTo(parsingResult.getValidated());
    }

    @Test
    @DirtiesContext
    void shouldReturnAcceptHeaderUnrecognizableResponse() {
        HeaderParsingResultObject correctResult = new GitHubServiceHeaderParserResultObject();
        correctResult.setValidated(false);
        correctResult.setStatus(400);
        correctResult.setValidationResult("Unrecognizable request, header value is invalid");
        headers.put("accept", "zxczx/xmasdasdl");

        parser = new GithubServiceHeaderParser(headers);
        HeaderParsingResultObject parsingResult = parser.parseHeaders();
        assertThat(correctResult.getValidationResult()).isEqualTo(parsingResult.getValidationResult());
        assertThat(correctResult.getStatus()).isEqualTo(parsingResult.getStatus());
        assertThat(correctResult.getValidated()).isEqualTo(parsingResult.getValidated());
    }
}

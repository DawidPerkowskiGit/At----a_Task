package com.example.ata_task.headerparse;

import com.example.ata_task.headerparser.pojotoserializable.GitHubServiceHeaderInterpreter;
import com.example.ata_task.headerparser.pojotoserializable.ParsingResultInterpreter;
import com.example.ata_task.headerparser.resultobject.GitHubServiceHeaderParserResultObject;
import com.example.ata_task.headerparser.resultobject.InvalidRequestJsonBody;
import com.example.ata_task.jsonresponse.GitHubServiceJsonSerializer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.Assertions.assertThat;
@JsonTest
public class JsonTests {
    private GitHubServiceHeaderParserResultObject result = new GitHubServiceHeaderParserResultObject();
    private ParsingResultInterpreter interpreter = new GitHubServiceHeaderInterpreter();

    private InvalidRequestJsonBody resultJsonBody = new InvalidRequestJsonBody();

    private GitHubServiceJsonSerializer serializer = new GitHubServiceJsonSerializer();



    @Test
    @DirtiesContext
    void shouldReturnCorrectMissingHeaderResponse() {
        result.setValidation(false);
        result.setStatus(400);
        result.setValidationResult("Missing header information");
        resultJsonBody = (InvalidRequestJsonBody) interpreter.parseHeaderInfoToSerializableObject(result);

        InvalidRequestJsonBody correctResponseBody= new InvalidRequestJsonBody();
        correctResponseBody.setStatus(400);
        correctResponseBody.setMessage("Missing header information");
        assertThat(correctResponseBody.getStatus()).isEqualTo(resultJsonBody.getStatus());
        assertThat(correctResponseBody.getMessage()).isEqualTo(resultJsonBody.getMessage());
    }

    @Test
    void shouldReturnCorrectMissingHeaderResponseJson() {
        InvalidRequestJsonBody correctResponseBody= new InvalidRequestJsonBody();
        correctResponseBody.setStatus(400);
        correctResponseBody.setMessage("Missing header information");

        String result = serializer.buildJsonFromPojo(correctResponseBody);
        String correctResult = """
                {"status":400,"message":"Missing header information"}""";
        assertThat(result).isEqualTo(correctResult);
    }
}

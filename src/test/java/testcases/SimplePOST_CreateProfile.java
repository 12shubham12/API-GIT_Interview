package testcases;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utility.BaseClass;
import utility.Helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class SimplePOST_CreateProfile {

    public static Response createProfile_POST(String endpoint) throws IOException {
        RequestSpecification requestSpecification = RestAssured.given().
                    //header("X-Telenor-CorrelationId", "value").
                    contentType(ContentType.JSON).
                    baseUri(endpoint).
                    body(Helper.read_Json_File(BaseClass.config.retrieveCreateProfile_InputFile())).
                    when();

        Response response = requestSpecification.post("/objects");

        //Saving the response in a file inside "ResponseFiles" folder
        File targetFileForString = new File("./ResponseFiles/api_data"+"PostAPI_CreateProfile"
                + Helper.getCurrentDateTime()+".json");

        //asPrettyString() method is used to print the response in actual json format which is more readable.
        Files.write(targetFileForString.toPath(), response.asPrettyString().getBytes());

        return response;

    }
}

package testcases;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utility.Helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class AddObject_POST {

    public static Response addObject(String endpoint) throws IOException {
        Response response = RestAssured.given().
                //header("","").
                contentType(ContentType.JSON).
                baseUri(endpoint).
                body("").
                when().
                post("").
                then().
                statusCode(200).
                extract().
                response();

        //Saving the response in a file inside "ResponseFiles" folder
        File targetFileForString = new File("./ResponseFiles/api_data"+"PostAPI_CreateProfile"
                + Helper.getCurrentDateTime()+".json");

        //asPrettyString() method is used to print the response in actual json format which is more readable.
        Files.write(targetFileForString.toPath(), response.asPrettyString().getBytes());

        return response;

    }
}

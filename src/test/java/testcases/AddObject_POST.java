package testcases;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import utility.ExcelDataProvider;
import utility.Helper;
import utility.JsonUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

public class AddObject_POST {

    public static Response addObject(String endpoint, String jsonBody) throws IOException {
        Response response = RestAssured.given().
                //header("","").
                contentType(ContentType.JSON).
                baseUri(endpoint).
                body(jsonBody).
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

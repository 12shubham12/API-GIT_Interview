package testcases;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class GET_SUNRiseAndSunSet_UsingBearerToken {


    public static Response getSunRiseAndSunSet(String endpoint) {
        Response response = RestAssured.given().
                //header("Authorization", "Bearer " + AuthUtils.getBearerToken()).
                contentType(ContentType.JSON).
                baseUri(endpoint).
                when().
                get("/json?lat=36.7201600&lng=-4.4203400").
                then().
                statusCode(200). //validate status code
                /*body(matchesJsonSchemaInClasspath(
                        "./src/test/resources/schemas/testSunSchema.json")).*/
                extract().
                response();


        System.out.println(response.prettyPrint());
        System.out.println(response.statusCode());
        System.out.println(response.getHeader("Authorization"));
        System.out.println(response.getContentType());
        return response;
    }

}
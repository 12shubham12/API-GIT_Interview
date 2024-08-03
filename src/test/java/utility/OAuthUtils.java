package utility;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class OAuthUtils {

    public static String getoAuthToken(){
        String tokenUrl = "";
        String clientId = "";
        String clientSecret = "";
        String username = "";
        String password = "";

        Response response = RestAssured.given().
            formParam("grant_type", "password").
            formParam("client_id", clientId).
            formParam("client_secret", clientSecret).
            formParam("username", username).
            formParam("password", password).
            when().
            post(tokenUrl).
            then().
            statusCode(200).
            extract().
            response();

        String accessToken = response.jsonPath().getString("access_token");
        return accessToken;

    }
}

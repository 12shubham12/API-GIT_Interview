package testcases;


import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BaseClass;
import utility.EndPointURLs;

import javax.mail.Header;
import java.io.IOException;

public class AllTestTogether extends BaseClass {

    @Test(priority =1)
    public void testBasicGet() throws IOException {
        Response response =SimpleGetRequest.getAPICall(EndPointURLs.base_URL_ST);

        //Validating the status code
        Assert.assertEquals(response.getStatusCode(), 200);

        //code to validate response body
        JsonPath jsonpath = new JsonPath(response.getBody().asString());

        //Validating simple field value
        String message = jsonpath.getString("Message");

        //validating complex json field value
        String name = jsonpath.getString("Results.find{it.Make_ID==4877}.Make_Name");

        //Assertion
        Assert.assertEquals(message, "Response returned successfully");
        Assert.assertEquals(name, "1/OFF KUSTOMS, LLC");
    }

    @Test(priority =2)
    public void testBasicPost_CreateProfile() throws IOException {
        Response response = SimplePOST_CreateProfile.createProfile_POST(EndPointURLs.base_URL_POST);

        //Validating the status code
        Assert.assertEquals(response.getStatusCode(), 200);

        //Validating the Response Header
        String response_ContentType = response.getHeader("Content-Type");
        Assert.assertEquals(response_ContentType,"application/json");
        String response_Cookies = response.getCookie("session");
        Assert.assertEquals(response_Cookies,null);
        Headers headers = response.getHeaders();
        System.out.println(headers);
        String authToken = response.getHeader("Authorization");
        Assert.assertEquals(authToken,null);
    }
}

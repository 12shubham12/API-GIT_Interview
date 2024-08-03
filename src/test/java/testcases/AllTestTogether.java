package testcases;


import io.qameta.allure.Allure;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BaseClass;
import utility.EndPointURLs;

import java.io.IOException;

public class AllTestTogether extends BaseClass {


    @Test(priority =1)
    public void test_POSTaddObject() throws IOException {
        Response response = AddObject_POST.addObject(EndPointURLs.base_URL_POST);

        //Validating the status code
        Assert.assertEquals(response.getStatusCode(), 200);

        //Validating the Response Header
        String response_ContentType = response.getHeader("Content-Type");
        Assert.assertEquals(response_ContentType,"text/plain;charset=UTF-8");
        String response_Cookies = response.getCookie("session");
        Assert.assertEquals(response_Cookies,null);
        Headers headers = response.getHeaders();
        System.out.println(headers);
        String authToken = response.getHeader("Authorization");
        Assert.assertEquals(authToken,null);
    }
    @Test(priority=2)
    public void test_GetSunRiseAndSunSet(){
        Response response = GET_SUNRiseAndSunSet_UsingBearerToken.getSunRiseAndSunSet(EndPointURLs.base_URL_SunRiseAndSunSet);
        Assert.assertEquals(response.getHeader("Authorization"), null);
        Assert.assertEquals(response.getCookie("session"), null);

        //validating response body
        Assert.assertEquals(response.jsonPath().getString("status"), "OK");
        Assert.assertEquals(response.jsonPath().getString("results.sunrise"), "5:24:15 AM");
        //Attach Response body to the Allure report
        Allure.addAttachment("API Response", "application/json", response.getBody().asInputStream(),
                "json");
    }
    @Test(priority=3)
    public void test_GetSunRiseAndSunSet2(){
        Response response = GET_SUNRiseAndSunSet_UsingOAuthToken.getSunRiseAndSunSet(EndPointURLs.base_URL_SunRiseAndSunSet);
        Assert.assertEquals(response.getHeader("Authorization"), null);
        Assert.assertEquals(response.getCookie("session"), null);
        //Attach Response body to the Allure report
        Allure.addAttachment("API Response", "application/json", response.getBody().asInputStream(),
                "json");

        //validating response body
        Assert.assertEquals(response.jsonPath().getString("status"), "OK");
        Assert.assertEquals(response.jsonPath().getString("results.sunrise"), "5:24:15 AM");

        //Attach Response body to the Allure report
        Allure.addAttachment("API Response", "application/json", response.getBody().asPrettyString(),
                "json");

        // Attach API response logs
        Allure.addAttachment("API Response Logs", "text/plain", response.getBody().asPrettyString(),
                "txt");

    }
}

package com.darisky.apitest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class ApiAutoTest {
    private static final String appId = "63a804408eb0cb069b57e43a";
    public ApiAutoTest(){
        RestAssured.baseURI = "https://dummyapi.io/data/v1/";
    }

    public Response createNewUser(JSONObject payLoad) {
        return given().log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("app-id", appId)
                .body(payLoad.toString())
                .when().post("user/create");
    }

    public Response getUserById(String userId){
        return given().log().all()
                .header("app-id", appId)
                .when().get("user/" + userId);
    }

    public Response updateUserName(String userId, JSONObject payLoad){
        return given().log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("app-id", appId)
                .body(payLoad.toString())
                .when().put("user/" + userId);
    }

    public Response deleteUser(String userId){
        return given().log().all()
                .header("app-id", appId)
                .when().delete("user/" + userId);
    }
}

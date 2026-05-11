package com.darisky.apitest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class ApiAutoTest {
    private static final String TOKEN = "fe2c37a524da738117b22599f74b388b14a4be0859778f2ebdf6f03f52f2b318";
    public ApiAutoTest(){
        RestAssured.baseURI = "https://gorest.co.in/public/v2/";
    }

    public Response createNewUser(JSONObject payLoad) {
        return given().log().all()
                .header("Authorization", "Bearer " + TOKEN)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(payLoad.toString())
                .when().post("users");
    }

    public Response getUserById(String userId){
        return given().log().all()
                .header("Authorization", "Bearer " + TOKEN)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .when().get("users/" + userId);
    }

    public Response updateUserName(String userId, JSONObject payLoad){
        return given().log().all()
                .header("Authorization", "Bearer " + TOKEN)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(payLoad.toString())
                .when().put("users/" + userId);
    }

    public Response deleteUser(String userId){
        return given().log().all()
                .header("Authorization", "Bearer " + TOKEN)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .when().delete("users/" + userId);
    }
}

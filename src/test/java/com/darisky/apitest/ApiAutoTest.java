package com.darisky.apitest;

import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class ApiAutoTest {
    public static final Dotenv dotEnv = Dotenv.configure().ignoreIfMissing().load();
    public static String getValidToken() {
        String token = dotEnv.get("TOKEN");
        if (token == null || token.trim().isEmpty()) {
            token = System.getenv("TOKEN");
        }
        return token;
    }
    public static final String gorestToken = getValidToken();

    public ApiAutoTest(){
        RestAssured.baseURI = "https://gorest.co.in/public/v2/";
    }

    public Response createNewUser(JSONObject payLoad) {
        return given().log().all()
                .header("Authorization", "Bearer " + gorestToken)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(payLoad.toString())
                .when().post("users");
    }

    public Response getUserById(String userId){
        return given().log().all()
                .header("Authorization", "Bearer " + gorestToken)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .when().get("users/" + userId);
    }

    public Response updateUserName(String userId, JSONObject payLoad){
        return given().log().all()
                .header("Authorization", "Bearer " + gorestToken)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(payLoad.toString())
                .when().put("users/" + userId);
    }

    public Response deleteUser(String userId){
        return given().log().all()
                .header("Authorization", "Bearer " + gorestToken)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .when().delete("users/" + userId);
    }
}

package com.darisky.apitest;

import io.github.cdimascio.dotenv.Dotenv;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

public class ApiAutoTest {
    private static final String TOKEN = getToken();

    private static String getToken() {
        String envToken = System.getenv("TOKEN");
        if (envToken != null && !envToken.isEmpty()) {
            System.out.println("TOKEN loaded from environment variable");
            return envToken;
        }
        try {
            Dotenv dotenv = Dotenv.load();
            String dotenvToken = dotenv.get("TOKEN");
            if (dotenvToken != null && !dotenvToken.isEmpty()) {
                System.out.println("TOKEN loaded from .env file");
                return dotenvToken;
            }
        } catch (Exception e) {
            System.out.println("Could not load .env file");
        }
        throw new RuntimeException("TOKEN not found in environment or .env file!");
    }

    public ApiAutoTest(){
        RestAssured.baseURI = "https://gorest.co.in/public/v2/";
        System.out.println("DEBUG - Is the App ID completely null? " + (getToken() == null));
        System.out.println("DEBUG - Is the App ID empty? " + TOKEN.isEmpty());
    }

    public Response createNewUser(JSONObject payLoad) {
        return given().log().all()
                .header("Authorization", "Bearer " + ApiAutoTest.TOKEN)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(payLoad.toString())
                .when().post("users");
    }

    public Response getUserById(String userId){
        return given().log().all()
                .header("Authorization", "Bearer " + ApiAutoTest.TOKEN)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .when().get("users/" + userId);
    }

    public Response updateUserName(String userId, JSONObject payLoad){
        return given().log().all()
                .header("Authorization", "Bearer " + ApiAutoTest.TOKEN)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(payLoad.toString())
                .when().put("users/" + userId);
    }

    public Response deleteUser(String userId){
        return given().log().all()
                .header("Authorization", "Bearer " + ApiAutoTest.TOKEN)
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .when().delete("users/" + userId);
    }
}

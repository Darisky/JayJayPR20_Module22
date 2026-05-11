package com.darisky.apitest.stepdefs;

import com.darisky.apitest.ApiAutoTest;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.JSONObject;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertEquals;

public class ApiTestStepdefs {
    ApiAutoTest userServices = new ApiAutoTest();
    Faker faker = new Faker();
    private String newUserId;
    private Response theResponse;

    @Given("the DummyAPI endpoint is configured")
    public void theDummyAPIEndpointIsConfigured() {
    }

    @When("I create a new user with the name {string} Gender {string} Status {string}")
    public void iCreateANewUserWithTheNameGenderStatus(String name, String gender, String status) {
        String randomEmail = faker.internet().emailAddress();
        System.out.println("Generated Email " + randomEmail);

        JSONObject newUser = new JSONObject();
        newUser.put("name", name);
        newUser.put("email", randomEmail);
        newUser.put("gender", gender);
        newUser.put("status", status);

        theResponse = userServices.createNewUser(newUser);

    }

    @Then("the user is successfully created and an ID is returned")
    public void theUserIsSuccessfullyCreatedAndAnIDIsReturned() {
        theResponse.then()
                .assertThat().statusCode(201);

        newUserId = theResponse.jsonPath().getString("id");
        System.out.println("<------SUCCESS: User created with ID: " + newUserId + "------>");
    }

    @When("I fetch the user using the generated ID")
    public void iFetchTheUserUsingTheGeneratedID() {
        theResponse.then().assertThat()
                .body(matchesJsonSchemaInClasspath("SchemaValidator.json"));
        theResponse = userServices.getUserById(newUserId);
        System.out.println("<------ SUCCESS Validating Schema for user: " + newUserId + "------>");
    }

    @Then("the API should return status code {int}")
    public void theAPIShouldReturnStatusCode(int expectedResponse) {
        theResponse.then().log().all()
                .assertThat().statusCode(expectedResponse);
        System.out.println("<------SUCCESS: Showing Created User ------>");
    }

    @When("I update the user's first name to {string}")
    public void iUpdateTheUserSFirstNameTo(String newName) {
        JSONObject newUserData = new JSONObject();
        newUserData.put("name", newName);
        theResponse = userServices.updateUserName(newUserId, newUserData);
    }

    @Then("the user is successfully updated with updated name {string}")
    public void theUserIsSuccessfullyUpdatedWithUpdatedName(String newName) {
        theResponse.then().log().all()
                .assertThat().statusCode(200);
        String actualFirstName = theResponse.jsonPath().getString("name");
        assertEquals("The name did not update correctly!", actualFirstName,newName);
    }


    @And("I delete the user using the generated ID to clean up data")
    public void iDeleteTheUserUsingTheGeneratedIDToCleanUpData() {
        theResponse = userServices.deleteUser(newUserId);
        theResponse.then().assertThat().statusCode(204);

        System.out.println("<------ CLEANUP SUCCESS: User " + newUserId + " has been permanently deleted. ------>");
    }
}

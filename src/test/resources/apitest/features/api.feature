@api
  Feature: Gorest Api Test Automation
    Scenario: Create Read Update Delete user
      Given the DummyAPI endpoint is configured
      When I create a new user with the name "Den" Gender "Male" Status "Active"
      Then the user is successfully created and an ID is returned
      When I fetch the user using the generated ID
      Then the API should return status code 200
      When I update the user's first name to "Den the Emperor"
      Then the user is successfully updated with updated name "Den the Emperor"
      And I delete the user using the generated ID to clean up data
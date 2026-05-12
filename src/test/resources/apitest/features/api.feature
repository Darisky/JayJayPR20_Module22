@api
  Feature: Gorest Api Test Automation
    Scenario: Create Read Update Delete user
      Given the DummyAPI endpoint is configured
      When I create a new user with the title "mr", first name "Den", last name "Ned" and a randomly generated email
      Then the user is successfully created and an ID is returned
      When I fetch the user using the generated ID
      Then the API should return status code 200
      When I update the user's first name to "DentheEmperor"
      Then the user is successfully updated with updated name "DentheEmperor"
      And I delete the user using the generated ID to clean up data
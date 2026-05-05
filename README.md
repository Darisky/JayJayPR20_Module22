# JayJay PR19 Module 21 : GitHub Action WebUI Automation Test
This sample task for Automation test login in DemoBlaze.com

## Dependencies
* **Selenium** version 4.18.1
* **Cucumber** JUnit version 7.34.3
* **Cucumber** Java version 7.34.3
* **JUnit** API version 6.0.3
* **JUnit** Engine version 6.0.3

## Test Explanation
This test running with Cucumber with Gherkin format as scenario
Add GitHub Action

### User login with valid credential
- User in Home Page at DemoBlaze.com
- User Click Login Button
- User Input Valid Credential (User and Password)
- User Click login Button at Credential Field
- User see "Welcome "

### User login with invalid credential
- User in Home Page at DemoBlaze.com
- User Click Login Button
- User Input inValid Credential (User and Password)
- User Click login Button at Credential Field
- User see error message "User does not exist."

### User login without credential
- User in Home Page at DemoBlaze.com
- User Click Login Button
- User skip input Credential (User and Password)
- User Click login Button at Credential Field
- User see error message "Please fill out Username and Password."

## Test Report Option
- Html (reports/html/)
- Json (reports/json/)
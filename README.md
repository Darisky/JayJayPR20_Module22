# JayJay PR20 Module 22 : GitHub Action WebUI Automation Test
This sample task for Automation Test login in DemoBlaze.com,
Automation API Test in Gorest.co.in

## Dependencies
* **Selenium** version 4.18.1
* **Cucumber** JUnit version 7.34.3
* **Cucumber** Java version 7.34.3
* **JUnit** API version 6.0.3
* **JUnit** Engine version 6.0.3
* **Faker** Email Faker 1.0.2
* **DOTENV** Dot env connector 3.0.0

## Test Explanation
This test running with Cucumber with Gherkin format as scenario
Web Ui Automation Test About Create, Read, Update, and Delete

Add GitHub Action

## WEB UI Test
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

## API Automation Test
### CRUD
- Create new user
- Read/Get new user by get new id
- validating with Json Schema validator
- Update for first name
- Delete user by id

## Test Report Option
- Html (reports/html/)
- Json (reports/json/)
- Artefact (reports/)
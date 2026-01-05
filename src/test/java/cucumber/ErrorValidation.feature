Feature: Error Validation
Background:
Given I landed on Ecommerce page 

@Regression
Scenario Outline: Error Validation
Given  Logged in with username <name> and password <pwd>
When I add product <productName> from cart
Then  "Incorrect email password" message is displayed

Example:
|name                        | password       |
|jackthesparrow0071@gmail.com| #Sameerpolice1 |

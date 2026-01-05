Feature:Purchase the order from Ecpmmerce Website
i want to use this template for my feature file

Background:
Given I landed on Ecommerce page 

Scenario Outline:  Positive test of submitting the order
Given  Logged in with username <name> and password <pwd>
When I add product <productName> from cart

Examples:
|name                        | password       |
|jackthesparrow0071@gmail.com| #Sameerpolice1 |

Feature: Validate accessToken by login

Scenario: Varify login API
Given Login API
When Login Execute "/api-clients/" and provide accessToken
Then Successfully Login with status code 201
And Varify accessToken

Scenario: order a book
Given Login Successfully with accessToken
When book a order "/orders" and fetch orderId
Then Varify status code 201
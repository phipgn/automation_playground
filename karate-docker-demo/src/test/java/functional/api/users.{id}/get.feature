Feature: Get single user by Id

    Background: 
        Given url baseUrl

    Scenario: 200 Happy case
        * def id = 2
        * path '/api/users', id
        * method get
        * status 200
    
    Scenario: Id must match
        * def id = 2
        * path '/api/users', id
        * method get
        * match response.data.id == id

    Scenario: 404 user not found
        * def id = 23
        * path '/api/users', id
        * method get
        * status 404
        * match response == {}
Feature: Create user

    Background:
        * url baseUrl

    Scenario Outline: 201 happy case: <name> <job>
        * def name = '<name>'
        * def job = '<job>'
        * def payload =
        """
        {
            name: #(name),
            job: #(job)
        }
        """
        * path '/api/users'
        * request payload
        * method post
        * status 201
        * match response ==
        """
        {
            name: #(name),
            job: #(job),
            id: '#string',
            createdAt: '#string'
        }
        """

        Examples:
        | name        | job |
        | Ngo Vinh Ky | IT  |
        | Phi         | QA  |
        | Nam         | Dev |
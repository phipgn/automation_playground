Feature: 

    Background:
        * url baseUrl

    Scenario:
        * def name = 'phipgn'
        * def job = 'QA'
        * path 'api/users'
        * request { name:'#(name)', job:'#(job)' }
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

Feature: Test

    Background:
        * url baseUrl

    Scenario Outline: List users        
        * path '/api/users'
        * param page = <page>
        * method get
        * status 200
        * match response ==
        """
        {
            page: <page>,
            per_page: 6,
            total: 12,
            total_pages: 2,
            data: '#[]',
            support: {
                url: '#string',
                text: '#string'
            }
        }
        """
        * match each response.data ==
        """
        {
            id: '#number',
            email: '#string',
            first_name: '#string',
            last_name: '#string',
            avatar: '#string'
        }
        """
        * match response.data[1].email == 'george.bluth@reqres.in'

        Examples:
            | page |
            | 2    |
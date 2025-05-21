Feature: List users

    Background:
        * url baseUrl

    Scenario Outline: 200 happy case: page=<page>
        * def page = <page>
        * path 'api/users'
        * param page = page
        * method GET
        * status 200
        * match response.page == page
        * match response ==
        """
        {
            page: '#number',
            per_page: 6,
            total: '#number',
            total_pages: '#number',
            data: '#[6]',
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

        Examples:
        | page |
        | 1    |
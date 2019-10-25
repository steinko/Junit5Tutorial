describe("test api of Item component",()=> { 
    

	it('should return index',() => {

		let env = Cypress.env('url')
		let url

		if(env == 'dev') {
			url = 'http://localhost:8080/'
		}
		if(env == 'test') {
			url = 'https://enduring-honor-256422.appspot.com/'
		}

		if (env != 'dev' && env != 'test') { throw "Wrong enviromet parameter value"  }

	   cy.request(url).as('message')
	   cy.get('@message').should((response) => {
	      expect(response.status).to.eq(200)
          expect(response.body).to.eq('index')
	     
       })
	})
})
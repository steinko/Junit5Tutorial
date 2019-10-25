describe("test api of Item component",()=> { 
    

	it('should return index',() => {
	   cy.request('http://localhost:8080/').as('message')
	   cy.get('@message').should((response) => {
	      expect(response.status).to.eq(200)
          expect(response.body).to.eq('index')
	     
       })
	})
})
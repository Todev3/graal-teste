package org.acme;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.acme.model.Person;
import org.acme.service.PersonService;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonController {
	
	@Inject
	private PersonService personService;
	
    @GET
    @Path("/{name}")
    public Response get(@PathParam String name) {
    	return Response.ok(personService.findPerson(name)).build();
    }
    
    @POST
    public Response create(Person person) {
    	personService.create(person);
    	return Response.ok().build();
    }
    
}
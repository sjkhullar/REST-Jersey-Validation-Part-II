
package org.learn.resource;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.ValidationException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.learn.annotation.ValidAddress;
import org.learn.model.Address;


@Path("/student")
public class StudentResource {

	private static final String text = "Message from Server :\n%s";

	@GET
	@Consumes(MediaType.TEXT_PLAIN)
	public Response registerStudent() {
		String response = String.format(text, new Date());
		return Response.status(Response.Status.OK).entity(response).type(MediaType.TEXT_PLAIN).build();
	}	

    @POST
    @Path("/address")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerAddress(
            @Valid @ValidAddress Address address) throws ValidationException {

        String response = String.format(text, address);
        return Response.status(Response.Status.OK).entity(response).type(MediaType.TEXT_PLAIN).build();
    }
}

package com.company.example;

import com.company.example.database.tables.*;
import com.company.example.services.UserService;
import io.dropwizard.auth.Auth;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource{

    private final UserService userService;

    @GET
    @Path("user/{userId}")
    public Response userIdMethod(Integer userId)
            throws AdminException {
        return new UserService().getUserManager().findById(userId)
    }
}
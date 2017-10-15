package com.config;

import com.beans.User;
import com.dao.UserDAO;
import com.factory.Factory;

import javax.annotation.Priority;
import javax.security.sasl.AuthenticationException;
import javax.ws.rs.Priorities;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.nio.charset.Charset;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class BasicAuthFilter implements ContainerRequestFilter {

    private UserDAO userDAO = Factory.getUserDAO();

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        String authentication = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        if (authentication == null) {
            Response unauthorizedAuth = Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Authentication credentials are required")
                    .build();
            requestContext.abortWith(unauthorizedAuth);
            return;
        }

        if (!authentication.startsWith("Basic ")) {
            return;
        }

        authentication = authentication.substring("Basic ".length());
        String[] values = new String(DatatypeConverter.parseBase64Binary(authentication),
                Charset.forName("ASCII")).split(":");
        if (values.length < 2) {
            throw new WebApplicationException(400);
        }

        String username = values[0];
        String password = values[1];

        User user = userDAO.getUserByLogin(username, password /*password needs to be hashed before call to method*/);
        if (user == null) {
            Response unauthorizedAuth = Response.status(Response.Status.UNAUTHORIZED)
                    .entity("Access unauthorized! Username or password incorrect!")
                    .build();
            requestContext.abortWith(unauthorizedAuth);
        }

        requestContext.setSecurityContext(new MySecurityContext(user));
    }
}

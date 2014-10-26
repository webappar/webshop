package com.project.webshop.service;

import com.project.webshop.model.Customer;

import java.util.List;

import org.json.simple.JSONObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * DAO providing customer through the RESTful API
 *
 */
@Path("customer")
public class CustomerDAO extends GenericDAO<Customer, String> {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(final JSONObject json) {
        Customer cust = new Customer(
                json.get("userName").toString(),
                json.get("userEmail").toString(),
                json.get("password").toString());

        super.save(cust);
        return Response.noContent().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(final JSONObject json) {
        Customer cust = new Customer(
                json.get("userName").toString(),
                json.get("userEmail").toString(),
                json.get("password").toString());

        super.update(cust);
        return Response.noContent().build();
    }

    @DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") final String id) {
        super.delete(new Customer(id));
        return Response.noContent().build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") final String id) {
        Customer customer = super.find(Customer.class, id);
        return (customer != null)
                ? Response.ok(customer).build()
                : Response.noContent().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<Customer> customer = super.findAll(Customer.class);
        return (customer != null)
                ? Response.ok(customer).build()
                : Response.noContent().build();
    }

    @GET
    @Path("range")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findRange(@QueryParam("fst") final int fst, @QueryParam("count") final int count) {
        List<Customer> customer = super.findRange(Customer.class, fst, count);
        return (customer != null)
                ? Response.ok(customer).build()
                : Response.noContent().build();
    }

    @GET
    @Path("count")
    @Produces(MediaType.APPLICATION_JSON)
    public Response count() {
        int count = super.count(Customer.class);
        JSONObject json = new JSONObject();
        json.put("value", count);
        return (count != -1)
                ? Response.ok(json).build()
                : Response.noContent().build();
    }
}

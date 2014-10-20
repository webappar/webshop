package com.project.webshop.service;

import com.project.webshop.model.Customer;

import java.util.List;

import org.json.simple.JSONObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 */
@Path("customer")
public class CustomerDAO extends GenericDAO<Customer, String> {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void save(final JSONObject json) {
        Customer cust = new Customer(
                json.get("userName").toString(),
                json.get("userEmail").toString(),
                json.get("password").toString());
        super.save(cust);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(final JSONObject json) {
        Customer cust = new Customer(
                json.get("userName").toString(),
                json.get("userEmail").toString(),
                json.get("password").toString());
        super.update(cust);
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") final String id) {
        Customer customer = new Customer();
        customer.setUserName(id);
        super.delete(customer);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") final String id) {
        Customer customer;
        customer = super.find(Customer.class, id);
        return (customer != null)
                ? Response.ok(customer).build()
                : Response.noContent().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<Customer> customer;
        customer = super.findAll(Customer.class);
        return (customer != null)
                ? Response.ok(customer).build()
                : Response.noContent().build();
    }

    @GET
    @Path("range")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findRange(@QueryParam("fst") final int fst, @QueryParam("count") final int count) {
        List<Customer> customer;
        customer = super.findRange(Customer.class, fst, count);
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

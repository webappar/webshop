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

    @DELETE
    @Path("{id}")
    public void deleteCustomer(@PathParam("id") final String id) {
        Customer customer = new Customer();
        customer.setUserName(id);
        delete(customer);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomer(@PathParam("id") final String id) {
        Customer customer = null;
        customer = find(Customer.class, id);
        return (customer != null)
                ? Response.ok(customer).build()
                : Response.noContent().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCustomers() {
        List<Customer> customer;
        customer = findAll(Customer.class);
        return (customer != null)
                ? Response.ok(customer).build()
                : Response.noContent().build();
    }

    @GET
    @Path("count")
    @Produces(MediaType.APPLICATION_JSON)
    public Response count() {
        List<Customer> customer;
        customer = findAll(Customer.class);
        JSONObject json = new JSONObject();
        json.put("value", customer.size());
        return (customer != null)
                ? Response.ok(json).build()
                : Response.noContent().build();
    }
}

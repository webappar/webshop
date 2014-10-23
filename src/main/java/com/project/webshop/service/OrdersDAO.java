package com.project.webshop.service;

import com.project.webshop.model.Orders;

import org.json.simple.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 *
 */
@Path("orders")
public class OrdersDAO extends GenericDAO<Orders, Integer> {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(final JSONObject json) {
        Orders order = new Orders(
                (int)json.get("ordDate"),
                json.get("ordUser").toString());

        super.save(order);
        return Response.noContent().build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(final JSONObject json) {
        Orders order = new Orders(
                (int)json.get("ordDate"),
                json.get("ordUser").toString());

        super.update(order);
        return Response.noContent().build();
    }

    /*@DELETE
    @Path("{id}")
    public Response delete(@PathParam("id") final int id) {
        //super.delete(new Orders());
        return Response.noContent().build();
    }*/

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") final int id) {
        Orders order = super.find(Orders.class, id);
        return (order != null)
                ? Response.ok(order).build()
                : Response.noContent().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<Orders> order = super.findAll(Orders.class);
        return (order != null)
                ? Response.ok(order).build()
                : Response.noContent().build();
    }

    @GET
    @Path("range")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findRange(@QueryParam("fst") final int fst, @QueryParam("count") final int count) {
        List<Orders> order = super.findRange(Orders.class, fst, count);
        return (order != null)
                ? Response.ok(order).build()
                : Response.noContent().build();
    }

    @GET
    @Path("count")
    @Produces(MediaType.APPLICATION_JSON)
    public Response count() {
        int count = super.count(Orders.class);
        JSONObject json = new JSONObject();
        json.put("value", count);
        return (count != -1)
                ? Response.ok(json).build()
                : Response.noContent().build();
    }
}

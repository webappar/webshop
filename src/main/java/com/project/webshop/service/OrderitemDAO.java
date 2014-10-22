package com.project.webshop.service;

import com.project.webshop.model.Orderitem;
import org.json.simple.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 *
 */
@Path("orderitem")
public class OrderitemDAO extends GenericDAO<Orderitem, String> {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<Orderitem> orderItem = super.findAll(Orderitem.class);
        return (orderItem != null)
                ? Response.ok(orderItem).build()
                : Response.noContent().build();
    }

    @GET
    @Path("range")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findRange(@QueryParam("fst") final int fst, @QueryParam("count") final int count) {
        List<Orderitem> orderItem = super.findRange(Orderitem.class, fst, count);
        return (orderItem != null)
                ? Response.ok(orderItem).build()
                : Response.noContent().build();
    }

    @GET
    @Path("count")
    @Produces(MediaType.APPLICATION_JSON)
    public Response count() {
        int count = super.count(Orderitem.class);
        JSONObject json = new JSONObject();
        json.put("value", count);
        return (count != -1)
                ? Response.ok(json).build()
                : Response.noContent().build();
    }
}

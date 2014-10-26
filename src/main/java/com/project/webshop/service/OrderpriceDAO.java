package com.project.webshop.service;

import com.project.webshop.model.Orderprice;

import org.json.simple.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * DAO providing orderprice through the RESTful API
 *
 */
@Path("orderprice")
public class OrderpriceDAO extends GenericDAO<Orderprice, String> {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<Orderprice> orderPrice = super.findAll(Orderprice.class);
        return (orderPrice != null)
                ? Response.ok(orderPrice).build()
                : Response.noContent().build();
    }

    @GET
    @Path("range")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findRange(@QueryParam("fst") final int fst, @QueryParam("count") final int count) {
        List<Orderprice> orderPrice = super.findRange(Orderprice.class, fst, count);
        return (orderPrice != null)
                ? Response.ok(orderPrice).build()
                : Response.noContent().build();
    }

    @GET
    @Path("count")
    @Produces(MediaType.APPLICATION_JSON)
    public Response count() {
        int count = super.count(Orderprice.class);
        JSONObject json = new JSONObject();
        json.put("value", count);
        return (count != -1)
                ? Response.ok(json).build()
                : Response.noContent().build();
    }
}

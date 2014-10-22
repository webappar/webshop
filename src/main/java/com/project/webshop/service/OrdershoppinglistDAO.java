package com.project.webshop.service;

import com.project.webshop.model.Ordershoppinglist;
import org.json.simple.JSONObject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 *
 */
@Path("ordershoppinglist")
public class OrdershoppinglistDAO extends GenericDAO<Ordershoppinglist, String> {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<Ordershoppinglist> ordershoppinglist = super.findAll(Ordershoppinglist.class);
        return (ordershoppinglist != null)
                ? Response.ok(ordershoppinglist).build()
                : Response.noContent().build();
    }

    @GET
    @Path("range")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findRange(@QueryParam("fst") final int fst, @QueryParam("count") final int count) {
        List<Ordershoppinglist> ordershoppinglist = super.findRange(Ordershoppinglist.class, fst, count);
        return (ordershoppinglist != null)
                ? Response.ok(ordershoppinglist).build()
                : Response.noContent().build();
    }

    @GET
    @Path("count")
    @Produces(MediaType.APPLICATION_JSON)
    public Response count() {
        int count = super.count(Ordershoppinglist.class);
        JSONObject json = new JSONObject();
        json.put("value", count);
        return (count != -1)
                ? Response.ok(json).build()
                : Response.noContent().build();
    }
}

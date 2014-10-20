package com.project.webshop.service;

import com.project.webshop.model.Products;

import java.util.List;

import org.json.simple.JSONObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 */
@Path("products")
public class ProductsDAO extends GenericDAO<Products, Integer> {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void save(final JSONObject json) {
        Products prod = new Products(
                (int)json.get("artNr"),
                json.get("proName").toString(),
                (int)json.get("price"),
                json.get("url").toString(),
                json.get("description").toString());

        super.save(prod);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(final JSONObject json) {
        Products prod = new Products(
                (int)json.get("artNr"),
                json.get("proName").toString(),
                (int)json.get("price"),
                json.get("url").toString(),
                json.get("description").toString());

        super.update(prod);
    }

    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") final int id) {
        super.delete(new Products(id));
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") final int id) {
        Products product = super.find(Products.class, id);
        return (product != null)
                ? Response.ok(product).build()
                : Response.noContent().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        List<Products> product = super.findAll(Products.class);
        return (product != null)
                ? Response.ok(product).build()
                : Response.noContent().build();
    }

    @GET
    @Path("range")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findRange(@QueryParam("fst") final int fst, @QueryParam("count") final int count) {
        List<Products> product = super.findRange(Products.class, fst, count);
        return (product != null)
                ? Response.ok(product).build()
                : Response.noContent().build();
    }

    @GET
    @Path("count")
    @Produces(MediaType.APPLICATION_JSON)
    public Response count() {
        int count = super.count(Products.class);
        JSONObject json = new JSONObject();
        json.put("value", count);
        return (count != -1)
                ? Response.ok(json).build()
                : Response.noContent().build();
    }
}

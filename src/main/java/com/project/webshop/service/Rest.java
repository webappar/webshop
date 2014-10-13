package com.project.webshop.service;

import com.project.webshop.model.Customer;

import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.hibernate.Session;
import org.hibernate.HibernateException;

/**
 * TODO: Refactor till DAO-struktur?
 *
 * Hibernate: https://docs.jboss.org/hibernate/orm/4.3/manual/en-US/html/
 *
 * Jersey: https://jersey.java.net/documentation/latest/index.html
 */
@Path("/")
public class Rest {

    Session session;

    public Rest() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    @GET
    @Path("customer")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCustomers() {
        List<Customer> customer = null;
        try {
            session.beginTransaction();
            customer = session.createQuery("from Customer").list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            session.getTransaction().rollback();
        } //finally { session.close(); } session already closed?
        return (customer != null)
                ? Response.ok().entity(customer).build()
                : Response.noContent().build();
    }
}

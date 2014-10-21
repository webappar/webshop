package com.project.webshop;

import com.project.webshop.model.Customer;
import com.project.webshop.model.Orders;
import com.project.webshop.model.Products;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.json.simple.JSONObject;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.List;

/**
 * Test the RESTful service
 *
 */
public class RestClientTest {

    private static final String REST_SERVICE_URL = "http://localhost:8080/rest/";

    private Client client = ClientBuilder.newClient().register(JacksonFeature.class);

    // Random existing customer from database
    private static final String USERNAME = "Britt-Erik";
    private static final String EMAIL = "BrerikMail";
    private static final String PASSWORD = "w123p";

    // Random existing product from database
    private static final int ARTNR = 10987;
    private static final String PRONAME = "PolarBear";
    private static final int PRICE = 30;
    private static final String URL = "PolarBear.jpg";
    private static final String DESCRIPTION = "djur";

    // Random existing order from database
    private static final int ORDNR = 10;
    private static final String ORDUSER = "Karlgren";

    @Test
    public void testGetCustomer() {

        // 1. Fetch customer by id
        Customer cust = client.target(REST_SERVICE_URL).path("customer/{id}").resolveTemplate("id", USERNAME).request().get(Customer.class);
        assertThat(cust, notNullValue());
        assertThat(cust.getUserName(), equalTo(USERNAME));
        assertThat(cust.getUserEmail(), equalTo(EMAIL));
        assertThat(cust.getPassword(), equalTo(PASSWORD));

        // 2. Fetch all customers incl. total amount
        GenericType<List<Customer>> customerType = new GenericType<List<Customer>>() {
        }; // generic type to wrap a generic list of customers
        List<Customer> customers = client.target(REST_SERVICE_URL).path("customer").request().get(customerType);
        JSONObject json = client.target(REST_SERVICE_URL).path("customer/count").request().get(JSONObject.class);
        assertEquals(customers.size(), (int)json.get("value"));

        // 3. Fetch range of customers
        GenericType<List<Customer>> customerTypeR = new GenericType<List<Customer>>() {
        }; // generic type to wrap a generic list of customers
        final URI uri = UriBuilder.fromUri(REST_SERVICE_URL + "customer/range?fst={fst}&count={count}")
                .resolveTemplate("fst", "1")
                .resolveTemplate("count", "3").build();
        List<Customer> customersR = client.target(uri).request().get(customerTypeR);
        assertEquals(customersR.size(), 3);
    }

    @Test
    public void testGetProducts() {

        // 1. Fetch product by id
        Products prod = client.target(REST_SERVICE_URL).path("products/{id}").resolveTemplate("id", ARTNR).request().get(Products.class);
        assertThat(prod, notNullValue());
        assertThat(prod.getArtNr(), equalTo(ARTNR));
        assertThat(prod.getProName(), equalTo(PRONAME));
        assertThat(prod.getPrice(), equalTo(PRICE));
        assertThat(prod.getUrl(), equalTo(URL));
        assertThat(prod.getDescription(), equalTo(DESCRIPTION));

        // 2. Fetch all products incl. total amount
        GenericType<List<Products>> customerType = new GenericType<List<Products>>() {
        }; // generic type to wrap a generic list of products
        List<Products> products = client.target(REST_SERVICE_URL).path("products").request().get(customerType);
        JSONObject json = client.target(REST_SERVICE_URL).path("products/count").request().get(JSONObject.class);
        assertEquals(products.size(), (int)json.get("value"));

        // 3. Fetch range of products
        GenericType<List<Products>> productsTypeR = new GenericType<List<Products>>() {
        }; // generic type to wrap a generic list of products
        final URI uri = UriBuilder.fromUri(REST_SERVICE_URL + "products/range?fst={fst}&count={count}")
                .resolveTemplate("fst", "1")
                .resolveTemplate("count", "3").build();
        List<Products> productsR = client.target(uri).request().get(productsTypeR);
        assertEquals(productsR.size(), 3);
    }

    @Test
    public void testGetOrders() {

        // 1. Fetch order by id
        Orders ord = client.target(REST_SERVICE_URL).path("orders/{id}").resolveTemplate("id", ORDNR).request().get(Orders.class);
        assertThat(ord, notNullValue());
        assertThat(ord.getOrdNr(), equalTo(ORDNR));
        assertThat(ord.getOrdUser(), equalTo(ORDUSER));

        // 2. Fetch all orders incl. total amount
        GenericType<List<Orders>> customerType = new GenericType<List<Orders>>() {
        }; // generic type to wrap a generic list of customers
        List<Orders> orders = client.target(REST_SERVICE_URL).path("orders").request().get(customerType);
        JSONObject json = client.target(REST_SERVICE_URL).path("orders/count").request().get(JSONObject.class);
        assertEquals(orders.size(), (int)json.get("value"));

        // 3. Fetch range of orders
        GenericType<List<Orders>> orderTypeR = new GenericType<List<Orders>>() {
        }; // generic type to wrap a generic list of orders
        final URI uri = UriBuilder.fromUri(REST_SERVICE_URL + "orders/range?fst={fst}&count={count}")
                .resolveTemplate("fst", "1")
                .resolveTemplate("count", "3").build();
        List<Orders> ordersR = client.target(uri).request().get(orderTypeR);
        assertEquals(ordersR.size(), 3);
    }
}

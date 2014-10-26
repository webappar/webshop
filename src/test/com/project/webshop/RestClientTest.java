package com.project.webshop;

import com.project.webshop.model.*;
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
    private static final String DESCRIPTION = "En alldeles egen Isbjörn finns att köpa här till det helt " +
            "incredible låga pris av det som står där ovanför.. Äter pingviner och saltgurka men passa er " +
            "för att ge den pressad gurkmajonäs då det kan ge upphov till gaser.. globala uppvärmningsgaser!";

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
        GenericType<List<Products>> productType = new GenericType<List<Products>>() {
        }; // generic type to wrap a generic list of products
        List<Products> products = client.target(REST_SERVICE_URL).path("products").request().get(productType);
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
        GenericType<List<Orders>> orderType = new GenericType<List<Orders>>() {
        }; // generic type to wrap a generic list of orders
        List<Orders> orders = client.target(REST_SERVICE_URL).path("orders").request().get(orderType);
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


    @Test
    public void testGetOrderitem() {

        // 1. Fetch orderitem by id (NOT IMPLEMENTED)

        // 2. Fetch all orderitems incl. total amount
        GenericType<List<Orderitem>> orderItemType = new GenericType<List<Orderitem>>() {
        }; // generic type to wrap a generic list of orderitem
        List<Orderitem> orderItems = client.target(REST_SERVICE_URL).path("orderitem").request().get(orderItemType);
        JSONObject json = client.target(REST_SERVICE_URL).path("orderitem/count").request().get(JSONObject.class);
        assertEquals(orderItems.size(), (int)json.get("value"));

        // 3. Fetch range of orderitems
        GenericType<List<Orderitem>> orderItemTypeR = new GenericType<List<Orderitem>>() {
        }; // generic type to wrap a generic list of orderitem
        final URI uri = UriBuilder.fromUri(REST_SERVICE_URL + "orderitem/range?fst={fst}&count={count}")
                .resolveTemplate("fst", "1")
                .resolveTemplate("count", "3").build();
        List<Orderitem> ordersItemR = client.target(uri).request().get(orderItemTypeR);
        assertEquals(ordersItemR.size(), 3);
    }

    @Test
    public void testGetOrderprice() {

        // 1. Fetch orderprice by id (NOT IMPLEMENTED)

        // 2. Fetch all orderprices incl. total amount
        GenericType<List<Orderprice>> orderPriceType = new GenericType<List<Orderprice>>() {
        }; // generic type to wrap a generic list of orderprices
        List<Orderprice> orderPrices = client.target(REST_SERVICE_URL).path("orderprice").request().get(orderPriceType);
        JSONObject json = client.target(REST_SERVICE_URL).path("orderprice/count").request().get(JSONObject.class);
        assertEquals(orderPrices.size(), (int)json.get("value"));

        // 3. Fetch range of orderprices (NOT TESTED)
    }

    @Test
    public void testGetOrderShoppingList() {

        // 1. Fetch ordershoppinglist by id (NOT IMPLEMENTED)

        // 2. Fetch all ordershoppinglists incl. total amount
        GenericType<List<Ordershoppinglist>> orderShoppingListType = new GenericType<List<Ordershoppinglist>>() {
        }; // generic type to wrap a generic list of ordershoppinglists
        List<Ordershoppinglist> orderShoppingList = client.target(REST_SERVICE_URL).path("ordershoppinglist").request().get(orderShoppingListType);
        JSONObject json = client.target(REST_SERVICE_URL).path("ordershoppinglist/count").request().get(JSONObject.class);
        assertEquals(orderShoppingList.size(), (int)json.get("value"));

        // 3. Fetch range of ordershoppinglists (NOT TESTED)
    }
}

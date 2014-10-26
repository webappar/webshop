package com.project.webshop.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Orderprice Entity
 *
 */
@Entity
@Table(name = "Orderprice", catalog = "webshop")
public class Orderprice implements java.io.Serializable {

    private OrderpriceId id;

    public Orderprice() {
    }

    public Orderprice(OrderpriceId id) {
        this.id = id;
    }

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "ordNr", column = @Column(name = "ordNr", nullable = false)),
            @AttributeOverride(name = "userName", column = @Column(name = "userName", nullable = false, length = 20)),
            @AttributeOverride(name = "totalPrice", column = @Column(name = "totalPrice", precision = 42, scale = 0)) })
    public OrderpriceId getId() {
        return this.id;
    }

    public void setId(OrderpriceId id) {
        this.id = id;
    }

}

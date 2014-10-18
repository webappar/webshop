package com.project.webshop.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Ordershoppinglist
 */
@Entity
@Table(name = "ordershoppinglist", catalog = "webshop")
public class Ordershoppinglist implements java.io.Serializable {

    private OrdershoppinglistId id;

    public Ordershoppinglist() {
    }

    public Ordershoppinglist(OrdershoppinglistId id) {
        this.id = id;
    }

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "ordNr", column = @Column(name = "ordNr", nullable = false)),
            @AttributeOverride(name = "userName", column = @Column(name = "userName", nullable = false, length = 20)),
            @AttributeOverride(name = "artNr", column = @Column(name = "artNr", nullable = false)),
            @AttributeOverride(name = "proName", column = @Column(name = "proName", length = 50)),
            @AttributeOverride(name = "price", column = @Column(name = "price")),
            @AttributeOverride(name = "quant", column = @Column(name = "quant")),
            @AttributeOverride(name = "totalPrice", column = @Column(name = "TotalPrice")) })
    public OrdershoppinglistId getId() {
        return this.id;
    }

    public void setId(OrdershoppinglistId id) {
        this.id = id;
    }

}

package com.project.webshop.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Orderitem
 */
@Entity
@Table(name = "Orderitem", catalog = "webshop")
public class Orderitem implements java.io.Serializable {

    private OrderitemId id;
    private Integer quant;

    public Orderitem() {
    }

    public Orderitem(OrderitemId id) {
        this.id = id;
    }

    public Orderitem(OrderitemId id, Integer quant) {
        this.id = id;
        this.quant = quant;
    }

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "ordNr", column = @Column(name = "ordNr", nullable = false)),
            @AttributeOverride(name = "artNr", column = @Column(name = "artNr", nullable = false)) })
    public OrderitemId getId() {
        return this.id;
    }

    public void setId(OrderitemId id) {
        this.id = id;
    }

    @Column(name = "quant")
    public Integer getQuant() {
        return this.quant;
    }

    public void setQuant(Integer quant) {
        this.quant = quant;
    }

}

package com.project.webshop.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * OrderitemId
 *
 */
@Embeddable
public class OrderitemId implements java.io.Serializable {

    private int ordNr;
    private int artNr;

    public OrderitemId() {
    }

    public OrderitemId(int ordNr, int artNr) {
        this.ordNr = ordNr;
        this.artNr = artNr;
    }

    @Column(name = "ordNr", nullable = false)
    public int getOrdNr() {
        return this.ordNr;
    }

    public void setOrdNr(int ordNr) {
        this.ordNr = ordNr;
    }

    @Column(name = "artNr", nullable = false)
    public int getArtNr() {
        return this.artNr;
    }

    public void setArtNr(int artNr) {
        this.artNr = artNr;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof OrderitemId))
            return false;
        OrderitemId castOther = (OrderitemId) other;

        return (this.getOrdNr() == castOther.getOrdNr())
                && (this.getArtNr() == castOther.getArtNr());
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getOrdNr();
        result = 37 * result + this.getArtNr();
        return result;
    }

}

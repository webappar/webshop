package com.project.webshop.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * OrderpriceId
 */
@Embeddable
public class OrderpriceId implements java.io.Serializable {

    private int ordNr;
    private String userName;
    private BigDecimal totalPrice;

    public OrderpriceId() {
    }

    public OrderpriceId(int ordNr, String userName) {
        this.ordNr = ordNr;
        this.userName = userName;
    }

    public OrderpriceId(int ordNr, String userName, BigDecimal totalPrice) {
        this.ordNr = ordNr;
        this.userName = userName;
        this.totalPrice = totalPrice;
    }

    @Column(name = "ordNr", nullable = false)
    public int getOrdNr() {
        return this.ordNr;
    }

    public void setOrdNr(int ordNr) {
        this.ordNr = ordNr;
    }

    @Column(name = "userName", nullable = false, length = 20)
    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "TotalPrice", precision = 42, scale = 0)
    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof OrderpriceId))
            return false;
        OrderpriceId castOther = (OrderpriceId) other;

        return (this.getOrdNr() == castOther.getOrdNr())
                && ((this.getUserName() == castOther.getUserName()) || (this
                        .getUserName() != null
                        && castOther.getUserName() != null && this
                        .getUserName().equals(castOther.getUserName())))
                && ((this.getTotalPrice() == castOther.getTotalPrice()) || (this
                        .getTotalPrice() != null
                        && castOther.getTotalPrice() != null && this
                        .getTotalPrice().equals(castOther.getTotalPrice())));
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getOrdNr();
        result = 37 * result
                + (getUserName() == null ? 0 : this.getUserName().hashCode());
        result = 37
                * result
                + (getTotalPrice() == null ? 0 : this.getTotalPrice()
                        .hashCode());
        return result;
    }

}

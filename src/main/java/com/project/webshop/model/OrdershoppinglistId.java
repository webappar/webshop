package com.project.webshop.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * OrdershoppinglistId
 *
 */
@Embeddable
public class OrdershoppinglistId implements java.io.Serializable {

    private int ordNr;
    private String userName;
    private int artNr;
    private String proName;
    private Integer price;
    private Integer quant;
    private Long totalPrice;

    public OrdershoppinglistId() {
    }

    public OrdershoppinglistId(int ordNr, String userName, int artNr) {
        this.ordNr = ordNr;
        this.userName = userName;
        this.artNr = artNr;
    }

    public OrdershoppinglistId(int ordNr, String userName, int artNr,
            String proName, Integer price, Integer quant, Long totalPrice) {
        this.ordNr = ordNr;
        this.userName = userName;
        this.artNr = artNr;
        this.proName = proName;
        this.price = price;
        this.quant = quant;
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

    @Column(name = "artNr", nullable = false)
    public int getArtNr() {
        return this.artNr;
    }

    public void setArtNr(int artNr) {
        this.artNr = artNr;
    }

    @Column(name = "proName", length = 50)
    public String getProName() {
        return this.proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    @Column(name = "price")
    public Integer getPrice() {
        return this.price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Column(name = "quant")
    public Integer getQuant() {
        return this.quant;
    }

    public void setQuant(Integer quant) {
        this.quant = quant;
    }

    @Column(name = "totalPrice")
    public Long getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof OrdershoppinglistId))
            return false;
        OrdershoppinglistId castOther = (OrdershoppinglistId) other;

        return (this.getOrdNr() == castOther.getOrdNr())
                && ((this.getUserName() == castOther.getUserName()) || (this
                        .getUserName() != null
                        && castOther.getUserName() != null && this
                        .getUserName().equals(castOther.getUserName())))
                && (this.getArtNr() == castOther.getArtNr())
                && ((this.getProName() == castOther.getProName()) || (this
                        .getProName() != null && castOther.getProName() != null && this
                        .getProName().equals(castOther.getProName())))
                && ((this.getPrice() == castOther.getPrice()) || (this
                        .getPrice() != null && castOther.getPrice() != null && this
                        .getPrice().equals(castOther.getPrice())))
                && ((this.getQuant() == castOther.getQuant()) || (this
                        .getQuant() != null && castOther.getQuant() != null && this
                        .getQuant().equals(castOther.getQuant())))
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
        result = 37 * result + this.getArtNr();
        result = 37 * result
                + (getProName() == null ? 0 : this.getProName().hashCode());
        result = 37 * result
                + (getPrice() == null ? 0 : this.getPrice().hashCode());
        result = 37 * result
                + (getQuant() == null ? 0 : this.getQuant().hashCode());
        result = 37
                * result
                + (getTotalPrice() == null ? 0 : this.getTotalPrice()
                        .hashCode());
        return result;
    }

}

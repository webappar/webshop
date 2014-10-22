package com.project.webshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Products
 */
@Entity
@Table(name = "Products", catalog = "webshop")
public class Products implements java.io.Serializable {

    private int artNr;
    private String proName;
    private Integer price;
    private String url;
    private String description;

    public Products() {
    }

    public Products(int artNr) {
        this.artNr = artNr;
    }

    public Products(int artNr, String proName, Integer price, String url,
            String description) {
        this.artNr = artNr;
        this.proName = proName;
        this.price = price;
        this.url = url;
        this.description = description;
    }

    @Id
    @Column(name = "artNr", unique = true, nullable = false)
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

    @Column(name = "url")
    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Column(name = "description", columnDefinition="TEXT", length = 65535)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

package com.project.webshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Orders Entity
 *
 */
@Entity
@Table(name = "Orders", catalog = "webshop")
public class Orders implements java.io.Serializable {

    private Integer ordNr;
    private Integer ordDate;
    private String ordUser;

    public Orders() {
    }

    public Orders(Integer ordDate, String ordUser) {
        this.ordDate = ordDate;
        this.ordUser = ordUser;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ordNr", unique = true, nullable = false)
    public Integer getOrdNr() {
        return this.ordNr;
    }

    public void setOrdNr(Integer ordNr) {
        this.ordNr = ordNr;
    }

    @Column(name = "ordDate")
    public Integer getOrdDate() {
        return this.ordDate;
    }

    public void setOrdDate(Integer ordDate) {
        this.ordDate = ordDate;
    }

    @Column(name = "ordUser", length = 20)
    public String getOrdUser() {
        return this.ordUser;
    }

    public void setOrdUser(String ordUser) {
        this.ordUser = ordUser;
    }

}

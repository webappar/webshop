package com.project.webshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Customer
 */
@Entity
@Table(name = "Customer", catalog = "webshop", uniqueConstraints = @UniqueConstraint(columnNames = "userEmail"))
public class Customer implements java.io.Serializable {

    private String userName;
    private String userEmail;
    private String password;

    public Customer() {
    }

    public Customer(String userName) {
        this.userName = userName;
    }

    public Customer(String userName, String userEmail, String password) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.password = password;
    }

    @Id
    @Column(name = "userName", unique = true, nullable = false, length = 20)
    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "userEmail", unique = true, length = 50)
    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Column(name = "password", length = 50)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

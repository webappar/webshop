package com.project.webshop.model;

/**
 *
 */
public class Customer  implements java.io.Serializable {

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

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

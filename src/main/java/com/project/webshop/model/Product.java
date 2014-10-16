package com.project.webshop.model;

/**
 *
 */
public class Product  implements java.io.Serializable {

    private int artNr;
    private String name;
    private int price;
    private String url;
    private String description;

    public Product() {
    }

    public Product(int artNr, String name, int price, String url, String description) {
        this.artNr = artNr;
        this.name = name;
        this.price = price;
        this.url = url;
        this.description = description;
    }
    
    public int getArtNr(){
        return this.artNr;
    }

    public String getname() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice(){
        return this.price;
    }
    
    public void setUrl(String url){
        this.url = url;
    }
    
    public String getUrl(){
        return this.url;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
    
    public String getDescription(){
        return this.description;
    }
    
}

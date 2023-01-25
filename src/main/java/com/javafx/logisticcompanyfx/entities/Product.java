package com.javafx.logisticcompanyfx.entities;

public class Product {
    private Integer id;
    private Integer countryId;
    private String products;
    private Integer price;
    private Integer priceForClients;
    private String wishes;

    public Product(Integer id, Integer countryId, String products, Integer price, Integer priceForClients, String wishes) {
        this.id = id;
        this.countryId = countryId;
        this.products = products;
        this.price = price;
        this.priceForClients = priceForClients;
        this.wishes = wishes;
    }

    public Product(Integer id, Integer countryId, String products, Integer price) {
        this.id = id;
        this.countryId = countryId;
        this.products = products;
        this.price = price;
    }

    public Product(String products, Integer price) {
        this.products = products;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getPriceForClients() {
        return priceForClients;
    }

    public String getWishes() {
        return wishes;
    }

}

package com.javafx.logisticcompanyfx.entities;

public class Company {
    private Integer id;
    private String name;
    private String products;

    public Company(Integer id, String name, String products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public Company() {

    }

    public Company(String name) {
        this.name = name;
    }

    public Company(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", products='" + products + '\'' +
                '}';
    }
}

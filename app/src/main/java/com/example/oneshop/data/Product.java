package com.example.oneshop.data;

public class Product {
    private int id;
    private String category;
    private String title;
    private String shortdesc;
    private double price;
    private String image_url;

    public Product(int id, String category, String title, String shortdesc, double price, String image_url) {
        this.id = id;
        this.category = category;
        this.title = title;
        this.shortdesc = shortdesc;
        this.price = price;
        this.image_url = image_url;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortdesc() {
        return shortdesc;
    }

    public void setShortdesc(String shortdesc) {
        this.shortdesc = shortdesc;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}


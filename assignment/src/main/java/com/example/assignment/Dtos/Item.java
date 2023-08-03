package com.example.assignment.Dtos;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private int quantity;
    private ItemPrice price;
    private String name;
    private String category;
    private List<String> subcategory = new ArrayList<>();
    private String sku;

    public Item() {
    }

    public Item(int quantity, ItemPrice price, String name, String category, String sku) {
        this.quantity = quantity;
        this.price = price;
        this.name = name;
        this.category = category;
        this.sku = sku;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ItemPrice getPrice() {
        return price;
    }

    public void setPrice(ItemPrice price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(List<String> subcategory) {
        this.subcategory = subcategory;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

}

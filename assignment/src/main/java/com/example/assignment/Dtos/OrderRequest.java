package com.example.assignment.Dtos;

import java.util.List;

public class OrderRequest {
    private TotalAmount totalAmount;
    private Consumer consumer;
    private Shipping shipping;
    private List<Item> items;
    private Merchant merchant;

    public OrderRequest(TotalAmount totalAmount, Consumer consumer, Shipping shipping, List<Item> items,
            Merchant merchant) {
        this.totalAmount = totalAmount;
        this.consumer = consumer;
        this.shipping = shipping;
        this.items = items;
        this.merchant = merchant;
    }

    public TotalAmount getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(TotalAmount totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Consumer getConsumer() {
        return consumer;
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

}

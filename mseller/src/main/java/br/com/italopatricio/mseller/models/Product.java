package br.com.italopatricio.mseller.models;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private int buyerId;
    private Seller buyer;

    public Product(int id, int buyerId) {
        this.id = id;
        this.buyerId = buyerId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public Seller getBuyer() {
        return buyer;
    }
}

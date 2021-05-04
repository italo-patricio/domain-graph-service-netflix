package br.com.italopatricio.mbuyer.models;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private int buyerId;
    private Buyer buyer;

    public Product(int id, int buyerId) {
        this.id = id;
        this.buyerId = buyerId;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public Buyer getBuyer() {
        return buyer;
    }
}

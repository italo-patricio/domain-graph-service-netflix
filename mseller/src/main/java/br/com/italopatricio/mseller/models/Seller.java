package br.com.italopatricio.mseller.models;

import java.io.Serializable;
import java.util.List;

public class Seller implements Serializable {
    private int id;
    private String name;
    private List<Integer> productIds;

    public Seller(int id) {
        this.id = id;
    }

    public Seller(int id, String name, List<Integer> productIds) {
        this.id = id;
        this.name = name;
        this.productIds = productIds;
    }

    public Seller(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getProductIds() {
        return productIds;
    }
}

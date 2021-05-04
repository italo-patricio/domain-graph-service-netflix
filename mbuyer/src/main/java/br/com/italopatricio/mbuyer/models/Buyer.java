package br.com.italopatricio.mbuyer.models;

import java.io.Serializable;
import java.util.List;

public class Buyer implements Serializable {
    private int id;
    private String name;

    public Buyer(int id) {
        this.id = id;
    }

    public Buyer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

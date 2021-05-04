package br.com.italopatricio.mbuyer.models;

import java.io.Serializable;
import java.util.List;

public class Buyer implements Serializable {
    private int id;
    private String name;
    private String characterId;

    public Buyer(int id) {
        this.id = id;
    }

    public Buyer(String characterId) {
        this.characterId = characterId;
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

    public String getCharacterId() {
        return characterId;
    }
}

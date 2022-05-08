package com.example.health_advisor;


import java.io.Serializable;

public class meal implements Serializable {
    private String name;
    private String component;
    private String categorie;
    private int rate;
    private String details;

    public meal(String name, String component, String categorie, int rate, String details) {
        this.name = name;
        this.component = component;
        this.categorie = categorie;
        this.rate = rate;
        this.details = details;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}

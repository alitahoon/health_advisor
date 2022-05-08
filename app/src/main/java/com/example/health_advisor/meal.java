package com.example.health_advisor;


import java.io.Serializable;

public class meal implements Serializable {
    private String name;
    private String categorie;
    private int img;
    private int rate;
    private String details;

    public meal(String name,String categorie, int rate, String details,int img) {
        this.name = name;
        this.categorie = categorie;
        this.rate = rate;
        this.details = details;
        this.img=img;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

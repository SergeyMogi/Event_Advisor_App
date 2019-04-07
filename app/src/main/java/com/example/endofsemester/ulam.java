package com.example.endofsemester;

import android.widget.ImageView;
import android.widget.TextView;

public class ulam {
 private int price;
 private int muzmanim;
 private String city;
 private  int image;
 private int type;



    public ulam(int price, int muzmanim, String city, int image,int type) {
        this.price = price;
        this.muzmanim = muzmanim;
        this.city = city;
        this.image = image;
        this.type=type;

    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMuzmanim() {
        return muzmanim;
    }

    public void setMuzmanim(int muzmanim) {
        this.muzmanim = muzmanim;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

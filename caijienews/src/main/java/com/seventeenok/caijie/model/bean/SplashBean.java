package com.seventeenok.caijie.model.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SplashBean implements Serializable{

    @SerializedName("image")
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

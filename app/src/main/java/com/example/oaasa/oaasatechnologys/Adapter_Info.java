package com.example.oaasa.oaasatechnologys;

/**
 * Created by Amit on 7/11/2017.
 */

public class Adapter_Info {
    private String name;
    private int image;

    public Adapter_Info(String name, int image) {
       this.setName(name);
       this.setImage(image);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

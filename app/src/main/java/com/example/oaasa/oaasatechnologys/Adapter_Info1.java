package com.example.oaasa.oaasatechnologys;

/**
 * Created by Amit on 7/11/2017.
 */

public class Adapter_Info1 {
    private String title;
    private String title1;
    private int image;

    public Adapter_Info1(String title, String title1, int image) {
       this.setTitle(title);
       this.setTitle1(title1);
       this.setImage(image);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

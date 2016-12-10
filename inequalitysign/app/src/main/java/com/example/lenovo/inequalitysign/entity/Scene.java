package com.example.lenovo.inequalitysign.entity;

/**
 * Created by ff on 2016/12/10.
 */
public class Scene {
     private int img;
    private String title;

    public Scene(int img, String title) {
        this.img = img;
        this.title = title;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

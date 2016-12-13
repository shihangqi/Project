package com.example.lenovo.inequalitysign.entity;

/**
 * Created by ff on 2016/12/3.
 */
public class Rank {

    private String url;//商家logo
    private String shop_name;
    private String address;
    private String wait_num;

    public Rank( String url, String shop_name, String address, String wait_num) {

        this.url = url;
        this.shop_name = shop_name;
        this.address = address;
        this.wait_num = wait_num;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWait_num() {
        return wait_num;
    }

    public void setWait_num(String wait_num) {
        this.wait_num = wait_num;
    }
}

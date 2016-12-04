package com.example.lenovo.inequalitysign.entity;

/**
 * Created by ff on 2016/12/3.
 */
public class Comment {
    private String user;
    private String date;
    private String comment;
    private String server;

    public Comment(String user, String date, String comment, String server) {
        this.user = user;
        this.date = date;
        this.comment = comment;
        this.server = server;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }
}

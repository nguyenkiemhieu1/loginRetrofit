package com.example.test.Model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    private  String id;

    @SerializedName("name")
    private String name;

    @SerializedName("pass")
    private  String password;

    @SerializedName("status")
    private  String status;

    public User(String id, String name, String password, String status) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

package com.edu.mainactivity;

import java.io.Serializable;

public class UserEntity implements Serializable {

    private int id;
    private String name;
    private String email;
    private String password;
    private long identification;

    public UserEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getIdentification() {
        return identification;
    }

    public  String getIdentificationString(){
        return String.valueOf(identification);
    }

    public void setIdentification(long identification) {
        this.identification = identification;
    }
}

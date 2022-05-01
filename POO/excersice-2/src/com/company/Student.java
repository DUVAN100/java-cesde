package com.company;

public class Student {
    String photoUrl, identification, name;
    Student(String photoUrl, String identification, String name){
        this.photoUrl=photoUrl;
        this.identification = identification;
        this.name= name;
    }


    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}

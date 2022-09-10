package com.company;

import java.util.Scanner;



public class Producto {
    Scanner imputdata = new Scanner(System.in);
    String color;
    String name;
    String brand;
    double price;
    int model;
    Producto(String name,String color, double price, int model, String brand){
        this.name = name;
        this.color = color;
        this.brand=brand;
        this.price=price;
        this.model=model;
    }


    public Scanner getImputdata() {
        return imputdata;
    }

    public void setImputdata(Scanner imputdata) {
        this.imputdata = imputdata;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getModel() {
        return model;
    }

    public void setModel(int model) {
        this.model = model;
    }


}

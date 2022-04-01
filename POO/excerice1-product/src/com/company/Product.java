package com.company;


public class Product {
    private String color, name, brad, model;
    double prise, reference;

    public Product(String name, double prise, String model, String color, double reference) {
        this.color = color;
        this.model=model;
        this.prise = prise;
        this.name = name;
    }


    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public double getReference() {
        return reference;
    }
    public void setReference(double reference) {
        this.reference = reference;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrad() {
        return brad;
    }

    public void setBrad(String brad) {
        this.brad = brad;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrise() {
        return prise;
    }

    public void setPrise(double prise) {
        this.prise = prise;
    }
}

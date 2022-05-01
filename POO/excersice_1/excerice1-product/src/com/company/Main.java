package com.company;
import util.java.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner imputdata = new Scanner(System.in);
        String producName;
        double productPrise;
        System.out.println("ingrese el nombre del producto ");
        producName = imputdata.nextLine();
        System.out.println("digite el valor del prodycto ");
        productPrise = Double.parseDouble(imputdata.nextLine());
        System.out.println("digigte el model del producto ");
        String productModelo = imputdata.nextLine();
        System.out.println("digite el  color del product ");
        String productColor = imputdata.nextLine();
        System.out.println("digite la referencia del proucto");
        double productreference = imputdata.nextDouble();

        //instanciamos la clase Product
        Product monitorhp = new Product(producName,productPrise,productModelo,productColor,productreference);
        //mostramos los getters
        System.out.println(monitorhp.getColor());
        System.out.println(monitorhp.getName());
        double precio = monitorhp.prise;
        System.out.println(precio);
        System.out.println(monitorhp.getModel());
        //llamoi el color del producto
        System.out.println(monitorhp.getColor());
        System.out.println(monitorhp.getReference());





    }
}

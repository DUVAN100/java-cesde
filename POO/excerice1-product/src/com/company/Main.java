package com.company;
import java.util.Scanner;
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
        //instanciamos la clase Product
        Product monitorhp = new Product(producName,productPrise,productModelo,productColor);
        //mostramos los getters
        System.out.println("el color es  "+monitorhp.getColor());
        System.out.println(monitorhp.getName());
        double precio = monitorhp.prise;
        System.out.println(precio);
        System.out.println(monitorhp.getModel());




    }
}

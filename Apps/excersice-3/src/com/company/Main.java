package com.company;
import  java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner imputdata = new Scanner(System.in);
///pedimos los valores del prroducto

        System.out.println("Ingrese el nombre del producto :");
        String productName= imputdata.nextLine();
        System.out.println("digite el color del producto");
        String produColor = imputdata.nextLine();
        System.out.println("Ingrese el precio : ");
        double productPrice=Double.parseDouble(imputdata.nextLine());
        System.out.println("Ingrese el modelo del producto : ");
        int productModel= Integer.parseInt(imputdata.nextLine());
        System.out.println("Ingrese la marca del producto :");
        String productBrand= imputdata.nextLine();

        Producto monitorHp=new Producto(productName,produColor, productPrice,productModel,productBrand);

        System.out.println("su poucto es :"+monitorHp.getName());
        System.out.println("el color del prodcuto es "+monitorHp.getColor());
        System.out.println("el valor del poducto es "+ monitorHp.getPrice());
        System.out.println("el modelo del producto es "+monitorHp.getModel());
        System.out.println("la marca es "+monitorHp.getBrand());



    }



}

package co.edu.cesde;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner inputData = new Scanner(System.in);
        String productName, brand;
        double price;
        System.out.println("Ingrese el nombre del producto");
        productName = inputData.nextLine();
        System.out.println("Ingrese el precio");
        price = Double.parseDouble(inputData.nextLine());
        System.out.println("Ingrese la marca");
        brand = inputData.nextLine();
        Product monitorHp = new Product(productName, price, brand);
        String name = monitorHp.getName();
        System.out.println(name);
        System.out.println(monitorHp.getPrice());
        Carro tesla = new Carro();
        //tesla.color = "Negro";
        tesla.encender();
        Carro mercedez = new Carro();
        //System.out.println(mercedez.color);
        tesla.setColor("verde");
        tesla.showColor();
        String color = tesla.getColor();

    }
}

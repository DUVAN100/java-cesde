package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner imputdata = new Scanner(System.in);
        int number, unit, ten, hunders;
        System.out.println("enter the number: ");
        number = imputdata.nextInt();
        unit = (number/ 100);
        ten = (number % 100)/10;
        hunders = (number % 10);
        System.out.println("the inverted number is:"+hunders +ten +unit);
    }
}

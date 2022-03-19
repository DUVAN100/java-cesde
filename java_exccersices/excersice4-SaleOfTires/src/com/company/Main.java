package com.company;
import  java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner inputdata = new Scanner(System.in);
        double numberOfTires, purchaseValue;
        System.out.println("enter a number of tires bought:");
        numberOfTires = inputdata.nextDouble();
        if(numberOfTires < 5 )
        {
            purchaseValue = 30000 * numberOfTires;
            System.out.println("the total is "+ purchaseValue+" unit price is of: "+ 30000);
        }
        else if (numberOfTires <= 10)
        {
            purchaseValue = 25000 * numberOfTires;
            System.out.println("the total is "+ purchaseValue+" unit price is of: "+ 25000);
        }
        else
        {
            purchaseValue = 20000 * numberOfTires;
            System.out.println("the total is "+ purchaseValue+" unit price is of: "+ 20000);

        }
    }
}

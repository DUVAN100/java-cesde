package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner inputdata = new Scanner(System.in);
        int number;
        System.out.println("enter a number ramdom: ");
        number = inputdata.nextInt();
        if (number % 2 == 0)
        {
            System.out.println("the number is par.");
        }
        else
        {
            System.out.println("the number its not par");
        }

    }
}

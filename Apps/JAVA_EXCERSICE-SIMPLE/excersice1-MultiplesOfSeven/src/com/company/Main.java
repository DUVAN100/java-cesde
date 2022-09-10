package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner inputdata = new Scanner(System.in);
        int number;
        System.out.println("enter a number ramdom: ");
        number = inputdata.nextInt();
        if (number % 7 == 0)
        {
            System.out.println("yes, if is multiple of seven.");
        }
        else
        {
            System.out.println("not, no is multiple of seven");
        }
    }
}

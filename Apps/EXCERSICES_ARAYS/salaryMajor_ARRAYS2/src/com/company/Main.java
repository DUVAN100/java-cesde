package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        float major=0;
        int pos=0;
        Scanner imputdata = new Scanner(System.in);
        System.out.println("type the range of list ");
        int number = imputdata.nextInt();
        String[] names= new String[number];
        float[] sueldo = new float[number];
        for (int i = 0; i <names.length; i++) {
            System.out.println("type your name: ");
            names[i]=imputdata.next();
            System.out.println("type your salary ");
            sueldo[i] = imputdata.nextFloat();
            major= sueldo[i];
            for (int f = 0; f < names.length ; f++) {
                if (sueldo[i]< major){
                    major = sueldo[f];
                    pos += f;
                }
            }
        }
        System.out.println("el empleado con el mayor sueldo es "  +names[pos]);
        System.out.println("tiene un sueldo de: "+major);




    }
}

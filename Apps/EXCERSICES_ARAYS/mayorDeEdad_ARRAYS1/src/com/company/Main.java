package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner imputdata = new Scanner(System.in);
        String[] nombres = new String[2];
        int[]  edades = new int[2];
        for(int i = 0; i < nombres.length; i++ ) {
                System.out.println("type your name:");
                nombres[i] = imputdata.next();
                System.out.println("type yuor age");
                edades[i] = imputdata.nextInt();
        }
        System.out.println("older people. ");
            for (int k = 0; k < nombres.length;k++) {
                if (edades [k] >= 18)
                {
                    System.out.println(nombres[k]+ "con la edad de: "+edades[k]);
                }
            }
    }
}

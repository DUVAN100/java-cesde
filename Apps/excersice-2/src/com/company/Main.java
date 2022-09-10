package com.company;
import  java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner imputdada = new Scanner(System.in);
        System.out.println("digite el numero de estudiantes");
       int numstudenst = Integer.parseInt(imputdada.nextLine());

        Student[] students = new Student[numstudenst];
        for (int i = 0; i < students.length; i++) {
            Student person = new Student [];
            System.out.println("digite el url de su foto");
            person.setPhotoUrl(imputdada.nextLine());
            System.out.println("ingrse el nombre ");
            person.setName(imputdada.nextLine());
            System.out.println("ingrse la identificacion");
            person.setIdentification(imputdada.nextLine());
            students[i] = person;
            System.out.println(students[i]);
        }


    }
}

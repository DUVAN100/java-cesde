package co.edu.cesde;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner inputData = new Scanner(System.in);
        /*System.out.println("Ingrse la cantidad de posiciones");
        int size = inputData.nextInt();
        int[] numbers = new int[size];*/
        /*for (int i = 0; i < numbers.length; i++) {
            System.out.println("Ingrese dato: " + (i + 1));
            numbers[i] = inputData.nextInt();
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }*/
        double average = 0;
        int numStudents;
        System.out.println("Ingrese el numero de estudiantes");
        numStudents = Integer.parseInt(inputData.nextLine());
        double[] students = new double[numStudents];
        String[] names = new String[numStudents];
        for (int i = 0; i < numStudents; i++) {
            double studentAverage = 0;
            System.out.println("Ingrese el nombre");
            names[i] = inputData.nextLine();
            for(int j = 0; j<3; j++){
                System.out.println("Ingrese nota: " + (j+1));
                studentAverage = studentAverage + Double.parseDouble(inputData.nextLine());
            }
            studentAverage = studentAverage / 3;
            students[i] = studentAverage;
            average = average + students[i];
        }
        System.out.println("Nota promedio es: " + average/students.length);
        for (int i = 0; i < students.length; i++) {
            System.out.println("Estudiante: " + names[i] + "Nota:" + students[i]);
        }
    }
}

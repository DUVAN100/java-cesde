package co.edu.cesde;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        String stopExecution = "NO";
        while (stopExecution.equals("NO")){
            System.out.println("ingrese el nombre el estudiante");
            Student student = new Student();
            student.setName(scanner.nextLine());
            System.out.println("Ingrese el documento");
            student.setIdentification(scanner.nextLine());
            students.add(student);

            // agregar notas al estudiante
            double finalGrade = 0;
            for(int i=0; i<9; i++){
                System.out.println("Ingrese nota");
                double grade = Double.parseDouble(scanner.nextLine());
                finalGrade = finalGrade + grade;
                student.addGrade(grade);
            }
            finalGrade = finalGrade/student.getGrades().size();
            student.setFinalGrade(finalGrade);
            System.out.println("Desea continuar -SI - NO");
            String stop = scanner.nextLine();
            if(stop.equalsIgnoreCase("NO")){
                break;
            }
        }
        // muestra la lista
        for(int i=0; i<students.size(); i++){
            System.out.println("Nombre: " + students.get(i).getName());
        }

        // Busca estudiante
        System.out.println("Ingrese el nombre del estudiante a buscar");
        String name = scanner.nextLine();
        for (int i=0; i<students.size(); i++){
            if(students.get(i).getName().equalsIgnoreCase(name)){
                System.out.println("El estudiante: " +
                        name + "su identificación es: " +
                        students.get(i).getIdentification());
                break;
            }
        }

        // Elimina estudiante
        System.out.println("Ingrese el nombre del estudiante a buscar");
        String identification = scanner.nextLine();
        for (int i=0; i<students.size(); i++){
            if(students.get(i).getIdentification().equalsIgnoreCase(identification)){
                students.remove(i);
                break;
            }
        }
        for(int i=0; i<students.size(); i++){
            System.out.println("Nombre: " + students.get(i).getName());
        }

        // Actualiza estudiante
        System.out.println("Ingrese la identificación del estudiante a buscar");
        String id = scanner.nextLine();
        for (int i=0; i<students.size(); i++){
            if(students.get(i).getIdentification().equalsIgnoreCase(id)){
                Student student = students.get(i);
                System.out.println("Igrese la nueva identificación");
                String ident = scanner.nextLine();
                student.setIdentification(ident);
                students.set(i, student);
                break;
            }
        }
        for(int i=0; i<students.size(); i++){
            System.out.println("Nombre: " + students.get(i).getName());
        }

        // agregar notas al estudiante

    }
}

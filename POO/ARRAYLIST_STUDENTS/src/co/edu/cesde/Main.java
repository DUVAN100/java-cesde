package co.edu.cesde;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner imputdata = new Scanner(System.in);
        ArrayList<Student> estudiante = new ArrayList<>();
        String Condition = "SI";
        while (Condition.equalsIgnoreCase("si")) {
            ArrayList<Double> grades = new ArrayList<>();
            double average = 0;
            double gradesFinals = 0;
            Student person = new Student();
            System.out.println("Type your paht ");
            person.setPhotoUrl(imputdata.nextLine());
            System.out.println("type you identification");
            person.setIdentification(imputdata.nextLine());
            System.out.println("type your name ");
            person.setName(imputdata.nextLine());
            for (int i = 0; i < 3; i++) {
                System.out.println("type you rade " + (i) + " ");
                grades.add(Double.parseDouble(imputdata.nextLine()));
                gradesFinals = (gradesFinals + grades.get(i));
            }
            average = gradesFinals / 3;
            person.setGrades(grades);
            person.setPromedio(average);
            estudiante.add(person);
            System.out.println("Digite --SI-- o --NO-- si desea continuar");
            String stop= imputdata.nextLine();
            if (stop.equalsIgnoreCase("NO")){
                break;
            }
        }
        for(int i=0; i< estudiante.size();i++){

            System.out.println(" Nombre "+estudiante.get(i).getName());
            System.out.println("your average is of: "+ estudiante.get(i).getPromedio());
        }
        //buscar un estudiante
        System.out.println("Escribra el nombre del estudiante que desea buscar :");
        String newName= imputdata.nextLine();

        for(int i=0;i<estudiante.size();i++){

            if(estudiante.get(i).getName().equalsIgnoreCase(newName)){
                System.out.println(estudiante.get(i).getName()+" Esta en la base de datos");
                break;
            }
            else {
                System.out.println(" No esta ahi");
                break;
            }

        }
        //eliminar un estudiante

        for(int i=0;i<estudiante.size();i++){

            if(estudiante.get(i).getName().equalsIgnoreCase(newName)){
                estudiante.remove(i);
                break;
            }
        }


/*







//actualizar

    System.out.println("Ingrese la identificación");
    String idt= inputData.nextLine();

    for(int i=0;i<data.size();i++){

        if(data.get(i).getIdentificacion().equalsIgnoreCase(idt)){
            Students student=data.get(i);
            System.out.println("Ingrese nueva identificacion");
            String ident= inputData.nextLine();
            student.setIdentificacion(ident);
            data.set(i,student);

            break;
        }




    }
*/

    }


}







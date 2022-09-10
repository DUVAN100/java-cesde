package com.company;
import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import  java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner imputdata = new Scanner(System.in);
        ArrayList<Carro> carros = new ArrayList<>();
        String stopexecution= "NO";
        while (stopexecution.equals("si")){
            System.out.println("Digite el modelo del carro: ");
            Carro carro = new Carro();
            carro.setModel(imputdata.nextLine());
            System.out.println("Digite la refrencia del carro: ");
            carro.setReference(imputdata.nextLine());
            System.out.println("Digite el color del carro: ");
            carro.setColor(imputdata.nextLine());
            System.out.println("Digite la altura del carro");
            carro.setAltura(imputdata.nextLine());
            System.out.println("Digite el peso del carro: ");
            carro.setPeso(imputdata.nextLine());
            System.out.println("Digite el ancho del carro:");
            carro.setAncho(imputdata.nextLine());
            System.out.println("Digite el largo del carro: ");
            carro.setLargo(imputdata.nextLine());
            carros.add(carro);
            System.out.println("Digite --SI-- o --NO-- si desea continuar");
            String stop= imputdata.nextLine();
            if (stop.equalsIgnoreCase("NO")){
                break;
            }
        }
        //mostrar la lista
        for (int i = 0; i < carros.size() ; i++) {
            System.out.println("Modelo del carro:");
            System.out.println(carros.get(i).getModel());
            System.out.println("referencia del carro:");
            System.out.println(carros.get(i).getReference());
            System.out.println("altura del carro: ");
            System.out.println(carros.get(i).getAltura());
            System.out.println("peso del carro:");
            System.out.println(carros.get(i).getPeso());
            System.out.println("anco del carro:");
            System.out.println(carros.get(i).getAncho());
            System.out.println("color del carro:");
            System.out.println(carros.get(i).getColor());
            System.out.println("largo del carro:");
            System.out.println(carros.get(i).getLargo());

        }
        //buscar estilo de carro
        System.out.println("ingrese la referenia del rro");
        String  refrencia = imputdata.nextLine();
        for (int i = 0; i < carros.size() ; i++) {
            if (carros.get(i).getReference().equalsIgnoreCase(refrencia))
            {
                System.out.println("El carro tiene la referencia "+refrencia);
                break;
            }
        }


        //eliminar carro
        System.out.println("ingrese la referencia para eliminar el crro de la lista");
        String referece = imputdata.nextLine();
        for (int i = 0; i < carros.size() ; i++) {
            if (carros.get(i).getReference().equalsIgnoreCase(referece)) {
                carros.remove(i);
                break;
            }
        }









        }




}

    package com.company;
    import  java.util.Scanner;

    public class Main {

        public static void main(String[] args) {
        // write your code here
            Scanner imputdata = new Scanner(System.in);
            int NumberPeople,  Numberdishes,i;
            int  dish;
            double valuePurchase=0,valuetotal;
            System.out.printf("type number peoples: ");
            NumberPeople  = imputdata.nextInt();
            for (i = 0;i<NumberPeople;i++)
            {
                int valueDish=0;
                System.out.println("hamburguesa = 1 $10.000-- perros = 2 $8.000-- salchipapas = 3 $6.000-- chorizos = 4 $7.000");
                System.out.println("type the number of dish");
                dish = imputdata.nextInt();
                if (dish==1) { valueDish = 10000;}
                else if (dish==2){ valueDish =8000;}
                else if (dish==3){valueDish=6000;}
                else if (dish==4){valueDish=7000;}
                valuePurchase += valueDish;
            }
            System.out.println("digite 1 si desea incluir la propina. ");
            System.out.println("digite 2 de lo contrario");
            System.out.println(" ¿desea incluirpropina? ");
            int  tip = imputdata.nextInt();

            if (tip == 1)
            {
                valuetotal = valuePurchase+(valuePurchase*0.1);
                System.out.println("your tip is of 10% ");
                System.out.println("el valor de la compra fu de:"+valuetotal);
            }
            else
            {
                valuetotal = valuePurchase-(valuePurchase*0.1);
                System.out.println("se le realizo un descuento por tener el valor de compra mayor a 20.000 pesos");
                System.out.println("el valor de la compra fue de: "+valuetotal);
            }







        }
    }


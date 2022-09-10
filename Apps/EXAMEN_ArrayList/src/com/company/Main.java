package com.company;
import java.util.ArrayList;
import  java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner imputdata = new Scanner(System.in);
        ArrayList<Person> persons = new ArrayList<>();
        ArrayList<Watchman> watchmans = new ArrayList<>();
        ArrayList<CleaningStaff> cleaningstaffs = new ArrayList<>();
        ArrayList<Accountant> accountants = new ArrayList<>();
        ArrayList<Admin> admins = new ArrayList<>();
        System.out.println("M o m es valido");
        String COnditionWhile = "SI";

        while (COnditionWhile.equalsIgnoreCase("si")) {
            System.out.println("digite ---person-- si va a crear el perfil de una persona natural");
            System.out.println("digite ---Watchman-- si va a crear el perfil de un Watchman");
            System.out.println("digite ---cleaningstaff-- si va a crear el perfil de un Cleaningstaff");
            System.out.println("digite ---account-- si va a crear el perfil de un account");
            System.out.println("digite --admin-- si va a crear el perfil de un admin");
            String Condition = imputdata.nextLine();
        if (Condition.equalsIgnoreCase("person")) {
                Person human = new Person();
                System.out.println("digite su nuombre P");
                human.setName(imputdata.nextLine());
                System.out.println("digite su identificacion P");
                human.setIdentification(imputdata.nextLine());
                System.out.println("digite su edad P");
                human.setAge(imputdata.nextInt());
                persons.add(human);
        } else if (Condition.equalsIgnoreCase("watchman")) {
            Watchman human = new Watchman();
            System.out.println("digite su nuombre w");
            human.setName(imputdata.nextLine());
            System.out.println("digite su identificacion w");
            human.setIdentification(imputdata.nextLine());
            System.out.println("digite su edad w");
            human.setAge(Integer.parseInt(imputdata.nextLine()));
            System.out.println("digite su weapon W");
            human.setWeapon(imputdata.nextLine());
            System.out.println("digite su dia de trabajo W");
            human.setWorkday(imputdata.nextLine());
            watchmans.add(human);
        }else if (Condition.equalsIgnoreCase("cleaningstaff")){
            CleaningStaff human = new CleaningStaff();
            System.out.println("digite su nuombre C");
            human.setName(imputdata.nextLine());
            System.out.println("digite su identificacion C");
            human.setIdentification(imputdata.nextLine());
            System.out.println("digite su edad C");
            human.setAge(Integer.parseInt(imputdata.nextLine()));
            System.out.println("digite su dia libre C");
            human.setDayoff(imputdata.nextLine());
            cleaningstaffs.add(human);
        }else if (Condition.equalsIgnoreCase("account")){
            Accountant human = new Accountant();
            System.out.println("digite su nuombre A");
            human.setName(imputdata.nextLine());
            System.out.println("digite su identificacion A");
            human.setIdentification(imputdata.nextLine());
            System.out.println("digite su edad A");
            human.setAge(Integer.parseInt(imputdata.nextLine()));
            System.out.println("digite si eres lidar 'si' o 'no' A");
            human.setLeader(imputdata.nextLine());
            System.out.println("digite si tiene parqueadero 'si' o 'no' A");
            human.setParking(imputdata.nextLine());
            accountants.add(human);
        }else if (Condition.equalsIgnoreCase("admin")) {
            Admin human = new Admin();
            System.out.println("digite su nuombre AD");
            human.setName(imputdata.nextLine());
            System.out.println("digite su identificacion AD");
            human.setIdentification(imputdata.nextLine());
            System.out.println("digite su edad AD");
            human.setAge(Integer.parseInt(imputdata.nextLine()));
            System.out.println("digite si eres lidar 'si' o 'no' A");
            human.setLeader(imputdata.nextLine());
            System.out.println("digite si tiene parqueadero 'si' o 'no' A");
            human.setParking(imputdata.nextLine());
            admins.add(human);
        }
            System.out.println("Digite --SI-- o --NO-- si desea continuar");
            String stop = imputdata.nextLine();
            if (stop.equalsIgnoreCase("no")) {
                break;
            }

        }
        //mostrar person
        for (int i = 0; i <persons.size() ; i++) {
            System.out.println("name "+ persons.get(i).getName());
            System.out.println("identification "+ persons.get(i).getIdentification());
            System.out.println("age "+ persons.get(i).getAge());
        }
        //mostrar watchmans
        for (int i = 0; i <watchmans.size() ; i++) {
            System.out.println("name "+ watchmans.get(i).getName());
            System.out.println("identification "+ watchmans.get(i).getIdentification());
            System.out.println("age "+ watchmans.get(i).getAge());
            System.out.println("weapon "+ watchmans.get(i).getWeapon());
            System.out.println("workday "+ watchmans.get(i).getWorkday());
        }
        //mostrar claeingstaff
        for (int i = 0; i <persons.size() ; i++) {
            System.out.println("name "+ cleaningstaffs.get(i).getName());
            System.out.println("identification "+ cleaningstaffs.get(i).getIdentification());
            System.out.println("age "+ cleaningstaffs.get(i).getAge());
            System.out.println("dayoff "+ cleaningstaffs.get(i).getDayoff());
        }
        //mostrar account
        for (int i = 0; i <persons.size() ; i++) {
            System.out.println("name "+ accountants.get(i).getName());
            System.out.println("identification "+ accountants.get(i).getIdentification());
            System.out.println("age "+ accountants.get(i).getAge());
            System.out.println("leader "+ accountants.get(i).getLeader());
            System.out.println("parking "+ accountants.get(i).getParking());
        }
        //mostrar admin
        for (int i = 0; i <persons.size() ; i++) {
            System.out.println("name "+ admins.get(i).getName());
            System.out.println("identification "+ admins.get(i).getIdentification());
            System.out.println("age "+ admins.get(i).getAge());
            System.out.println("leader "+ admins.get(i).getLeader());
            System.out.println("parking "+ admins.get(i).getParking());
        }







    }
}

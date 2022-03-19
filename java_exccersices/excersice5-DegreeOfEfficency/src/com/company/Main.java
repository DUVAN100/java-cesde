package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner inpudata = new Scanner(System.in);
        double numberOfDefectiveScrews, numberOfScrewsProduced;
        System.out.println("enter the number of screws defective: ");
        numberOfDefectiveScrews = inpudata.nextDouble();
        System.out.println("enter number of crews produced: ");
        numberOfScrewsProduced = inpudata.nextDouble();
        if ((numberOfDefectiveScrews < 200) &&(numberOfScrewsProduced > 10000 ))
        {
            System.out.println("you are stratum 8. ");
        }
        else if((numberOfDefectiveScrews > 200) && (numberOfScrewsProduced < 10000))
        {
            System.out.println("you are stratum 5.");
        }
        else if ((numberOfDefectiveScrews < 200) && (numberOfScrewsProduced < 10000))
        {
            System.out.println("you are stratum 6.");
        }
        else // if ((numberOfDefectiveScrews > 200) && (numberOfScrewsProduced > 10000))
        {
            System.out.println("you are stratum 7.");

        }
    }
}

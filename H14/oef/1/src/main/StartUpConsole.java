package main;

import domein.EigenString;
import ui.TelApplicatie;

import java.util.Scanner;

public class StartUpConsole {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        EigenString eigenString = null;
        boolean herhalen = true;

        while (herhalen){
            try{
                System.out.print("Geef een tekst: ");
                eigenString = new EigenString(input.nextLine());
                herhalen = false;
            } catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }
        }

        new TelApplicatie(eigenString);
    }
}

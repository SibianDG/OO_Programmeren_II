package ui;

import domein.Thermometer;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ThermometerApplicatie {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Thermometer thermometer;
        boolean herhalen = true;
        String tempString;

        do {
            try {
                System.out.print("Geef temperatuur (in F) in interval [14, 104]: ");
                tempString = input.next();
                thermometer = new Thermometer();
                thermometer.stelAantalGradenIn(tempString);

                System.out.printf("De temp  is %d °C%n", thermometer.converteerNaarCelcius());
                herhalen = false;
            } catch (NumberFormatException nfe){
                System.out.println(nfe.getMessage());
            } catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            } catch (Exception e){
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        } while (herhalen);

    }

}

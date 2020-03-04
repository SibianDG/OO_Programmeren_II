package ui;

import domein.Thermometer;
import exceptions.BuitenBereikException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ThermometerApplicatie {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Thermometer thermometer;
        boolean herhalen = true;

        do {
            try {
                System.out.print("Geef temperatuur (in F) in interval [14, 104]: ");
                int temp = input.nextInt();
                if (temp > 104 || temp < 14) throw new BuitenBereikException("De temp ligt niet in interval.");
                thermometer = new Thermometer(temp);
                System.out.printf("De temp  is %d °C%n", thermometer.converteerNaarCelcius());
                herhalen = false;
            } catch (InputMismatchException ie) {
                System.out.println("Foutieve invoer! Moet numeriek zijn!");
            } catch (BuitenBereikException bre){
                System.out.println(bre.getMessage());
            } catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            } catch (Exception e){
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        } while (herhalen);

    }

}

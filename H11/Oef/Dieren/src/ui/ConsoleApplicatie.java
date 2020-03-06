package ui;

import domein.DierSoort;
import domein.DomeinController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleApplicatie {

    private final DomeinController domeinController;

    public ConsoleApplicatie(DomeinController domeinController) {
        this.domeinController = domeinController;
    }

    private int maakKeuze(){
        Scanner input = new Scanner(System.in);

        boolean nietCorrect = true;
        int keuze = 0;
        while (nietCorrect) {
            keuze = 0;
            try {
                System.out.printf("Maak je keuze:%n 1: toevoegen kat%n 2: toevoegen hond%n 3: stoppen%n");
                keuze = input.nextInt();
                if (keuze >= 1 && keuze <= 3) {
                    nietCorrect = false;
                }
            } catch (InputMismatchException ime) {
                input.next();
                System.out.println("Voer een getal in.");
            }
        }
        return keuze;
    }

    public void startApplicatie(){
        String jaar;
        String[] gegHond;

        System.out.println(domeinController.maakOverzicht());
        int keuze = maakKeuze();

        while (keuze != 3) {
            boolean nietCorrect = true;

            switch (DierSoort.values()[keuze-1]){
                case KAT:

                    while (nietCorrect){
                        try {
                            jaar = voerGegevensKatIn();
                            domeinController.voegKatToe(Integer.parseInt(jaar));
                            nietCorrect = false;
                            break;
                        } catch (NumberFormatException nfe){
                            System.out.println();
                        } catch (IllegalArgumentException iae){
                            System.out.println(iae.getMessage());
                        }
                    }


                case HOND:
                    while (nietCorrect) {
                        try {
                            // lector zei dat het oké is dat hij altijd geboortejaar én naam tegelijk opnieuw vraagt.
                            gegHond = voerGegevensHondIn();
                            domeinController.voegHondToe(gegHond[1], Integer.parseInt(gegHond[0]));
                            nietCorrect = false;
                            break;
                        } catch (NumberFormatException nfe) {
                            System.out.println();
                        } catch (IllegalArgumentException iae) {
                            System.out.println(iae.getMessage());
                        }
                    }

                default:
                    break;
            }
            System.out.println(domeinController.maakOverzicht());
            keuze = maakKeuze();
        }

    }

    private String voerGegevensKatIn(){
        Scanner input = new Scanner(System.in);
        System.out.println("Geef geboortejaar:");
        return input.next();
    }

    private String[] voerGegevensHondIn(){
        Scanner input = new Scanner(System.in);

        String[] result = new String[2];
        System.out.print("Geef geboortejaar van de hond: ");
        result[0] = input.next();

        System.out.print("Geef de naam van de hond: ");
        result[1] = input.next();

        return result;
    }
}

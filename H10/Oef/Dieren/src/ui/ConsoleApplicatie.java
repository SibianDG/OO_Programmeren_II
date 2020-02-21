package ui;

import domein.DierSoort;
import domein.DomeinController;

import java.util.Scanner;

public class ConsoleApplicatie {

    private DomeinController domeinController;

    public ConsoleApplicatie(DomeinController domeinController) {
        this.domeinController = domeinController;
    }

    private int maakKeuze(){
        Scanner input = new Scanner(System.in);
        int keuze = 0;

        do {
            System.out.printf("Maak je keuze:%n 1: toevoegen kat%n 2: toevoegen hond%n 3: stoppen%n");
            keuze = input.nextInt();
        } while (keuze <= 0 || keuze > 3);
        return keuze;
    }

    public void startApplicatie(){
        String jaar;
        String[] gegHond;

        System.out.println(domeinController.maakOverzicht());
        int keuze = maakKeuze();

        while (keuze != 3) {

            switch (DierSoort.values()[keuze-1]){
                case KAT:
                    jaar = voerGegevensKatIn();
                    domeinController.voegKatToe(Integer.parseInt(jaar));
                    break;
                case HOND:
                    gegHond = voerGegevensHondIn();
                    domeinController.voegHondToe(gegHond[1], Integer.parseInt(gegHond[0]));
                    break;
                default:
                    break;
            }
            System.out.println(domeinController.maakOverzicht());
            keuze = maakKeuze();
        }

    }

    private String voerGegevensKatIn(){
        Scanner input = new Scanner(System.in);
        System.out.println("Geef jaar:");
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

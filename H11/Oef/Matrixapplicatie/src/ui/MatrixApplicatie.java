package ui;

import domein.DomeinController;
import exceptions.DimensieException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MatrixApplicatie {

    private DomeinController dc;
    /*
    private final String ANSI_RESET="\u001B[0m";
    private final String ANSI_BLUE="\u001B[34m";
     */

    public MatrixApplicatie(DomeinController dc) {
        this.dc = dc;
    }

    public void startApplicatie() {
        Scanner input = new Scanner(System.in);
        int keuze = -1;

        while (keuze != 0){
            if (dc.getGekozenMatrix() == null){
                toonHoofdMenu(false);
                keuze = maakKeuzeUitLijst(0, 4);
            } else {
                toonHoofdMenu(true);
                keuze = maakKeuzeUitLijst(0, 6);
            }
            boolean herhalen = true;

            switch (keuze) {
                case 1:
                    int i = 0;
                    for (String matrix : dc.geefBeschrijvingMatrix()){
                        System.out.printf("%d.  %s%n", i++ +1, matrix);
                    }
                    break;
                case 2:
                    while (herhalen){
                        try {
                            System.out.println(dc.geefMatrix(input.nextInt()));
                            herhalen = false;
                        } catch (NumberFormatException nfe) {
                            System.out.println("Kies getal");
                        } catch (IllegalArgumentException iae) {
                            System.out.println("Fout getal");
                        }
                    }
                    break;
                case 3:
                    while (herhalen){
                        try {
                            System.out.print("Geef het aantal rijen: ");
                            int aantalRijen = input.nextInt();
                            int[][] intArray = new int[aantalRijen][aantalRijen];
                            for (int j = 0; j < aantalRijen; j++) {
                                for (int k = 0; k < aantalRijen; k++) {
                                    intArray[j][k] = input.nextInt();
                                    System.out.print(" ");
                                }
                            }
                            dc.voegNieuweMatrixToe(intArray);
                            herhalen = false;
                        } catch (InputMismatchException ime){
                            System.out.println("ime");
                        } catch (DimensieException de){
                            System.out.println(de.getMessage());
                        }
                    }
                    break;
                case 4:
                    toonMatrixNaarKeuze();
                    break;
                case 5:
                    while (herhalen){
                        try {
                            System.out.print("Geef het nummer van de matrix: ");
                            dc.geefSom(input.nextInt());
                            herhalen = false;
                        } catch (NumberFormatException nfe) {
                            System.out.println("Kies getal");
                        } catch (IllegalArgumentException iae) {
                            System.out.println("Fout getal");
                        }
                    }
                    break;
                case 6:
                    while (herhalen){
                        try {
                            System.out.print("Geef het nummer van de matrix: ");
                            dc.geefProduct(input.nextInt());
                            herhalen = false;
                        } catch (NumberFormatException nfe) {
                            System.out.println("Kies getal");
                        } catch (IllegalArgumentException iae) {
                            System.out.println("Fout getal");
                        }
                    }
                    break;
            }
        }
    }

    private void toonHoofdMenu(boolean bewerkingen) {
        System.out.printf("Kies uit:%n0. Stop de applicatie%n1. Toon de beschrijvingen alle matrices%n2. Bekijk een matrix%n3. Voeg een nieuwe matrix toe%n4. Selecteer een matrix");
        if (bewerkingen){
            System.out.printf("%n5. Tel op bij de geselecteerde matrix%n6. Vermenigvuldig met de geselecteerde matrix");
        }
    }

    private int maakKeuzeUitLijst(int min, int max) {
        Scanner input = new Scanner(System.in);
        int keuze;
        do {
            System.out.printf("%nUw keuze is: ");
            keuze = input.nextInt();
            if (keuze > max || keuze < min){
                throw new IllegalArgumentException(String.format("Geef een getal uit het interval [%d,%d].%nMaak opnieuw je keuze.%n", min, max));
            }

        } while (keuze < min || keuze > max);
        return keuze;
    }

    private void toonMatrixNaarKeuze() {
        System.out.print("Geef het nummer van de matrix: ");
        selecteerMatrixNaarKeuze();
        System.out.println(dc.geefMatrix(geefNummerMatrix()).toString());
    }

    private void selecteerMatrixNaarKeuze() {
        dc.selecteerMatrix(geefNummerMatrix());
    }

    private void toonBeschrijvingMatrices() {
        for (String matrxString : dc.geefBeschrijvingMatrix()){
            System.out.println(matrxString);
        }

    }

    private int geefNummerMatrix() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    private void toonSomVanMatrix() {

    }

    private void voegNieuweMatrixToe() {

    }
}

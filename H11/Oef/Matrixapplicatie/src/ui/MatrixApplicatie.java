package ui;

import domein.DomeinController;
import exceptions.DimensieException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MatrixApplicatie {

    private DomeinController dc;

    private final String ANSI_RESET="\u001B[0m";
    private final String ANSI_BLUE="\u001B[34m";

    public MatrixApplicatie(DomeinController dc) {
        this.dc = dc;
    }

    public void startApplicatie() {

        int keuze = -1;

        while (keuze != 0){
            try {
                if (dc.getGekozenMatrix() == null){
                    toonHoofdMenu(false);
                    keuze = maakKeuzeUitLijst(0, 4);
                } else {
                    toonHoofdMenu(true);
                    keuze = maakKeuzeUitLijst(0, 6);
                }

                switch (keuze) {
                    case 1:
                        toonBeschrijvingMatrices();
                        break;
                    case 2:
                        toonMatrixNaarKeuze();
                        break;
                    case 3:
                        voegNieuweMatrixToe();
                        break;
                    case 4:
                        selecteerMatrixNaarKeuze();
                        break;
                    case 5:
                        toonSomVanMatrix();
                        break;
                    case 6:
                        toonProductVanMatrix();
                        break;
                    default:
                        System.out.println(ANSI_BLUE + "Foute keuze, probeer opniuew");
                }
            } catch (IllegalArgumentException iae){
                System.out.println(ANSI_BLUE + iae.getMessage());
                System.out.print(ANSI_RESET);
            } catch (Exception e){
                System.out.println(ANSI_BLUE + e.getMessage());
                System.out.print(ANSI_RESET);
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
        System.out.println(dc.geefMatrix(geefNummerMatrix()));
    }

    private void selecteerMatrixNaarKeuze() {
        dc.selecteerMatrix(geefNummerMatrix());
    }

    private void toonBeschrijvingMatrices() {
        for (String matrixString : dc.geefBeschrijvingMatrix()){
            System.out.println(matrixString);
        }
        System.out.println();
    }

    private int geefNummerMatrix() {
        Scanner input = new Scanner(System.in);
        int nummer = -1;
        boolean herhalen = true;
        while (herhalen){
            try {
                System.out.println("Geef nummer matrix");
                nummer = input.nextInt();
                herhalen = false;
            } catch (NumberFormatException nfe) {
                System.out.println(ANSI_BLUE + "Kies getal");
                System.out.print(ANSI_RESET);
            } catch (IllegalArgumentException iae) {
                System.out.println(ANSI_BLUE + "Fout getal");
                System.out.print(ANSI_RESET);
            }
        }
        return nummer-1;
    }

    private void toonSomVanMatrix() {
        try {
            System.out.println(dc.geefSom(geefNummerMatrix()));
        } catch (DimensieException de){
            System.err.println(ANSI_BLUE + de.getMessage());
            System.out.print(ANSI_RESET);

        }
    }

    private void toonProductVanMatrix() {
        try {
            System.out.println(dc.geefProduct(geefNummerMatrix()));
        } catch (DimensieException de){
            System.err.println(ANSI_BLUE + de.getMessage());
            System.out.print(ANSI_RESET);

        }
    }

    private void voegNieuweMatrixToe() {
        Scanner input = new Scanner(System.in);
        boolean herhalen = true;
        while (herhalen){
            try {
                System.out.print("Geef het aantal rijen: ");
                int aantalRijen = input.nextInt();
                int[][] intArray = new int[aantalRijen][aantalRijen];
                for (int j = 0; j < aantalRijen; j++) {
                    System.out.printf("Geef rij %d: ", j+1);
                    for (int k = 0; k < aantalRijen; k++) {
                        //todo: op dezelfde lijn blijven
                        intArray[j][k] = input.nextInt();
                        System.out.print(" ");
                    }
                }
                dc.voegNieuweMatrixToe(intArray);
                herhalen = false;
            } catch (InputMismatchException ime){
                System.out.println(ANSI_BLUE + ime.getMessage());
                System.out.print(ANSI_RESET);
            } catch (DimensieException de){
                System.out.println(ANSI_BLUE +de.getMessage());
                System.out.print(ANSI_RESET);

            }
        }

    }
}

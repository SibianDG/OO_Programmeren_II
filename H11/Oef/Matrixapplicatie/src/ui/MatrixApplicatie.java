package ui;

import domein.DomeinController;

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
        toonHoofdMenu(false);


    }

    private void toonHoofdMenu(boolean bewerkingen) {
        System.out.printf("Kies uit:%n0. Stop de applicatie%n1. Toon de beschrijvingen alle matrices%n2. Bekijk de matrix%n3. Voeg een nieuwe matrix toe%n4. Selecteer een matrix");
        if (bewerkingen){
            System.out.printf("%n5. Tel op bij de geselecteerde matrix%n6. Vermenigvuldig met de geselecteerde matrix");
        }
    }

    private int maakKeuzeUitLijst(int min, int max) {
        Scanner input = new Scanner(System.in);
        int keuze;
        do {
            System.out.print("Uw keuze is: ");
            keuze = input.nextInt();
            if (keuze > max || keuze < min){
                throw new IllegalArgumentException(String.format("Geef een getal uit het interval [%d,%d].%nMaak opnieuw je keuze.%n", min, max));
            }
            //todo
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

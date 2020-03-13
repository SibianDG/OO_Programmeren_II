package ui;

import domein.DomeinController;
import exceptions.DimensieException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MatrixApplicatie {

	//final
    private DomeinController dc;

    private final String ANSI_RESET="\u001B[0m";
    private final String ANSI_BLUE="\u001B[34m";

    public MatrixApplicatie(DomeinController dc) {
        this.dc = dc;
    }

    public void startApplicatie() {

//    	toonHoofdMenu(false);
//        int keuze = maakKeuzeUitLijst(0, 4);
//        boolean geselecteerd = false;
        int keuze = -1;

        while (keuze != 0){
            try {
                if (dc.isErGekozenMatrix()){
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
                        //geselecteerd =true;
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
                //try catch in huplmethodes
            } catch (IllegalArgumentException iae){
                System.out.println(ANSI_BLUE + iae.getMessage());
                System.out.print(ANSI_RESET);
            } catch (Exception e){
                System.out.println(ANSI_BLUE + e.getMessage());
                System.out.print(ANSI_RESET);
            }
//            toonHoofdMenu(geselecteerd);
//            keuze = maakKeuzeUitLijst(0, geselecteerd?6:4);

        }
    }

    private void toonHoofdMenu(boolean bewerkingen) {
        System.out.printf("Kies uit:%n0. Stop de applicatie%n1. Toon de beschrijvingen alle matrices%n2. Bekijk een matrix%n3. Voeg een nieuwe matrix toe%n4. Selecteer een matrix");
        if (bewerkingen){
            System.out.printf("%n5. Tel op bij de geselecteerde matrix%n6. Vermenigvuldig met de geselecteerde matrix");
        }
    }

    private int maakKeuzeUitLijst(int min, int max) {
    	// OK - hierin de InputMismatchException opvangen => in do-while geen IllegalArgument gooien, maar InputMismatch opvangen en herkansing voorzien
        Scanner input = new Scanner(System.in);
        int keuze = 0;
        do {
            try{
                System.out.printf("%nUw keuze is: ");
                keuze = input.nextInt();
                if (keuze > max || keuze < min){
                    throw new InputMismatchException(String.format("Geef een getal uit het interval [%d,%d].%nMaak opnieuw je keuze.%n", min, max));
                }
            } catch (InputMismatchException ime){
                System.out.println("Geef een getal uit het interval.%nMaak opnieuw je keuze.%n");
            }

        } while (keuze < min || keuze > max);
        return keuze;
    }

    private void toonMatrixNaarKeuze() {
    	// OK -IndexOutOfBoundsException
    	try {
            System.out.println(dc.geefMatrix(geefNummerMatrix()));
        } catch (IndexOutOfBoundsException ioobe){
            System.out.println("De index bestaat niet in de matrixlijst.");
        }

    }

    private void selecteerMatrixNaarKeuze() {
    	// OK - hierin try/catch IndexOutOfBoundsException met herkansing invoer nummer
        boolean herhalen = true;
        while (herhalen){
            try {
                dc.selecteerMatrix(geefNummerMatrix());
                herhalen = false;
            } catch (IndexOutOfBoundsException ioobe){
                System.out.println("De index bestaat niet in de matrixlijst.");
            }
        }
    }

    private void toonBeschrijvingMatrices() {
    	//OK - hier kan nummering in geïntegreerd worden
        int index = 0;
        for (String matrixString : dc.geefBeschrijvingMatrix()){
            System.out.printf("%d. %s%n", index++,  matrixString);
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
            } 
            //nextInt => InputMismatchException! 
            catch (InputMismatchException ime){
                System.out.println(ANSI_BLUE + "Kies getal");
                System.out.print(ANSI_RESET);
            }
            catch (NumberFormatException nfe) {
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
        } catch (IndexOutOfBoundsException ioobe){
            System.out.println("De index bestaat niet in de matrixlijst.");
        }
        //OK - IndexOutOfBoundsException
    }

    private void toonProductVanMatrix() {
        try {
            System.out.println(dc.geefProduct(geefNummerMatrix()));
        } catch (DimensieException de){
            System.err.println(ANSI_BLUE + de.getMessage());
            System.out.print(ANSI_RESET);
        }catch (IndexOutOfBoundsException ioobe){
            System.out.println("De index bestaat niet in de matrixlijst.");
        }
        // OK - IndexOutOfBoundsException
    }

    private void voegNieuweMatrixToe() {
        Scanner input = new Scanner(System.in);
        boolean herhalen = true;
        while (herhalen){
            try {
                System.out.print("Geef het aantal rijen: ");
                int aantalRijen = input.nextInt();
                //aantalkolommen nog niet gekend => new int[aantalRijen][];
                int[][] intArray = new int[aantalRijen][aantalRijen];
                //todo
//                Voorbeeldcode: rij per rij wordt ingegeven als tekst!
//                System.out.printf("Geef rij %d: ", i + 1);
//                tekst = invoer2.nextLine();
//                String[] getallenS = tekst.split(" ");
//
//                int[] rij = new int[getallenS.length];
//
//                for (int j = 0; j < rij.length; j++) {
//                    rij[j] = Integer.parseInt(getallenS[j]);
//                }
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
                //nextLine!
            } catch (DimensieException de){
                System.out.println(ANSI_BLUE +de.getMessage());
                System.out.print(ANSI_RESET);

            }
        }

    }
}

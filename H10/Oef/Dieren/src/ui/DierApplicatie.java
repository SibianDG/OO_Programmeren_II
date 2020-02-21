package ui;

import domein.Hond;
import domein.Kat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DierApplicatie {
    public void start(){
        List<Hond> hondenlijst = new ArrayList<>();
        List<Kat> kattenlijst = new ArrayList<>();

        int aantalHonden = voerAantalIn("honden");
        for (int i = 0; i < aantalHonden; i++) {
            voegToeAanHondLijst(hondenlijst);
        }

        int aantalKatten = voerAantalIn("katten");
        for (int i = 0; i < aantalKatten; i++) {
            voegToeAanKatLijst(kattenlijst);
        }
        System.out.println(geefHondLijst(hondenlijst));
        System.out.println(geefKatLijst(kattenlijst));
    }

    private int voerAantalIn(String dieren){
        Scanner input = new Scanner(System.in);
        int aantal;
        do {
            System.out.printf("Geef het aantal %s in: ", dieren);
            aantal = input.nextInt();
        } while (aantal > 10);
        return aantal;
    }

    private void voegToeAanHondLijst(List<Hond> lijst){
        Scanner input = new Scanner(System.in);
        System.out.print("Geef naam van de hond: ");
        String naam = input.next();
        System.out.print("Geef geboortejaar van de hond: ");
        int geboortejaar = input.nextInt();
        lijst.add(new Hond(geboortejaar, naam));
    }

    private void voegToeAanKatLijst(List<Kat> lijst){
        Scanner input = new Scanner(System.in);
        System.out.print("Geef geboortejaar van de kat: ");
        int geboortejaar = input.nextInt();
        lijst.add(new Kat(geboortejaar));
    }

    private String geefHondLijst(List<Hond> lijst){
        String result = String.format("De honden in het asiel: %n%n");
        for (Hond hond: lijst) {
            result += hond.toString();
        }
        result += String.format("%n");
        return result;
    }

    private String geefKatLijst(List<Kat> lijst){
        String result = String.format("De katten in het asiel: %n%n");
        for (Kat kat: lijst) {
            result += kat.toString();
        }
        result += String.format("%n");
        return result;
    }
}

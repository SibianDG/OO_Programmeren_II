package ui;

import domein.Bier;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class BierApplicatie {
    public static void main(String[] args) {
        BierApplicatie bierApplicatie = new BierApplicatie();
        Scanner input = new Scanner(System.in);
        int percentage;
        do {
            percentage = input.nextInt();
        } while (percentage > 100 || percentage < 0);
        bierApplicatie.toonEnSchrijf(bierApplicatie.leesBierenMetMinAlcohol(percentage),
                "bierenMet"+percentage+"ofMeerProcentAlcohol.txt");

    }

    private List<Bier> leesBierenMetMinAlcohol(int min){
        List<Bier> biers = new ArrayList<>();
        try {
            Scanner input = new Scanner(Files.newInputStream((Paths.get("C:\\ProgrammerenII\\H15\\Oefeningen\\H15Oefening1\\bieren.txt"))));
            while (input.hasNext()){
                Bier bier = new Bier(input.next(), input.next(), input.nextDouble(), input.nextDouble(), input.nextLine());
                if (bier.getAlcoholgehalte() >= min){
                    biers.add(bier);
                }
            }
            input.close();
        } catch (InvalidPathException ie) {
            System.err.println("Error finding file.");
            System.exit(1);
        } catch (IOException ex) {
            System.err.println("Error reading file.");
            System.exit(1);
        }
        return biers;
    }

    private void toonEnSchrijf(List<Bier> lijst, String bestand){
        try {
            Formatter output = new Formatter(Files.newOutputStream(Paths.get(bestand)));
            for (Bier bier: lijst){
                output.format("%s%n", bier.getNaam());
            }
            output.close();
        } catch (InvalidPathException ie) {
            System.err.println("Error finding file.");
            System.exit(1);
        } catch (IOException ex) {
            System.err.println("Error writing file.");
            System.exit(1);
        }
    }
}

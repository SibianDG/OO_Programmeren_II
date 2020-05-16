package ui;

import domein.Kantoor;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.*;

public class KantoorApplicatie {
    public static void main(String[] args) {
        KantoorApplicatie kantoorApplicatie = new KantoorApplicatie();
        List<Kantoor> kantoorList = kantoorApplicatie.leesKantoren("C:\\ProgrammerenII\\H15\\Oefeningen\\H15Oefening2\\adressen.txt");
        int eersteCijfer = kantoorApplicatie.vraagPostcode();
        List<Kantoor> filtered = kantoorApplicatie.filter(kantoorList, eersteCijfer);
        kantoorApplicatie.serialiseer(filtered, "kantorenbeginnendmet"+eersteCijfer+".ser");

    }

    private List<Kantoor> leesKantoren(String invoerBestand){
        List<Kantoor> kantoors = new ArrayList<>();
        try (Scanner input = new Scanner(Files.newInputStream((Paths.get(invoerBestand))))) {
            while (input.hasNext()){
                try
                {
                    int postcode = input.nextInt();
                    String gemeente = input.next();
                    String adres = input.nextLine();
                    Kantoor kk = new Kantoor(postcode, gemeente, adres);
                    kantoors.add(kk);
                }
                catch (InputMismatchException e)
                {
                    System.err.println("Type gegevens klopt niet!");
                }
                catch (NoSuchElementException e)
                {
                    System.err.println("Er ontbreken gegevens!");
                }
                catch (IllegalArgumentException e)
                {
                    System.err.println(e.getMessage());
                }
            }
            // auto close -> try with resources
            //input.close();
        } catch (InvalidPathException ie) {
            System.err.println("Error finding file.");
            System.exit(1);
        } catch (IOException ex) {
            System.err.println("Error reading file.");
            System.exit(1);
        }
        return kantoors;
    }

    private int vraagPostcode() {
        Scanner input = new Scanner(System.in);
        System.out.print("Postcode: ");
        int postcode = 0;
        do {
            try {
                postcode = input.nextInt();
            } catch (InputMismatchException ime){
                System.out.println("Voer een getal in!");
            }
        } while (postcode > 9999 || postcode < 1000);
        return postcode;
    }

    private List<Kantoor> filter(List<Kantoor> kantoren, int eersteCijfer){
        List<Kantoor> kantoorList = new ArrayList<>();
        for (Kantoor kantoor: kantoren){
            if (kantoor.getPostcode() / 1000 == eersteCijfer){
                kantoorList.add(kantoor);
            }
        }
        return kantoorList;
    }

    private void serialiseer(List<Kantoor> lijst, String uitvoerBestand){
        try (ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(uitvoerBestand)))){
            outputStream.writeObject(lijst);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package persistentie;

import domein.BadkamerWinkel;
import domein.Classificatie;
import domein.KeukenWinkel;
import domein.Winkel;
import exceptions.SectorMisMatchException;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class WinkelMapper {

    public List<Winkel> geefStandaardWinkels() {
        return leesTekstBestandWinkels("C:\\Users\\sibia\\OneDrive - Hogeschool Gent\\1e bach\\Semester2\\OO_Programmeren_II\\VoorbeeldExamen\\OOP2_1819_Deel1Start\\winkels_in.txt");
    }

    public List<Winkel> leesTekstBestandWinkels(String naamBestand){
        List<Winkel> winkels = new ArrayList<>();
        try {
            Scanner input = new Scanner(Files.newInputStream((Paths.get(naamBestand))));
            while (input.hasNext()){
                String lijn = input.nextLine();

                String[] lijnArray = lijn.split("-");
                if (lijnArray[0].equals("b")){
                    winkels.add(new BadkamerWinkel(lijnArray[1], lijnArray[2], lijnArray[3], Integer.parseInt(lijnArray[4]), Classificatie.valueOf(lijnArray[5])));
                } else if (lijnArray[0].equals("k")){
                    winkels.add(new KeukenWinkel(lijnArray[1], lijnArray[2], lijnArray[3], Integer.parseInt(lijnArray[4]), Classificatie.valueOf(lijnArray[5])));
                } else {
                    System.err.println("een regel overgeslagen werd");
                }
            }
            input.close();
            System.out.println(winkels.toString());
        } catch (InvalidPathException ie) {
            System.err.println("Error finding file.");
            System.exit(1);
        } catch (IOException ex) {
            System.err.println("Error reading file.");
            System.exit(1);
        } catch (SectorMisMatchException e){
            System.err.println(e.getMessage());
        }
        return null;
    }

    public void serialiseerWinkels(List<Winkel> winkels, String naamBestand){
        try (ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(naamBestand)))){
            for (Winkel winkel: winkels){
                outputStream.writeObject(winkel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

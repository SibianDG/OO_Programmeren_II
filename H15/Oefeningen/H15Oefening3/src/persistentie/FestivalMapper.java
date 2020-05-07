package persistentie;

import domein.Artiest;
import domein.Festival;
import domein.Podium;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FestivalMapper {
    
    public List<Podium> maakPodia(String naamString, List<Artiest> artiesten){
        // TODO: 07/05/2020
        return null;
    }
    
    public List<Artiest> leesArtiestenUit(String naamBestand){
        List<Artiest> artiests = new ArrayList<>();
        try {
            Scanner input = new Scanner(Files.newInputStream((Paths.get(naamBestand))));
            while (input.hasNext()){
                // TODO: 07/05/2020  
                //Artiest artiest = new Artiest(input.next(), input.nextLine());
                //artiests.add(artiest);
            }
            input.close();
        } catch (InvalidPathException ie) {
            System.err.println("Error finding file.");
            System.exit(1);
        } catch (IOException ex) {
            System.err.println("Error reading file.");
            System.exit(1);
        }
        return artiests;
    }

    public void schrijfFestivalWeg(Festival f){
        try (ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get("festival.ser")))){
            // TODO: 07/05/2020 controleer
            outputStream.writeObject(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

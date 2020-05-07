package persistentie;

import domein.Bier;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class BierMapper
{

    public List<Bier> inlezenBieren(String naamBestand)
    {
        List<Bier> bieren = new ArrayList<>();
        try
        {
            Scanner input = new Scanner(Files.newInputStream(Paths.get("C:\\ProgrammerenII\\H7_deel2\\OOP2_H7_Bier_Start\\bieren.txt")));
            while (input.hasNext()){
                Bier nieuwBier = new Bier(input.next(), input.next(), input.nextDouble(), input.nextDouble(), input.nextLine());
                bieren.add(nieuwBier);
            }
        }
        catch (InvalidPathException ie)
        {
            System.err.println("Error finding file.");
            System.exit(1);
        }
        catch (IOException ex)
        {
            System.err.println("Error reading file.");
            System.exit(1);
        }
        return bieren;
    }


}

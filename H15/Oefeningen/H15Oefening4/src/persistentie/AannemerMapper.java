package persistentie;

import domein.Aannemer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

public class AannemerMapper
{   
    public List<Aannemer> leesAannemers() 
    {
        List<Aannemer> lijst = new ArrayList<> ();
        Path bestand = Paths.get("src//bestanden//aannemers.ser");
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(bestand));)
        {
            lijst = (List<Aannemer>) ois.readObject();
        } 
        catch (IOException ex)
        {
        	System.out.println(ex.getMessage());
            System.out.println("Aannemerbestand kan niet gevonden worden");
            System.exit(1);
        } 
        catch (ClassNotFoundException ex)
        {
            System.out.println("Bestand bevat geen aannemers!");
            System.exit(1);
        }
        return lijst;
    }   
}

package domein;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.List;
import java.util.Scanner;

public class DomeinController implements Serializable
{
    private final SpelerRepository spelerRepo;

    public DomeinController()
    {
        spelerRepo = new SpelerRepository();
    }



    public void schrijfNaarTekstBestand(String[][] spelers) {
        try {
            Formatter output = new Formatter(Files.newOutputStream(Paths.get("oef3.txt")));
            for (String[] speler: spelers){
                for (String info: speler){
                    output.format("%s\t", info);
                }
                output.format("%n");
            }
            output.close();
        } catch (InvalidPathException ie) {
            System.err.println("Error finding file.");
            System.exit(1);
        } catch (IOException ex) {
            System.err.println("Error reading file.");
            System.exit(1);
        }

    }

    public void serialiseerObjectPerObject(String[][] spelers) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get("C:\\ProgrammerenII\\H15\\Theorie\\H15Oef2Start\\src\\oef2a.ser")))){
            for (String[] speler: spelers){
                outputStream.writeObject(speler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serialiseerVolledigeLijst(String[][] spelers) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get("C:\\ProgrammerenII\\H15\\Theorie\\H15Oef2Start\\src\\oef2b.ser")))){
            outputStream.writeObject(spelers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] deSerialiseerObjectPerObject(String s) {
        try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get(s)))){
            return (String[]) input.readObject();
            // TODO: 06/05/2020  
        } catch (IOException | ClassNotFoundException ioe){
            System.out.println(ioe.getMessage());
        }
        return null;
    }

    public String[] leesTekstBestand(String s) {
        try {
            Scanner input = new Scanner(Files.newInputStream((Paths.get(s))));
            while (input.hasNext()){
                //Speler speler = new Speler(input.nextInt(), input.next(), input.next());
                // TODO: 06/05/2020 Wapens?
            }
            input.close();
        } catch (InvalidPathException ie) {
            System.err.println("Error finding file.");
            System.exit(1);
        } catch (IOException ex) {
            System.err.println("Error reading file.");
            System.exit(1);
        }
        return null;
    }


    public String[] deSerialiseerVolledigeLijst(String s) {
        try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get(s)))){
            return (String[]) input.readObject();
            // TODO: 06/05/2020
        } catch (IOException | ClassNotFoundException ioe){
            System.out.println(ioe.getMessage());
        }
        return null;
    }
}

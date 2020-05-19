package persistentie;

import domein.Speler;
import domein.Wapen;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class SpelerMapper
{

    public void serialiseerObjectPerObject(List<Speler> spelerslijst, String naamBestand)
    {
        try (ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(Paths.get(naamBestand))))
        {
            for (Speler s : spelerslijst)
            {
                output.writeObject(s);
            }
        } catch (InvalidPathException ie)
        {
            System.err.println("Error finding file.");
            System.exit(1);
        } catch (IOException io)
        {
            System.err.println("Error opening file.");
            System.exit(1);
        }

    }

    public void serialiseerVolledigeLijst(List<Speler> spelerslijst, String naamBestand)
    {
        try (ObjectOutputStream output = new ObjectOutputStream(Files.newOutputStream(Paths.get(naamBestand))))
        {
            output.writeObject(spelerslijst);
        } catch (InvalidPathException ie)
        {
            System.err.println("Error finding file.");
            System.exit(1);
        } catch (IOException io)
        {
            System.err.println("Error opening file.");
            System.exit(1);
        }

    }

    public List<Speler> deSerialiseerObjectPerObject(String naamBestand)
    {
        Speler speler = null;
        List<Speler> spelers = new ArrayList<>();
        try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get(naamBestand))))
        {
            while (true)
            {
                speler = (Speler) input.readObject();
                spelers.add(speler);
            }
        }
        catch (EOFException eof)
        {
        }
        catch (InvalidPathException ie)
        {
            System.err.println("Error finding file.");
            System.exit(1);
        }
        catch (IOException io)
        {
            System.err.println("Error opening file.");
            System.exit(1);
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }

        return spelers;
    }

    public List<Speler> deSerialiseerVolledigeLijst(String naamBestand)
    {
        List<Speler> spelers = null;
        try (ObjectInputStream input = new ObjectInputStream(Files.newInputStream(Paths.get(naamBestand))))
        {
            spelers = (List<Speler>) input.readObject();
        }
        catch (InvalidPathException ie)
        {
            System.err.println("Error finding file.");
            System.exit(1);
        }
        catch (IOException io)
        {
            System.err.println("Error opening file.");
            System.exit(1);
        }
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }

        return spelers;
    }

    public void schrijfNaarTekstBestand(List<Speler> spelerslijst, String naamBestand)
    {
        try (Formatter output = new Formatter(Files.newOutputStream(Paths.get(naamBestand))))
        {
            for (Speler speler : spelerslijst)
            {
                output.format("%d\t%s\t", speler.getKracht(), speler.getType());
                for (Wapen w : speler.getWapens())
                {
                    output.format("%s ", zonderspaties(w.getSoort()));
                }
                output.format("\n");
            }
        } catch (InvalidPathException ie)
        {
            System.err.println("Error finding file.");
            System.exit(1);
        } catch (IOException io)
        {
            System.err.println("Error opening file.");
            System.exit(1);
        }

    }

    private static String zonderspaties(String soort)
    {
        return soort.replaceAll(" ", "_");
    }

    public List<Speler> leesTekstBestand(String naamBestand)
    {
        List<Speler> spelers = new ArrayList<>();
        int kracht;
        String type, wapens;

        try (Scanner input = new Scanner(Files.newInputStream(Paths.get(naamBestand))))
        {
            while (input.hasNext())
            {
                kracht = input.nextInt();
                type = input.next();
                wapens = input.nextLine();
                voegSpelerToe(kracht, type, wapens, spelers);
            }
        } catch (InvalidPathException ie)
        {
            System.err.println("Error finding file.");
            System.exit(1);
        }
        catch (InputMismatchException e)
        {
            System.err.println("Type gegevens klopt niet!");
        } catch (NoSuchElementException e)
        {
            System.err.println("Er ontbreken gegevens!");
        } catch (IllegalArgumentException e)
        {
            System.err.println(e.getMessage());
        }  catch (IOException io)
        {
            System.err.println("Error opening file.");
            System.exit(1);
        }

        return spelers;
    }

    public static void voegSpelerToe(int kracht, String type, String wapens, List<Speler> spelers)
    {
        wapens = wapens.trim();
        String[] split = wapens.split("\\s+");
        Wapen eigenwapens[] = new Wapen[split.length];
        int index = 0;
        for (String s : split)
        {
            eigenwapens[index++] = new Wapen(zonderUnderscores(s));
        }
        spelers.add(new Speler(kracht, type, eigenwapens));
    }

    private static String zonderUnderscores(String s)
    {
        return s.replaceAll("_", " ");
    }
}

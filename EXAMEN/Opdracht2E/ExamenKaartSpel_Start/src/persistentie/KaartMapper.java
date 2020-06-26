package persistentie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import domein.Kaart;

public class KaartMapper
{
	public List<Kaart> geefKaartenInHand()
	{	
		
        List<Kaart> kaarten = new ArrayList<>();
        String kleur, punt;

        try (Scanner input = new Scanner(Files.newInputStream(Paths.get("src//bestanden//kaartenInHand.tx"))))
        {
            while (input.hasNext())
            {
                kleur = input.next();
                punt = input.next();
                kaarten.add(new Kaart(kleur, punt));
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

        return kaarten;

	}
}

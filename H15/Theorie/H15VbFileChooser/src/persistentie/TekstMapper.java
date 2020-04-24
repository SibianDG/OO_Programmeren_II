package persistentie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class TekstMapper
{
    public void bewaarTekst(String tekst,File naamBestand)
    {
        try(Formatter formatter=new Formatter(naamBestand))
        {
            formatter.format("%s", tekst);
        }
        catch(FileNotFoundException e)
        {
            //foutboodschap
        }
    }

    public String haalTekstOp(File gekozenBestand)
    {
        StringBuilder builder=new StringBuilder();
        try(Scanner scanner=new Scanner(gekozenBestand))
        {
            while(scanner.hasNext())
                builder.append(scanner.nextLine()).append("\n");
            return builder.toString();
        }
        catch(FileNotFoundException e)
        {
            //foutboodschap
        }
        return null;
    }
}

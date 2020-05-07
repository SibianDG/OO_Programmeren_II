package ui;

import domein.OrderRecord;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.Scanner;

public class RapportApplicatie
{

    public static final String INNAAM = "order.txt";
    public static final String UITNAAM = "korting.txt";
    public static final int MINAANTAL = 11;
    private Scanner input;
    private Formatter output;

    public static void main(String args[])
    {
        RapportApplicatie app = new RapportApplicatie();
        app.openFiles();
        app.kopieerKlantenMetKorting();
        app.closeFiles();
    }    

    private void openFiles()
    {
        try
        {
            input = new Scanner(Files.newInputStream(Paths.get(INNAAM)));
            output = new Formatter(Files.newOutputStream(Paths.get(UITNAAM)));
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
    }

    private void kopieerKlantenMetKorting()
    {
        try {
            while (input.hasNext()){
                OrderRecord orderRecord = new OrderRecord(input.next(), input.next(), input.nextInt(), input.nextDouble());
                if (orderRecord.getAantal() > MINAANTAL){
                    output.format("%s %s %d %.2f%n",
                            orderRecord.getNaam(), orderRecord.getProduct(), orderRecord.getAantal(), orderRecord.getPrijs()*.95);
                }
            }
            System.out.println("Klaar");
        } catch (FormatterClosedException formatterClosedException){
            System.out.println("Error writing file.");
        }
    }

    private void closeFiles()
    {
        if (output != null)
        {
            output.close();
        }

        if (input != null)
        {
            input.close();
        }
    }
}

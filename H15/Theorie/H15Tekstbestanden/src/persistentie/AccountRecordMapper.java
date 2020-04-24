package persistentie;

import domein.AccountRecord;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AccountRecordMapper
{

    private Formatter output;
    private Scanner input;

    private void openFileWrite()
    {
        try
        {
            output = new Formatter(Files.newOutputStream(Paths.get("clients.txt"),StandardOpenOption.APPEND));
        } 
        catch (InvalidPathException ie)
        {
            System.err.println("Error finding file.");
            System.exit(1);
        } 
        catch (IOException ex)
        {
            System.err.println("Error creating file.");
            System.exit(1);
        }

    }

    public void openFileRead()
    {
        try
        {
            input = new Scanner(Files.newInputStream(Paths.get("clients.txt")));
        } 
        catch (InvalidPathException ie)
        {
            System.err.println("Error finding file.");
            System.exit(1);
        } 
        catch (IOException ex)
        {
            System.err.println("Error opening file.");
            System.exit(1);
        }
    }

    public void addRecord(AccountRecord record)
    {
        if (output == null)
        {
            openFileWrite();
        }
        try
        {
            output.format("%d %s %s %.2f%n", record.getAccount(),
                    record.getFirstName(), record.getLastName(),
                    record.getBalance());
        } catch (FormatterClosedException formatterClosedException)
        //In geval Formatter reeds afgesloten is (close) terwijl je schrijft
        {
            System.err.println("Error writing to file.");
        }

    }

    public List<AccountRecord> readRecords()
    {
        if (input == null)
        {
            openFileRead();
        }

        List<AccountRecord> lijst = new ArrayList<>();
        //     AccountRecord record;

        try
        {
            while (input.hasNext())
            {
                /*
                record = new AccountRecord();
                record.setAccount(input.nextInt());
                record.setFirstName(input.next());
                record.setLastName(input.next());
                record.setBalance(input.nextDouble());
                lijst.add(record);
                */
                lijst.add(new AccountRecord(input.nextInt(), input.next(), input.next(), input.nextDouble()));

            }
        } catch (InputMismatchException elementException)
        //Indien de organisatie/type gegevens niet overeenstemmen.
        {
            System.err.println("File improperly formed.");
            input.close();
            System.exit(1);
        } catch (NoSuchElementException elementException)
        //Er ontbreken elementen
        {
            System.err.println("Element missing");
            input.close();
            System.exit(1);
        } catch (IllegalStateException stateException)
        //In geval van lezen terwijl Scanner reeds gesloten is.
        {
            System.err.println("Error reading from file.");
            System.exit(1);
        }
        return lijst;

    }

    public void closeFiles()
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

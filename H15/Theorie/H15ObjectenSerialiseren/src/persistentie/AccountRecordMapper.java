package persistentie;

import domein.AccountRecord;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class AccountRecordMapper
{

    private ObjectOutputStream output;
    private ObjectInputStream input;

    private void openFileSchrijven()
    {
        try
        {
            output = new ObjectOutputStream(Files.newOutputStream(
                    Paths.get("accounts.ser")));

        } catch (InvalidPathException ie)
        {
            System.err.println("Error finding file.");
            System.exit(1);
        } catch (IOException ex)
        {
            System.err.println("Error opening file.");
            System.exit(1);
        }

    }

    public void addRecord(AccountRecord record)
    {
        if (output == null)
        {
            openFileSchrijven();
        }
        try
        {
            output.writeObject(record);
        } catch (IOException ex)
        {
            System.err.println("Error writing to file.");
        }

    }

    public void openFileLezen()
    {
        try
        {
            input = new ObjectInputStream(Files.newInputStream(
                    Paths.get("accounts.ser")));
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

    public List<AccountRecord> readRecords()
    {
        if (input == null)
        {
            openFileLezen();
        }

        List<AccountRecord> lijst = new ArrayList<>();

        try
        {
            while (true)
            {
                AccountRecord record = (AccountRecord) input.readObject();
                lijst.add(record);

            }
        } catch (EOFException e)
        {
        }catch (ClassNotFoundException ex)
        {
            System.err.print("ongeldige objectstream");
            System.exit(1);
        } catch (IOException e)
        {
            System.err.println("Error reading file.");
            System.exit(1);
        } 
        return lijst;

    }

    public void closeFile()
    {
        if (output != null)
        {
            try
            {
                output.close();
            } catch (IOException ex)
            {
                System.exit(1);
            }
        }

        if (input != null)
        {
            try
            {
                input.close();
            } catch (IOException ex)
            {
                System.exit(1);
            }
        }
    }
}

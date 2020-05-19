package domein;

import java.util.ArrayList;
import java.util.List;
import persistentie.SpelerMapper;

public class SpelerRepository
{
    private final List<Speler> spelerslijst;
    private final SpelerMapper spelerMapper;

    public SpelerRepository()
    {
        spelerslijst = new ArrayList<>();
        spelerMapper = new SpelerMapper();
    }

    public void vulSpelerlijst(String gegevens[][])
    {
        spelerslijst.clear();
        int kracht;
        String type;
        Wapen wapens[];
        for (int rij = 0; rij < gegevens.length; rij++)
        {
            kracht = Integer.parseInt(gegevens[rij][0]);
            type = gegevens[rij][1];
            wapens = new Wapen[gegevens[rij].length - 2];
            int i = 0;
            for (int kol = 2; kol < gegevens[rij].length; kol++)
            {
                wapens[i++] = new Wapen(gegevens[rij][kol]);
            }
            spelerslijst.add(new Speler(kracht, type, wapens));
        }
    }

    public void schrijfNaarTekstBestand(String[][] gegevens)
    {
        this.vulSpelerlijst(gegevens);
        this.spelerMapper.schrijfNaarTekstBestand(spelerslijst, "oef3.txt");
    }

    public List<Speler> leesTekstBestand(String naamBestand)
    {
        return this.spelerMapper.leesTekstBestand(naamBestand);
    }
    public void serialiseerObjectPerObject(String[][] gegevens)
    {
        vulSpelerlijst(gegevens);
        spelerMapper.serialiseerObjectPerObject(spelerslijst, "oef2a.ser");
    }

    public void serialiseerVolledigeLijst(String[][] gegevens)
    {
        vulSpelerlijst(gegevens);
        spelerMapper.serialiseerVolledigeLijst(spelerslijst, "oef2b.ser");
    }

    public List<Speler> deSerialiseerObjectPerObject(String naamBestand)
    {
        return this.spelerMapper.deSerialiseerObjectPerObject(naamBestand);
    }

    public List<Speler> deSerialiseerVolledigeLijst(String naamBestand)
    {
        return this.spelerMapper.deSerialiseerVolledigeLijst(naamBestand);
    }


}

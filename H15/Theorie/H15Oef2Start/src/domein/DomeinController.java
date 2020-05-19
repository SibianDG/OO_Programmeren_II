package domein;

import java.util.List;

public class DomeinController
{
    private SpelerRepository spelerRepo;

    public DomeinController()
    {
        spelerRepo=new SpelerRepository();
    }

    public void serialiseerObjectPerObject(String[][] gegevens)
    {
        spelerRepo.serialiseerObjectPerObject(gegevens);
    }

    public void serialiseerVolledigeLijst(String[][] gegevens)
    {
        spelerRepo.serialiseerVolledigeLijst(gegevens);
    }

    public String[] deSerialiseerObjectPerObject(String naamBestand)
    {
        List<Speler> spelers=spelerRepo.deSerialiseerObjectPerObject(naamBestand);
        return omzettenNaarTekst(spelers);
    }

    public String[] deSerialiseerVolledigeLijst(String naamBestand)
    {
        List<Speler> spelers=spelerRepo.deSerialiseerVolledigeLijst(naamBestand);
        return omzettenNaarTekst(spelers);
    }

    public void schrijfNaarTekstBestand(String[][] gegevens)
    {
        spelerRepo.schrijfNaarTekstBestand(gegevens);
    }

    public String[] leesTekstBestand(String naamBestand)
    {
        List<Speler> spelers=spelerRepo.leesTekstBestand(naamBestand);
        return omzettenNaarTekst(spelers);
    }

    public String[] omzettenNaarTekst(List<Speler> spelers)
    {
        String[] spelersTekst=new String[spelers.size()];
        int i=0;
        for(Speler s:spelers)
            spelersTekst[i++]=s.toString();
        return spelersTekst;
    }

}

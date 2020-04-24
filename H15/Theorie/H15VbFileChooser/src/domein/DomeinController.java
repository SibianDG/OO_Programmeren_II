package domein;

import java.io.File;
import persistentie.TekstMapper;

public class DomeinController
{
    private final TekstMapper tekstMapper;

    public DomeinController()
    {
        tekstMapper=new TekstMapper();
    }
    
    public void bewaarTekst(String tekst,File naamBestand)
    {
        tekstMapper.bewaarTekst(tekst,naamBestand);
    }

    public String haalTekstOp(File gekozenBestand)
    {
        return tekstMapper.haalTekstOp(gekozenBestand);
    } 
    
}

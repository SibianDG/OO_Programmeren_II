package testen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.Aannemer;

public class AannemerTest
{
    private Aannemer a1;

    @BeforeEach
    public void before()
    {
        a1 = new Aannemer("Van Damme", "ramen en deuren", 37);       
    }
    
    @Test
    public void getNaamBedrijf_juisteNaamBijConstructie_geeftJuisteNaamTerug()
    {
        Assertions.assertEquals("Van Damme", a1.getNaamBedrijf());
    }    
    
    @Test
    public void getTypeBedrijf_juistTypeBijConstructie_geefJuisteTypeterug()
    {
        Assertions.assertEquals("ramen en deuren", a1.getTypeBedrijf());
    }
    
    @Test
    public void getAfstandInKm_juisteAfstandBijConstructie_geeftJuisteAfstandterug()
    {
        Assertions.assertEquals(37, a1.getAfstandInKm());
    }
    
    @Test
    public void maakAannemer_fouteAfstandBijConstructie_werptException()
    {
    	Assertions.assertThrows(IllegalArgumentException.class , () -> new Aannemer("", "", -1));
    }    
    
    @Test
    public void setBasisPrijs_fouteBasisPrijs_werptException()
    {
    	Assertions.assertThrows(IllegalArgumentException.class , () -> Aannemer.setBasisPrijs(-1));
    }  
    
    @Test
    public void bepaalOfferte_aannemera1_geeftJuisteOffertePrijsTerug()
    {
    	double percentageOnderBasis = a1.getPercentageOnderBasis();
    	double offerteprijs = Aannemer.getBasisPrijs() * (1 - percentageOnderBasis / 100.0) + Aannemer.getKmprijs() * a1.getAfstandInKm();
        Assertions.assertEquals(offerteprijs, a1.bepaalOfferte());
    }
}
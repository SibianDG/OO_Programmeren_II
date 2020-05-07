package domein;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.Bier;

/**
 * @author lvu621
 */
public class BierTest
{
    private Bier b1, b2, b3;

    @BeforeEach
    public void before()
    {
        b1 = new Bier("Leffe blond", "blond", 6.6, 7.1, "brouwerij van Leffe");
        b2 = new Bier("Leffe bruin", "bruin", 6.5, 6.8, "brouwerij van Leffe");
        b3 = null;
    }
    
    public void getNaam_juisteNaamBijConstructie_geeftLeffeBlondTerug()
    {
        Assertions.assertEquals("Leffe blond", b1.getNaam());
    }    
    
    @Test
    public void getSoort_juisteSoortBijConstructie_geeftbruinTerug()
    {
        Assertions.assertEquals("bruin", b2.getSoort());
    }
    
    @Test
    public void getAlcoholPercentage_juistAlcoholPercentageBijConstructie_geeft6komma6Terug()
    {
        Assertions.assertEquals(6.6, b1.getAlcoholgehalte(), 0.01);
    }
    
    @Test
    public void getBrouwerij_juisteBrouwerijBijConstructie_geeftbrouwerijvanLeffeTerug()
    {
        Assertions.assertEquals("brouwerij van Leffe", b2.getBrouwerij());
    }
    
    @Test
    public void getBeoordeling_juisteBeoordelingBijConstructie_geeft7komma1Terug()
    {
        Assertions.assertEquals(7.1, b1.getBeoordeling(), 0.01);
    }
    
    @Test
    public void maakBier_fouteNaamBijConstructie_werptException()
    {
    	Assertions.assertThrows(IllegalArgumentException.class , () -> new Bier("","bruin", 6.5, 6.8, "brouwerij van Leffe"));
    }    
    
    @Test
    public void maakBier_fouteSoortBijConstructie_werptException()
    {
    	Assertions.assertThrows(IllegalArgumentException.class , () -> new Bier("Leffe Blond",null, 6.5, 6.8, "brouwerij van Leffe"));
    }    
    
    @Test
    public void maakBier_foutAlcoholPercentageBijConstructie_werptException()
    {
    	Assertions.assertThrows(IllegalArgumentException.class , () -> new Bier("Leffe Blond","blond", 56.5, 6.8, "brouwerij van Leffe"));
    }    
    
     @Test
    public void maakBier_fouteBrouwerijBijConstructie_werptException()
    {
    	 Assertions.assertThrows(IllegalArgumentException.class , () -> new Bier("Leffe Blond","blond", 6.5, 6.8, ""));
    }    
    
     @Test
    public void maakBier_fouteBeoordelingBijConstructie_werptException()
    {
    	 Assertions.assertThrows(IllegalArgumentException.class , () -> new Bier("Leffe Blond","blond", 6.5, 16.8, "brouwerij van Leffe"));
    }    
    
    @Test
    public void toString_tekstueleWeergaveMETunderscore_geeftLeffe_blondTerug()
    {
        Assertions.assertEquals("Leffe_blond", b1.toString());
    }
}

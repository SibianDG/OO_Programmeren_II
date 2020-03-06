package testen;

import java.time.Year;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.Hond;

public class HondTest
{

    private Hond hond1, hond2;
    private int huidigJaar = Year.now().getValue();

    // Een hond die 12 jaar oud is zou in mensenjaren 75 jaar zijn
    private int ouderdomHond1 = 12;
    private int ouderdomHond1VolgensMens = 75;
    private int geboorteJaarHond1;

    private int ouderdomHond2 = 8;
    private int geboorteJaarHond2;

    @BeforeEach
    public void before()
    {
        geboorteJaarHond1 = huidigJaar - ouderdomHond1;
        geboorteJaarHond2 = huidigJaar - ouderdomHond2;

        hond1 = new Hond(geboorteJaarHond1, "Bobby");
        hond2 = new Hond(geboorteJaarHond2);
    }

    @Test
    public void maakHond_geboortejaarEnNaam_maaktObject()
    {
        Assertions.assertEquals(geboorteJaarHond1,hond1.getGeboortejaar());
        Assertions.assertEquals("Bobby",hond1.getNaam());
    }

    @Test
    public void maakHond_geboortejaarEnDefaultWaardeNaam_maaktObject()
    {
        Assertions.assertEquals("onbekend",hond2.getNaam());
    }

    @Test
    public void maakHond_geboortejaar1970HondTeOud_werptException()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Hond(1970));
    }

    @Test
    public void berekenLeeftijdVolgensMens_retourneertLeeftijdVolgensMens()
    {
        Assertions.assertEquals(ouderdomHond1VolgensMens,hond1.berekenLeeftijdVolgensMens());
    }

    @Test
    public void berekenLeeftijdDier_retourneertLeeftijd()
    {
        Assertions.assertEquals(ouderdomHond1,hond1.berekenLeeftijd());
    }

    @Test
    public void toString_retourneertTekstueleWeergave()
    {
        String check = String.format("HOND: leeftijd is %d en volgens de mens %d, naam is BOBBY", ouderdomHond1, 75);
        Assertions.assertEquals(check, hond1.toString());
    }
}

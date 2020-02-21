package testen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.Kat;


public class KatTest
{

    private Kat kat1;

    @BeforeEach
    public void before()
    {
        kat1 = new Kat(2003);
    }

    @Test
    public void maakKat_geboortejaar_maaktObject()
    {
        Assertions.assertEquals(2003, kat1.getGeboortejaar());
    }

    @Test
    public void maakKat_geboortejaarKatTeOud_werptException()
    {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Kat(1970));
    }

    @Test
    public void berekenLeeftijdVolgensMens_retourneertLeeftijdVolgensMens()
    {
        Assertions.assertEquals(119, kat1.berekenLeeftijdVolgensMens());
    }

    @Test
    public void berekenLeeftijdDier_retourneertLeeftijd()
    {
        Assertions.assertEquals(17, kat1.berekenLeeftijd());
    }

    @Test
    public void toString_retourneertTekstueleWeergave()
    {
        Assertions.assertEquals("KAT: leeftijd is 17 en volgens de mens 119", kat1.toString());
    }

}

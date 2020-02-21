package testen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.Rechthoek;

public class RechthoekTest
{

    private Rechthoek r1, r2;

    @BeforeEach
    public void before()
    {
        r1 = new Rechthoek(4, 2);
        r2 = new Rechthoek(2, 4);
    }

    @Test
    public void maakRechthoek_lengteEnBreedte_maaktObject()
    {
        Assertions.assertEquals(4.0, r1.getBreedte(),0);
        Assertions.assertEquals(2.0, r1.getLengte(),0);
    }

    @Test
    public void maakRechthoek_lengteMin2EnBreedte4_werptException()
    {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> new Rechthoek(4, -2));
    }

    @Test
    public void maakRechthoek_lengte2EnBreedteMin4_werptException()
    {
    	Assertions.assertThrows(IllegalArgumentException.class, () -> new Rechthoek(-4, 2));
    }

    @Test
    public void berekenOppervlakte_retourneertOppervlakte()
    {

        Assertions.assertEquals(8.0, r2.berekenOppervlakte(),0);
    }

    @Test
    public void berekenOmtrek_retourneertOmtrek()
    {
        Assertions.assertEquals(12.0, r2.berekenOmtrek(),0);
    }
}

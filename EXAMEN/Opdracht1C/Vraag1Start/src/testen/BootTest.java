package testen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.Boot;
import exceptions.FormaatException;

public class BootTest
{
    private Boot b;
    
    @BeforeEach
    public void before() throws FormaatException
    {
       b = new Boot();
    }
    @Test
    public void maakBoot_zonderAttributen_maaktObject()
    {
        Assertions.assertEquals(true, b.getZeewaardig());
    }
    @Test
    public void maakBoot_legeNaam_werptException() 
    {
         Assertions.assertThrows(IllegalArgumentException.class , () -> {new Boot("", true);});
    }
    @Test
    public void maakBoot_naamOngeldigFormaat_werptException() throws FormaatException
    {
         Assertions.assertThrows(FormaatException.class , () -> {new Boot("2014_nieuweboot", true);});
    }
}

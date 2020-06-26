package testen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.ZeilBoot;
import exceptions.FormaatException;

public class ZeilBootTest
{
	private ZeilBoot zb;
	    
    @BeforeEach
    public void before() throws FormaatException
    {
       zb = new ZeilBoot("2003_Veelwind", true, 2);
    }
    @Test
    public void maakWoonBoot_met3attributen_maaktObject()
    {
        Assertions.assertEquals(2, zb.getAantalMasten());
    }
    @Test
    public void maakzeilBoot_aantalPersonenTeKlein_werptException() 
    {
         Assertions.assertThrows(IllegalArgumentException.class , () -> {new ZeilBoot("2015_Koningwind", true, 0);});
    }
}
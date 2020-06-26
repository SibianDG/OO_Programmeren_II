package testen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.WoonBoot;
import exceptions.FormaatException;

public class WoonBootTest 
{
	 private WoonBoot wb;
	    
	    @BeforeEach
	    public void before() throws FormaatException
	    {
	       wb = new WoonBoot("1995_Rustigwater", false, 6, 1);
	    }
	    @Test
	    public void maakWoonBoot_met4attributen_maaktObject()
	    {
	        Assertions.assertEquals(1, wb.getAantalBadkamers());
	    }
	    @Test
	    public void maakWoonBoot_aantalBadkamersNegatief_werptException() 
	    {
	         Assertions.assertThrows(IllegalArgumentException.class , () -> {new WoonBoot("2015_Koningzee", true, 1 , -1);});
	    }
        @Test
	    public void berekenMilieuheffing_levertCorrecteWaarde()
	    {
	        Assertions.assertEquals(50, wb.berekenMilieuheffing() );
	    }
}

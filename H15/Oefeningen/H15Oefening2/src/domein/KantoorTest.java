package domein;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.Kantoor;

public class KantoorTest
{
    private Kantoor kk1, kk2, kk3;

    @BeforeEach
    public void before()
    {
        kk1 = new Kantoor(9000, "Gent", "Charles De Kerchovelaan 85");
        kk2 = new Kantoor(1000, "Brussel", "Keizer Karellaan 586");
        kk3 = null;
    }
    
    public void getPostcode_juistePostcodeBijConstructie_geeft9000Terug()
    {
        Assertions.assertEquals(9000, kk1.getPostcode());
    }    
    
    @Test
    public void getGemeente_juisteGemeenteBijConstructie_geeftBrusselTerug()
    {
        Assertions.assertEquals("Brussel", kk2.getGemeente());
    }
    
    @Test
     public void getAdres_juistAdresBijConstructie_geeftCharlesDeKerchovelaan85Terug()
    {
        Assertions.assertEquals("Charles De Kerchovelaan 85", kk1.getAdres());
    }
    
    @Test
    public void maakKlantenKantoor_foutePostcodeBijConstructie_werptException()
    {
    	Assertions.assertThrows(IllegalArgumentException.class , () -> new Kantoor(10000, "een gemeente", "een adres"));
    }
    
    @Test
    public void maakKlantenKantoor_fouteGemeenteBijConstructie_werptException()
    {
    	Assertions.assertThrows(IllegalArgumentException.class , () -> new Kantoor(8000, "", "ergens in Brugge"));
    }
    
    @Test
    public void maakKlantenKantoor_foutAdresBijConstructie_werptException()
    {
    	Assertions.assertThrows(IllegalArgumentException.class , () -> new Kantoor(8500, "Kortrijk", null));
    }
    
    @Test
    public void toString_tekstueleWeergave_geeft1000_Brussel_Keizer_Karellaan_586Terug()
    {
        Assertions.assertEquals("1000 Brussel Keizer Karellaan 586", kk2.toString());
    }
}
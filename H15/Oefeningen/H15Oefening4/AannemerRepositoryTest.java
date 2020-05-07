package testen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.AannemerRepository;

public class AannemerRepositoryTest
{
    private AannemerRepository ar;

    @BeforeEach
    public void before()
    {
        ar = new AannemerRepository();
    }
    
    @Test
    public void geefTypesAannemers_metGegevenBestand_3types()
    {
        Assertions.assertEquals(3, ar.geefTypesAannemers().size());
    }    
    
    @Test
    public void geefTypesAannemers_typeruwbouw_metGegevenBestand_2aannemers()
    {
    	ar.bepaalAannemersVanType("ruwbouw");
        Assertions.assertEquals(2,ar.getGefilterdeLijst().size());
    }  
    
    @Test
    public void geefGegevens_metGegevenBestand_geenFilterToegepast_index0_geeftException()
    {
    	Assertions.assertThrows(IndexOutOfBoundsException.class , () -> ar.geefGegevens(0));
    } 
    
    @Test
    public void geefGegevens_metGegevenBestand_filterOpTimmerwerken_index1_geeftVan_Houtte_Yves_NV()
    {
    	ar.bepaalAannemersVanType("timmerwerken");
    	Assertions.assertEquals("Van Houtte Yves NV" ,ar.geefGegevens(1)[0]);
    } 
    
    @Test
    public void geefGegevens_metGegevenBestand_filterOpSanitair_index5_geeftException()
    {
    	ar.bepaalAannemersVanType("sanitair");
    	Assertions.assertThrows(IndexOutOfBoundsException.class , () -> ar.geefGegevens(5));
    } 
    
}
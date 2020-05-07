package domein;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.Artiest;

public class ArtiestTest
{
    private Artiest a1, a2, a3;

    @BeforeEach
    public void before()
    {
        a1 = new Artiest("Prince", MuziekGenre.POP);
        a2 = new Artiest("Marina Wally", MuziekGenre.VLAAMS);
        a3 = new Artiest("someone", MuziekGenre.ELEKTRO);       
    }
    
    public void getNaam_juisteNaamBijConstructie_geeftPrinceTerug()
    {
        Assertions.assertEquals("Prince", a1.getNaam());
    }    
    
    @Test
    public void getGenre_juistGenreBijConstructie_geeftVLAAMSterug()
    {
        Assertions.assertEquals(MuziekGenre.VLAAMS, a2.getGenre());
    }
    
    @Test
    public void maakArtiest_fouteNaamBijConstructie_werptException()
    {
    	Assertions.assertThrows(IllegalArgumentException.class , () -> new Artiest("", MuziekGenre.CLASSIC));
    }    
      
    @Test
    public void toString_tekstueleWeergave_geeftArtiest_Prince_speelt_het_genre_POPTerug()
    {
        Assertions.assertEquals("Artiest Prince speelt het genre POP", a1.toString());
    }
}
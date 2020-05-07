package domein;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.Artiest;
import domein.LineUp;

public class LineUpTest
{
    private LineUp lu1, lu2;
    private Artiest a1;

    @BeforeEach
    public void before()
    {
        lu1 = new LineUp();
        lu2 = new LineUp();
        a1 = new Artiest("Marina Wally", MuziekGenre.VLAAMS);
        lu1.voegNieuweArtiestToe(a1);
    }
    
    public void getAantalArtiesten_legeArtiestenLijstBijConstructie_geeft0Terug()
    {
        Assertions.assertTrue(lu2.getAantalArtisten() == 0);

    }    
    
    @Test
    public void getAantalArtiesten_1ArtiestBijConstructie_geeft1Terug()
    {
        Assertions.assertTrue(lu1.getAantalArtisten() == 1);
    }
    
    @Test
    public void getArtiest_1ArtiestBijConstructie_geeftArtiestTerug()
    {
        Assertions.assertEquals(a1, lu1.getArtiest(0));
    }
    
    @Test
    public void toString_tekstueleWeergave_geeftArtiest_Marina_Wally_speelt_het_genre_VLAAMSTerug()
    {
        Assertions.assertEquals(String.format("%s\n", 
            "Artiest Marina Wally speelt het genre VLAAMS"), lu1.toString());
    }
}
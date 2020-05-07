package domein;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.Artiest;
import domein.LineUp;
import domein.Podium;

public class PodiumTest
{
    private Podium p1;
    private LineUp lu1, lu2;
    private Artiest a1, a2, a3;

    @BeforeEach
    public void before()
    {
        p1 = new Podium(2);
        lu1 = new LineUp();
        lu2 = new LineUp();
        a1 = new Artiest("Marina Wally", MuziekGenre.VLAAMS);
        a2 = new Artiest("Andre Rieu", MuziekGenre.CLASSIC);
        a3 = new Artiest("Madonna", MuziekGenre.POP);
        lu1.voegNieuweArtiestToe(a1);
        lu1.voegNieuweArtiestToe(a2);
        lu2.voegNieuweArtiestToe(a3);
        p1.voegLineUpToe(lu1);
        p1.voegLineUpToe(lu2);
    }

    @Test
    public void toString_tekstueleWeergave_geeftOverzichtDag1en2Terug()
    {
        System.out.println(p1.toString());
        Assertions.assertEquals(String.format("%s\n%s\n%s\n\n%s\n%s\n\n", "Dag 1",
            "Artiest Marina Wally speelt het genre VLAAMS",
            "Artiest Andre Rieu speelt het genre CLASSIC", "Dag 2",
            "Artiest Madonna speelt het genre POP"), p1.toString());
    }
}
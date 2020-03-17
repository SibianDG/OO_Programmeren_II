package testen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.EigenString;

class EigenStringTest
{
    private EigenString str1, str2;

    @BeforeEach
    public void before()
    {
        str1 = new EigenString("Dit is een test");
        str2 = new EigenString("Nog een tekstje");
    }

    @Test
    public void maakEigenString_tekstIngevuld_maaktObject()
    {
        Assertions.assertEquals("Dit is een test",str1.getTekst());
    }

    @Test
    public void setTekst_tekstNull_werptException()
    {
        Assertions.assertThrows(IllegalArgumentException.class , () -> {str2.setTekst(null);});

    }

    @Test
    public void setTekst_tekstLegeString_werptException()
    {
        Assertions.assertThrows(IllegalArgumentException.class , () -> {str2.setTekst("");});
    }

    @Test
    public void tellen_invoerZin_retourneertCorrectResultaat()
    {

        Assertions.assertEquals(String.format("In de zin \" Dit is een test \" %n%n"
                + "      Soort karakter              Aantal%n" +
                "             Klinker                   5%n" +
                "         Medeklinker                   7%n" +
                "              Cijfer                   0%n" +
                "              Andere                   3%n" +
                "       Kleine letter                  11%n" +
                "         Hoofdletter                   1%n"),str1.telKaraktersVolgensSoort());
    }
}

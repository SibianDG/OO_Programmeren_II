package testen;

import exceptions.SectorMisMatchException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import domein.*;

public class KeukenWinkelTest {

    private Winkel b1;

    @Test
    public void maakKeukenWinkel_allesnormaal_objectWerdGemaakt() throws SectorMisMatchException {
        b1 = new KeukenWinkel("normaal", "gent", "ABC1234", 1000, Classificatie.MIDDEL_GROOT);
        Assertions.assertEquals("normaal", b1.getNaam());
    }

    @Test
    public void maakKeukenWinkel_naamLegeString_gooitException() throws SectorMisMatchException {
        Assertions.assertThrows(IllegalArgumentException.class , () -> {new KeukenWinkel("", "gent", "ABC1234", 1000, Classificatie.MIDDEL_GROOT);});
    }

    @Test
    public void maakKeukenWinkel_naamNull_gooitException() throws SectorMisMatchException {
        Assertions.assertThrows(IllegalArgumentException.class , () -> {new KeukenWinkel(null, "gent", "ABC1234", 1000, Classificatie.MIDDEL_GROOT);});
    }

    @Test
    public void maakKeukenWinkel_sector3hoofdletters4cijfers_objectWerdGemaakt() throws SectorMisMatchException {
        b1 = new KeukenWinkel("normaal", "gent", "ABC1234", 1000, Classificatie.MIDDEL_GROOT);
        Assertions.assertEquals("ABC1234", b1.getSector());
    }

    @Test
    public void maakKeukenWinkel_sector3hoofdletters1cijfer_gooitException() throws SectorMisMatchException {
        Assertions.assertThrows(SectorMisMatchException.class , () -> {new KeukenWinkel("normaal", "gent", "ABC1", 1000, Classificatie.MIDDEL_GROOT);});
    }

    @Test
    public void maakKeukenWinkel_sector3kleineletters4cijfers_gooitException() throws SectorMisMatchException {
        Assertions.assertThrows(SectorMisMatchException.class , () -> {new KeukenWinkel("normaal", "gent", "abc1234", 1000, Classificatie.MIDDEL_GROOT);});
    }

    @Test
    public void maakKeukenWinkel_sector5kleineletters2cijfers_objectWerdGemaakt() throws SectorMisMatchException {
        b1 = new KeukenWinkel("normaal", "gent", "abcde24", 1000, Classificatie.MIDDEL_GROOT);
        Assertions.assertEquals("abcde24", b1.getSector());
    }

    @Test
    public void maakKeukenWinkel_sector5kleineletters1cijfer_gooitException() throws SectorMisMatchException {
        Assertions.assertThrows(SectorMisMatchException.class , () -> {new KeukenWinkel("normaal", "gent", "abcde2", 1000, Classificatie.MIDDEL_GROOT);});
    }

    @Test
    public void maakKeukenWinkel_sector5kleineletters5cijfers_objectWerdGemaakt() throws SectorMisMatchException {
        b1 = new KeukenWinkel("normaal", "gent", "abcde23456", 1000, Classificatie.MIDDEL_GROOT);
        Assertions.assertEquals("abcde23456", b1.getSector());
    }

    @Test
    public void maakKeukenWinkel_sector5kleineEnGroteletters2cijfers_gooitException() throws SectorMisMatchException {
        Assertions.assertThrows(SectorMisMatchException.class , () -> {new KeukenWinkel("normaal", "gent", "aBcde24", 1000, Classificatie.MIDDEL_GROOT);});
    }

    @Test
    public void maakKeukenWinkel_omzetNegatief_gooitException() throws SectorMisMatchException {
        Assertions.assertThrows(IllegalArgumentException.class , () -> {new KeukenWinkel("normaal", "gent", "ABC1234", -1000, Classificatie.MIDDEL_GROOT);});
    }

    @Test
    public void maakKeukenWinkel_omzetNul_gooitException() throws SectorMisMatchException {
        Assertions.assertThrows(IllegalArgumentException.class , () -> {new KeukenWinkel("normaal", "gent", "ABC1234", 0, Classificatie.MIDDEL_GROOT);});
    }

    @Test
    public void maakKeukenWinkel_classificatieNull_gooitException() throws SectorMisMatchException {
        Assertions.assertThrows(IllegalArgumentException.class , () -> {new KeukenWinkel("normaal", "gent", "ABC1234", 100, null);});
    }

    @Test
    public void geefJaarlijkseBelasting_berekentOmzet_geeftWaardeTerug() throws SectorMisMatchException {
        KeukenWinkel kw = new KeukenWinkel("normaal", "gent", "ABC1234", 1000, Classificatie.MIDDEL_GROOT);
        Assertions.assertEquals(2500, kw.geefJaarlijkseBelasting(), 0.01);
    }

    @Test
    public void toString_tekstweergave_geeftTekstTerug() throws SectorMisMatchException {
        KeukenWinkel kw = new KeukenWinkel("normaal", "gent", "ABC1234", 1000, Classificatie.MIDDEL_GROOT);
        Assertions.assertEquals("KeukenWinkel normaal, in gent, sector= ABC1234, omzet= 1000 ", kw.toString());
    }
}

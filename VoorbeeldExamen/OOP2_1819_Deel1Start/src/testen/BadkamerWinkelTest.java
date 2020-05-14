package testen;

import domein.*;
import exceptions.SectorMisMatchException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BadkamerWinkelTest {

    private Winkel b1;

    @Test
    public void maakBadkamerWinkel_allesnormaal_objectWerdGemaakt() throws SectorMisMatchException {
        b1 = new BadkamerWinkel("normaal", "gent", "ABC1234", 1000, Classificatie.MIDDEL_GROOT);
        Assertions.assertEquals("normaal", b1.getNaam());
    }

    @Test
    public void maakBadkamerWinkel_naamLegeString_gooitException() throws SectorMisMatchException {
        Assertions.assertThrows(IllegalArgumentException.class , () -> {new BadkamerWinkel("", "gent", "ABC1234", 1000, Classificatie.MIDDEL_GROOT);});
    }

    @Test
    public void maakBadkamerWinkel_naamNull_gooitException() throws SectorMisMatchException {
        Assertions.assertThrows(IllegalArgumentException.class , () -> {new BadkamerWinkel(null, "gent", "ABC1234", 1000, Classificatie.MIDDEL_GROOT);});
    }

    @Test
    public void maakBadkamerWinkel_sector3hoofdletters4cijfers_objectWerdGemaakt() throws SectorMisMatchException {
        b1 = new BadkamerWinkel("normaal", "gent", "ABC1234", 1000, Classificatie.MIDDEL_GROOT);
        Assertions.assertEquals("ABC1234", b1.getSector());
    }

    @Test
    public void maakBadkamerWinkel_sector3hoofdletters1cijfer_gooitException() throws SectorMisMatchException {
        Assertions.assertThrows(SectorMisMatchException.class , () -> {new BadkamerWinkel("normaal", "gent", "ABC1", 1000, Classificatie.MIDDEL_GROOT);});
    }

    @Test
    public void maakBadkamerWinkel_sector3kleineletters4cijfers_gooitException() throws SectorMisMatchException {
        Assertions.assertThrows(SectorMisMatchException.class , () -> {new BadkamerWinkel("normaal", "gent", "abc1234", 1000, Classificatie.MIDDEL_GROOT);});
    }

    @Test
    public void maakBadkamerWinkel_sector5kleineletters2cijfers_objectWerdGemaakt() throws SectorMisMatchException {
        b1 = new BadkamerWinkel("normaal", "gent", "abcde24", 1000, Classificatie.MIDDEL_GROOT);
        Assertions.assertEquals("abcde24", b1.getSector());
    }

    @Test
    public void maakBadkamerWinkel_sector5kleineletters1cijfer_gooitException() throws SectorMisMatchException {
        Assertions.assertThrows(SectorMisMatchException.class , () -> {new BadkamerWinkel("normaal", "gent", "abcde2", 1000, Classificatie.MIDDEL_GROOT);});
    }

    @Test
    public void maakBadkamerWinkel_sector5kleineletters5cijfers_objectWerdGemaakt() throws SectorMisMatchException {
        b1 = new BadkamerWinkel("normaal", "gent", "abcde23456", 1000, Classificatie.MIDDEL_GROOT);
        Assertions.assertEquals("abcde23456", b1.getSector());
    }

    @Test
    public void maakBadkamerWinkel_sector5kleineEnGroteletters2cijfers_gooitException() throws SectorMisMatchException {
        Assertions.assertThrows(SectorMisMatchException.class , () -> {new BadkamerWinkel("normaal", "gent", "aBcde24", 1000, Classificatie.MIDDEL_GROOT);});
    }

    @Test
    public void maakBadkamerWinkel_omzetNegatief_gooitException() throws SectorMisMatchException {
    	Assertions.assertThrows(IllegalArgumentException.class , () -> {new BadkamerWinkel("normaal", "gent", "ABC1234", -1000, Classificatie.MIDDEL_GROOT);});
    }

    @Test
    public void maakBadkamerWinkel_omzetNul_gooitException() throws SectorMisMatchException {
    	Assertions.assertThrows(IllegalArgumentException.class , () -> {new BadkamerWinkel("normaal", "gent", "ABC1234", 0, Classificatie.MIDDEL_GROOT);});
    }

    @Test
    public void maakBadkamerWinkel_classificatieNull_gooitException() throws SectorMisMatchException {
        Assertions.assertThrows(IllegalArgumentException.class , () -> {new BadkamerWinkel("normaal", "gent", "ABC1234", 100, null);});
    }

    @Test
    public void maakBadkamerWinkel_allesnormaalMetVoorraad_objectWerdGemaakt() throws SectorMisMatchException {
        DoucheBak db = new DoucheBak(120, 90, "composiet");
        List<DoucheBak> voorraad = new ArrayList<>();
        voorraad.add(db);
        BadkamerWinkel bdw = new BadkamerWinkel("normaal", "gent", "ABC1234", 1000, Classificatie.MIDDEL_GROOT, voorraad);
        voorraad = bdw.getVoorraad();
        Assertions.assertEquals(1, voorraad.size());
    }

    @Test
    public void geefDoucheBakkenMetLengteEnBreedteEnMateriaal_1douchebakVoldoet_geeft1Terug() throws SectorMisMatchException {
        List<DoucheBak> voorraad = new ArrayList<>();
        voorraad.add(new DoucheBak(120, 90, "composiet"));
        voorraad.add(new DoucheBak(120, 90, "acryl"));
        BadkamerWinkel bdw = new BadkamerWinkel("normaal", "gent", "ABC1234", 1000, Classificatie.MIDDEL_GROOT, voorraad);
        DoucheBak[] bakken = bdw.geefDoucheBakkenMetLengteEnBreedteEnMateriaal(100, 90, "acryl");
        Assertions.assertEquals(1, bakken.length);
    }

    @Test
    public void geefJaarlijkseBelasting_berekentOmzet_geeftWaardeTerug() throws SectorMisMatchException {
        BadkamerWinkel bdw = new BadkamerWinkel("normaal", "gent", "ABC1234", 1000, Classificatie.MIDDEL_GROOT);
        Assertions.assertEquals(25.0, bdw.geefJaarlijkseBelasting(), 0.01);
    }

    @Test
    public void toString_tekstweergave_geeftTekstTerug() throws SectorMisMatchException {
        BadkamerWinkel bdw = new BadkamerWinkel("normaal", "gent", "ABC1234", 1000, Classificatie.MIDDEL_GROOT);
        Assertions.assertEquals("BadkamerWinkel normaal, in gent, sector= ABC1234, omzet= 1000 ", bdw.toString());
    }

    @Test
    public void voegDoucheBakAanVoorraadToe_toevoegen_voegt1Toe() throws SectorMisMatchException {
        BadkamerWinkel bdw = new BadkamerWinkel("normaal", "gent", "ABC1234", 1000, Classificatie.MIDDEL_GROOT);
        DoucheBak db = new DoucheBak(120, 90, "composiet");
        bdw.voegDoucheBakAanVoorraadToe(db);
        Assertions.assertEquals(1,bdw.getVoorraad().size());
    }
}

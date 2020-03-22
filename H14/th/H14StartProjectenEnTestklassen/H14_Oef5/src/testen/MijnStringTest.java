package testen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import domein.MijnString;

class MijnStringTest
{
    @Test
    public void geefAllePermutatiesVanDrieMetStringBuilder_woordCorrecteLengte_retourneertGeldigePermutaties()
    {
        MijnString ms = new MijnString("abc");
        String resultaat = ms.geefAllePermutatiesVanDrieMetStringBuilder();
        Assertions.assertTrue(resultaat.contains("abc"));
        Assertions.assertTrue(resultaat.contains("acb"));
        Assertions.assertTrue(resultaat.contains("bac"));
        Assertions.assertTrue(resultaat.contains("bca"));
        Assertions.assertTrue(resultaat.contains("cab"));
        Assertions.assertTrue(resultaat.contains("cba"));
    }

    @Test
    public void geefAllePermutatiesVanDrieMetStringBuilder_teKortWoord_werptException()
    {
        MijnString ms = new MijnString("ab");
        Assertions.assertThrows(IllegalArgumentException.class , () -> {ms.geefAllePermutatiesVanDrieMetStringBuilder();});
    }

    @Test
    public void geefAllePermutatiesVanDrieMetArray_woordCorrecteLengte_retourneertGeldigePermutaties()
    {
        MijnString ms = new MijnString("abc");
        String resultaat = ms.geefAllePermutatiesVanDrieMetArray();
        Assertions.assertTrue(resultaat.contains("abc"));
        Assertions.assertTrue(resultaat.contains("acb"));
        Assertions.assertTrue(resultaat.contains("bac"));
        Assertions.assertTrue(resultaat.contains("bca"));
        Assertions.assertTrue(resultaat.contains("cab"));
        Assertions.assertTrue(resultaat.contains("cba"));
    }

    @Test
    public void geefAllePermutatiesVanDrieMetArray_teKortWoord_werptException()
    {
        MijnString ms = new MijnString("ab");
        Assertions.assertThrows(IllegalArgumentException.class , () -> {ms.geefAllePermutatiesVanDrieMetArray();});
    }

}

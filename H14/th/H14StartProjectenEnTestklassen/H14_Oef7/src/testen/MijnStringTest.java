package testen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import domein.MijnString;

class MijnStringTest
{	
    @Test
    public void geefUnicodeTabel_retourneertUnicodeTabel()
    {
        String resultaat = MijnString.geefUnicodeTabel();    
        //controleer een aantal deelresultaten (geen volledige test!
        Assertions.assertTrue(resultaat.contains("104= h"));
        Assertions.assertTrue(resultaat.contains(" 61= ="));
        Assertions.assertTrue(resultaat.contains(" 37= %"));
        Assertions.assertTrue(resultaat.contains("252= ü"));
    }
}

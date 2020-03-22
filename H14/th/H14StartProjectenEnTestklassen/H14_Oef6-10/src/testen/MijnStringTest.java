package testen;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import domein.MijnString;

class MijnStringTest 
{

	    @Test
	    public void maakWartaal_metKleineLetters_retourneertCorrectResultaat()
	    {
	        MijnString ms = new MijnString("lepel");
	        String resultaat = ms.maakWartaal('e', 'a');
	        Assertions.assertEquals("lapal", resultaat);
	    }

	    @Test
	    public void maakWartaal_metGroteLetters_retourneertCorrectResultaat()
	    {
	        MijnString ms = new MijnString("LEPEL");
	        String resultaat = ms.maakWartaal('e', 'a');
	        Assertions.assertEquals("LAPAL", resultaat);
	    }

}

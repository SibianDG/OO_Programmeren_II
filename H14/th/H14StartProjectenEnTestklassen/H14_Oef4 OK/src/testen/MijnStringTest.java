package testen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import domein.MijnString;


class MijnStringTest 
{
    @Test
    public void keerOm_retourneertCorrectResultaat(){
        MijnString ms = new MijnString("lopen");
        Assertions.assertEquals("nepol",ms.keerOm());
    }
    
    @Test
    public void isPalindroom_retourneertTrue(){
        MijnString ms = new MijnString("lepel");
        Assertions.assertTrue(ms.isPalindroom());
    }
    
    @Test
    public void isPalindroom_retourneertFalse(){
        MijnString ms = new MijnString("hallo");
        Assertions.assertFalse(ms.isPalindroom());
    }    

}

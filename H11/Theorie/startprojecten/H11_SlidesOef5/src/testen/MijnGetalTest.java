package testen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import domein.MijnGetal;
import exceptions.NegativeNumberException;



public class MijnGetalTest {

	private MijnGetal mg1, mg2, mg3, mg4;

	@BeforeEach
	public void before() throws NegativeNumberException  {
		mg1 = new MijnGetal(6);
        mg2 = new MijnGetal(16);
        mg3 = new MijnGetal(18);
        mg4 = new MijnGetal(24);

	}

    @Test
    public void maakMijnGetal_getalIs6_maaktObject() 
    { 
    	Assertions.assertEquals(6, mg1.getGetal());
    }

    @Test
    public void maakMijnGetal_getalIsMin6_werptException() throws NegativeNumberException 
    {
    	Assertions.assertThrows(NegativeNumberException.class , () -> {new MijnGetal(-6);});
    }


    @Test
    public void getVierkantswortel_getalIs16_geeft4Terug() 
    {  
    	Assertions.assertEquals(4, mg2.geefVierkantswortel());
    }

    @Test
    public void getVierkantswortel_getalIs18_geeft4Terug() 
    {
    	Assertions.assertEquals(4, mg3.geefVierkantswortel());
    }

    @Test
    public void getVierkantswortel_getalIs24_geeft4Terug()
    {
    	Assertions.assertEquals(4, mg4.geefVierkantswortel());
    }

}

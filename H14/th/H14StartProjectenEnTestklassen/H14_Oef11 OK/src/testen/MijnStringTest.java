package testen;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import domein.MijnString;

class MijnStringTest
{

	@Test
    public void splitsOp_alleenDeel1_retourneertDeel1()
	{
        MijnString ms = new MijnString("dit is de test en ik hoop dat hij werkt");
        Assertions.assertEquals("dit is de test", ms.splitsOp(" en ")[0]);
    }
    
    @Test
    public void splitsOp_alleenDeel2_retourneertDeel2()
    {
        MijnString ms = new MijnString("dit is de test en ik hoop dat hij werkt");
        Assertions.assertEquals("ik hoop dat hij werkt", ms.splitsOp(" en ")[1]);
    }   
}

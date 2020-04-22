package domein;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import persistentie.BierMapper;
//dit is de repository
public class BierWinkel
{
    private final List<Bier> bieren;
    private final BierMapper bierMapper;

    public BierWinkel()
    {
        bierMapper=new BierMapper();
        bieren = bierMapper.inlezenBieren("bieren.txt");
    }

    public List<Bier> getBieren()
    {
        return bieren;
    }
    
    public long geefAantalBierenMetMinAlcoholPercentage(double percentage)
    {

        // TODO: 22/04/2020  
    }
   
    public List<Bier> geefAlleBierenMetMinAlcoholPercentage(double percentage)
    {
        // TODO: 22/04/2020  
        List<Bier> minstensgraden = new ArrayList<>();
        
        return minstensgraden;
    }

    //Bier met hoogst aantal graden
    public Bier geefBierMetHoogsteAlcoholPercentage()
    {
        /*TO DO*/
    	return null;
    }

    //Bier met laagst aantal graden
    public Bier geefBierMetLaagsteAlcoholPercentage()
    {
        /*TO DO*/
    	return null;
    }
    
    //Hulpmethode voor bier met hoogste/laagste alcoholgehalte
    public Bier[] sorteerVolgensAlcoholGehalte()
    {
        /*TO DO*/
    	return null;
    }

    /*Zorg ervoor dat het resultaat gesorteerd wordt op alcoholgehalte van hoog naar laag, 
     en bij gelijk aantal graden op naam (alfabetisch).
     */
    public List<Bier> sorteerOpAlcoholGehalteEnNaam()
    {
//        /*TO DO*/
    	return null;

    }   
    
    public List<String> geefNamenBieren()
    {
    	/*TO DO*/
    	return null;
    }

}

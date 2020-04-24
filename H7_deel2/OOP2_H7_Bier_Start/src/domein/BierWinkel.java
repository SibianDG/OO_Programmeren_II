package domein;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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
        long aantalBierenMetMinAlcoholPercentage = 0;
        for (Bier bier: bieren){
            if (bier.getAlcoholgehalte() >= percentage)
                aantalBierenMetMinAlcoholPercentage++;
        }
        return aantalBierenMetMinAlcoholPercentage;
    }
   
    public List<Bier> geefAlleBierenMetMinAlcoholPercentage(double percentage)
    {
        List<Bier> minstensgraden = new ArrayList<>();
        for (Bier bier: bieren){
            if (bier.getAlcoholgehalte() >= percentage)
                minstensgraden.add(bier);
        }
        return minstensgraden;
    }

    //Bier met hoogst aantal graden
    public Bier geefBierMetHoogsteAlcoholPercentage()
    {
        List<Bier> sorted = new ArrayList<>(sorteerOpAlcoholGehalteEnNaam());
        return sorted.get(0);
    }

    //Bier met laagst aantal graden
    public Bier geefBierMetLaagsteAlcoholPercentage()
    {
        List<Bier> sorted = new ArrayList<>(sorteerOpAlcoholGehalteEnNaam());
        return sorted.get(sorted.size()-1);
    }
    
    //Hulpmethode voor bier met hoogste/laagste alcoholgehalte
    public Bier[] sorteerVolgensAlcoholGehalte()
    {
        List<Bier> sorted = new ArrayList<>(sorteerOpAlcoholGehalteEnNaam());
        Bier[] bierenArray = new Bier[sorted.size()];
        return sorted.toArray(bierenArray);
    }

    /*Zorg ervoor dat het resultaat gesorteerd wordt op alcoholgehalte van hoog naar laag, 
     en bij gelijk aantal graden op naam (alfabetisch).
     */
    public List<Bier> sorteerOpAlcoholGehalteEnNaam()
    {
        List<Bier> sorted = new ArrayList<>(bieren);
        sorted.sort(new Comparator<Bier>() {
            @Override
            public int compare(Bier o1, Bier o2) {
                int res = Double.compare(o1.getAlcoholgehalte(), o2.getAlcoholgehalte());
                if (res == 0)
                    return o1.getNaam().compareTo(o2.getNaam());
                return res;
            }
        });
        return sorted;

    }   
    
    public List<String> geefNamenBieren()
    {
    	List<String> strings = new ArrayList<>();
    	for (Bier bier: bieren){
    	    strings.add(bier.getNaam());
        }
    	return strings;
    }

}

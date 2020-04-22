package domein;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DomeinController
{

    private final BierWinkel bierWinkel;

    public DomeinController()
    {
        bierWinkel = new BierWinkel();
    }   

    public long geefAantalBierenMetMinAlcoholPercentage(double percentage)
    {
        return bierWinkel.geefAantalBierenMetMinAlcoholPercentage(percentage);
    }
    
    public List<String> geefLijstAlleBierenMetMinAlcoholPercentage(double percentage)
    {
        List<Bier> biers = bierWinkel.geefAlleBierenMetMinAlcoholPercentage(percentage);
        List<String> lijstres = new ArrayList<>();
        for (Bier bier: biers){
            lijstres.add(bier.toString());
        }
        return lijstres;
    }
    
    public String geefNamenBieren()
    {
        String res = "";
        for (String string: bierWinkel.geefNamenBieren()){
            res += string;
        }
        return res;
    }
    
    public String geefBierMetHoogsteAlcoholPercentage()
    {
        return bierWinkel.geefBierMetHoogsteAlcoholPercentage().toString();
    }
    
    public String geefBierMetLaagsteAlcoholPercentage()
    {
        return bierWinkel.geefBierMetLaagsteAlcoholPercentage().toString();
    }
    
    public List<String> sorteerOpAlcoholGehalteEnNaam()
    {
        List<Bier> bieren = bierWinkel.getBieren();
        Bier[] bierenArray = new Bier[bieren.size()];
        bierenArray = bieren.toArray(bierenArray);
        Arrays.sort(bierenArray, new Comparator<Bier>() {
            @Override
            public int compare(Bier o1, Bier o2) {
                int res = Double.compare(o1.getAlcoholgehalte(), o2.getAlcoholgehalte());
                if (res == 0){
                    return o1.getNaam().compareTo(o2.getNaam());
                }
                return res;
            }
        });
        List<String> bierenString = new ArrayList<>();
        for (Bier bier: bierenArray){
            bierenString.add(bier.toString());
        }
        return bierenString;
    }
}

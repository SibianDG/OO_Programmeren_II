package domein;

import java.util.List;

public class DomeinController
{
    //TODO: te bekijken voor examen
    private AannemerRepository ar;

    public DomeinController()
    {
        ar = new AannemerRepository();
    }
    
    public String[] geefAannemersVanType(String type)
    {
        ar.bepaalAannemersVanType(type);
        List<Aannemer> aannemers = ar.getGefilterdeLijst();
        String[] namen = new String[aannemers.size()];
        int index = 0;
        for (Aannemer a : aannemers)
            namen[index++] = a.getNaamBedrijf();
        return namen;
    }
    
    public String[] geefTypesAannemers()
    {
        List<String> types = ar.geefTypesAannemers();
        String[] deTypes = new String[types.size()];
        int index = 0;
        for (String t : types)
            deTypes[index++] = t;
        return deTypes;
    }

    public String[] geefGegevensAannemer(String type, int index)
    {
    	ar.bepaalAannemersVanType(type);
        return ar.geefGegevens(index);
    }
}

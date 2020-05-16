package domein;

import java.util.ArrayList;
import java.util.List;
import persistentie.AannemerMapper;

public class AannemerRepository
{
    private final List<Aannemer> lijst, gefilterdeLijst;
    private final AannemerMapper am;
    
    public AannemerRepository()
    {
        am = new AannemerMapper();
        lijst = am.leesAannemers();
        gefilterdeLijst = new ArrayList<> ();
    }
    
    public List<Aannemer> getGefilterdeLijst()
	{
		return gefilterdeLijst;
	}

	public List<String> geefTypesAannemers()
    {
        List<String> types = new ArrayList<> ();
        for (Aannemer a : lijst)
        {
            String type = a.getTypeBedrijf();
            if (!types.contains(type))
                types.add(type);
        }
        return types;
    }
    
    public void bepaalAannemersVanType(String type)
    {
        for (Aannemer a : lijst)
        {
            if (a.getTypeBedrijf().equals(type))
                gefilterdeLijst.add(a);
        }
    }

    public String[] geefGegevens(int index)
    {
        Aannemer gezochteAannemer = geefGefilterdeLijstElementOp(index);
        String[] gegs = new String[3];
        gegs[0] = gezochteAannemer.getNaamBedrijf();
        gegs[1] = gezochteAannemer.getTypeBedrijf();
        gegs[2] = String.format("€%.2f", gezochteAannemer.bepaalOfferte());
        return gegs;
    }

    private Aannemer geefGefilterdeLijstElementOp(int index)
    {
        return gefilterdeLijst.get(index);
    }
}

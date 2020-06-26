package domein;

import java.util.List;

public class DomeinController
{
	private final KaartRepository kaartRepo;
	
	public DomeinController()
	{
		kaartRepo = new KaartRepository();
	}

	public void filterOp(int filternr, String filter)
	{
		switch (filternr)
		{
			case 0: kaartRepo.filterOpKleur(filter); break;
			case 1: kaartRepo.filterOpPunt(filter); break;
		}
	}
	
	public String[] geefGefilterdeKaarten()
	{
		return vertaalKaarten(kaartRepo.getGefilterd());
	}
	
	public String[] geefKaarten()
	{
		return vertaalKaarten(kaartRepo.getKaarten());
	}
	
	private String[] vertaalKaarten(List<Kaart> kaartLijst) {
		String[] array = new String[kaartLijst.size()];
		
		int index = 0;
		for (Kaart k : kaartLijst)
			array[index++] = k.toString();
		
		return array;
	}
	
	public String[] geefKaartOpIndex(int index)
	{
		List<Kaart> gefilterdeLijst = kaartRepo.getGefilterd();
		Kaart k = gefilterdeLijst.get(index);
		
		String[] info = new String[2];
		info[0] = k.getKleur();
		info[1] = k.getPunt();
		
		return info;
	}
}

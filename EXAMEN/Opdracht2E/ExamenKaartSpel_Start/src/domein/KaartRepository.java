package domein;

import java.util.ArrayList;
import java.util.List;

import persistentie.KaartMapper;

public class KaartRepository
{
	private final KaartMapper kaartMapper;
	private final List<Kaart> kaarten;
	private List<Kaart> gefilterd;
	
	public KaartRepository()
	{
		kaartMapper = new KaartMapper();
		kaarten = kaartMapper.geefKaartenInHand();	
		gefilterd = new ArrayList<>(kaarten);
	}
	

	public void filterOpPunt(String punt)
	{
		gefilterd.clear();
		
		for (Kaart k : kaarten)
			if (k.getPunt().equalsIgnoreCase(punt))
				gefilterd.add(k);
	}
	
	public void filterOpKleur(String kleur)
	{
		gefilterd.clear();
		
		for (Kaart k : kaarten)
			if (k.getKleur().equalsIgnoreCase(kleur))
				gefilterd.add(k);
	}
	
	public List<Kaart> getKaarten() {
		return kaarten;
	}

	public List<Kaart> getGefilterd()
	{
		return gefilterd;
	}
}

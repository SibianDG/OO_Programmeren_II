package domein;

public class Kaart
{
	private final String kleur;
	private final String punt;
	
	public Kaart(String naam, String type)
	{
		this.kleur = naam;
		this.punt = type;
	}

	public String getKleur()
	{
		return kleur;
	}

	public String getPunt()
	{
		return punt;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s - %s", kleur, punt);
	}
}
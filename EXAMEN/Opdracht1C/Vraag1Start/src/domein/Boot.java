package domein;

import exceptions.FormaatException;

public class Boot implements Comparable<Boot> {
	private final String naam;
	private boolean zeewaardig;
	
	public Boot() throws FormaatException {
		this("2000_Onbekend", true);
	}
	
	public Boot(String naam, boolean zeewaardig) throws FormaatException {
		super();
		controleerNaam(naam);
		this.naam = naam;
		setZeewaardig(zeewaardig);
	}
	
	private void controleerNaam(String naam) throws FormaatException {
		if (naam == null || naam.isEmpty()) {
			throw new IllegalArgumentException("Naam moet ingevuld zijn");
		} else {
			if (!naam.matches("^\\d{4}_[A-Z][a-z]{2,}$")) {
				throw new FormaatException("Naam voldoet niet aan het opgelegde formaat");
			}
		}
	}
	public String getNaam() {
		return naam;
	}
	public boolean getZeewaardig() {
		return zeewaardig;
	}
	private void setZeewaardig(boolean zeewaardig) {
		this.zeewaardig = zeewaardig;
	}

	@Override
	public String toString() {
		return String.format("%s: naam=%s, zeewaardig=%s", getClass().getSimpleName(), naam, zeewaardig ? "ja" : "nee");
	}

	@Override
	public int compareTo(Boot b) {
		int jaar1 = Integer.parseInt(naam.split("_")[0]);
		int jaar2 = Integer.parseInt(b.getNaam().split("_")[0]);
		int result = jaar2-jaar1;
		if (result == 0) {
			result = naam.compareTo(b.getNaam());
		}
		return result;
	}
}

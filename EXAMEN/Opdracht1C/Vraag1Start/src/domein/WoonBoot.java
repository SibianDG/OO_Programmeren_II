package domein;

import exceptions.FormaatException;

public class WoonBoot extends Boot implements MilieuBelasting {

	private  int aantalPersonen;
	private int aantalBadkamers;
	
	public WoonBoot() throws FormaatException {
		this("2000_Onbekend", false, 1, 1);
	}
	
	public WoonBoot(String naam, boolean zeewaardig, int aantalPersonen, int aantalBadkamers) throws FormaatException {
		super(naam, zeewaardig);
		setAantalPersonen(aantalPersonen);
		setAantalBadkamers(aantalBadkamers);
	}

	public int getAantalPersonen() {
		return aantalPersonen;
	}

	private void setAantalPersonen(int aantalPersonen) {
		if (aantalPersonen <= 0) {
			throw new IllegalArgumentException("Een woonboot heeft minimaal 1 persoon aan boord");
		}
		this.aantalPersonen = aantalPersonen;
	}

	public int getAantalBadkamers() {
		return aantalBadkamers;
	}

	private void setAantalBadkamers(int aantalBadkamers) {
		if (aantalBadkamers < 0) {
			throw new IllegalArgumentException("Een woonboot kan geen negatieve badkamers hebben");
		}
		this.aantalBadkamers = aantalBadkamers;
	}

	@Override
	public String toString() {
		return String.format("%s, aantal personen=%d, aantal badkamers=%d, milieuheffing=%d", super.toString(), aantalPersonen, aantalBadkamers, berekenMilieuheffing());
	}

	@Override
	public int berekenMilieuheffing() {
		if (aantalPersonen == 1) {
			return MILEUHEFFING_ALLEENSTAANDE;
		} else {
			return MILEUHEFFING_GEZIN;
		}
	}
	
}

package domein;

import exceptions.FormaatException;

public class ZeilBoot extends Boot {
	private int aantalMasten;
	
	public ZeilBoot() throws FormaatException {
		this("2000_onbekend", true, 1);
	}

	public ZeilBoot(String naam, boolean zeewaardig, int aantalMasten) throws FormaatException {
		super(naam, zeewaardig);
		setAantalMasten(aantalMasten);
	}

	public int getAantalMasten() {
		return aantalMasten;
	}

	private void setAantalMasten(int aantalMasten) {
		if (aantalMasten <= 0) {
			throw new IllegalArgumentException("Een zeilboot heeft minimaal 1 mast");
		}
		this.aantalMasten = aantalMasten;
	}

	@Override
	public String toString() {
		return String.format("%s, aantal masten=%d", super.toString(), aantalMasten);
	}
}

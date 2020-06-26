package domein;

import java.util.List;

import exceptions.FormaatException;

public class DomeinController {
	private BootRepository bootRepository;
	public DomeinController() throws FormaatException {
		bootRepository = new BootRepository();
	}
	
	public void voegBootToe(String[] gegevens) throws FormaatException {
		if (gegevens.length == 2) {
			bootRepository.voegBootToe(new Boot(gegevens[0], Boolean.parseBoolean(gegevens[1])));
		} else if (gegevens.length == 3) {
			bootRepository.voegZeilBootToe(new ZeilBoot(gegevens[0], Boolean.parseBoolean(gegevens[1]), Integer.parseInt(gegevens[2])));
		} else if (gegevens.length == 4) {
			bootRepository.voegWoonBootToe(
					new WoonBoot(gegevens[0], Boolean.parseBoolean(gegevens[1]), Integer.parseInt(gegevens[2]), Integer.parseInt(gegevens[3]
			)));
		}
	}
	
	public String[] geefGesorteerdOverzichtBoten() {
		List<Boot> botenList = bootRepository.geefGesorteerdeOverzichtBoten();
		String[] botenString = new String[botenList.size()];
		
		int index = 0;
		for (Boot b: botenList) {
			botenString[index++] = b.toString();
		}
		return botenString;
	}

}

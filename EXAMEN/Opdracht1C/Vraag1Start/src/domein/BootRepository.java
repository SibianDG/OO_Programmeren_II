package domein;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import exceptions.FormaatException;
import persistentie.BootMapper;

public class BootRepository {

	private BootMapper bootMapper;
	private List<Boot> botenlijst;
	
	public BootRepository() throws FormaatException {
		bootMapper = new BootMapper();
		botenlijst = bootMapper.geefBoten();
	}

	public List<Boot> getBotenlijst() {
		return botenlijst;
	}
	public void setBotenlijst(List<Boot> botenlijst) {
		this.botenlijst = botenlijst;
	}
	
	public void voegBootToe(Boot boot) {
		botenlijst.add(boot);
	}
	
	public void voegZeilBootToe(ZeilBoot zeilBoot) {
		botenlijst.add(zeilBoot);
	}
	
	public void voegWoonBootToe(WoonBoot woonboot) {
		botenlijst.add(woonboot);
	}
	
	public List<Boot> geefGesorteerdeOverzichtBoten(){
		Boot[] botenArray = new Boot[botenlijst.size()];
		botenArray = botenlijst.toArray(botenArray);
		Arrays.sort(botenArray);
		return Arrays.asList(botenArray);
	}
	
	
	
}

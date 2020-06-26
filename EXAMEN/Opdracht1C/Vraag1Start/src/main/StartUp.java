package main;


import domein.DomeinController;
import exceptions.FormaatException;
import ui.RederijApplicatie;

public class StartUp {

	public static void main(String[] args) throws FormaatException {
		new RederijApplicatie(new DomeinController()).start();
	}

}

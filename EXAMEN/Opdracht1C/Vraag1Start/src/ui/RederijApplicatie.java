package ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import domein.DomeinController;
import exceptions.FormaatException;

public class RederijApplicatie {
	
	private DomeinController dc;

	public RederijApplicatie(DomeinController dc) {
		this.dc = dc;
	}
	
	public void start() throws FormaatException {
		drukTabelAf(dc.geefGesorteerdOverzichtBoten());
		int keuze;
		do {
			keuze = maakKeuzeUitMenu();
			switch (keuze) {
			case 1:
				voegBootToe();
				break;
			case 2:
				voegZeilBootToe();
				break;
			case 3:
				voegWoonBootToe();
				break;
			case 0:
				drukTabelAf(dc.geefGesorteerdOverzichtBoten());
				break;
			}
		} while (keuze != 0);
	}
	
	public void voegBootToe() throws FormaatException {
		
		dc.voegBootToe(new String[]{leesGegeven("naam", "string"), leesGegeven("zeewaardig", "boolean")});
		
	}
	
	public void voegZeilBootToe() throws FormaatException {
		dc.voegBootToe(new String[]{leesGegeven("naam", "string"), leesGegeven("zeewaardig", "boolean"), leesGegeven("aantal masten", "int")});
		
	}
	public void voegWoonBootToe() throws FormaatException {
		dc.voegBootToe(new String[]{leesGegeven("naam", "string"), leesGegeven("zeewaardig", "boolean"), leesGegeven("aantal personen", "int"), leesGegeven("aantal badkamers", "int")});
	}
	 private String leesGegeven(String wat, String datatype) {
		 Scanner scanner = new Scanner(System.in);
		 System.out.printf("Geef de waarde voor %s: ", wat);
		 String string = scanner.next();
		 if (datatype.equals("int")) {
			// niet duidelijk wat dit moet doen? Voorbeeld zou handig geweest zijn.
		} else if (datatype.equals("boolean")) {
			// niet duidelijk wat dit moet doen? Voorbeeld zou handig geweest zijn.
		} else if (datatype.equals("string")) {
			// niet duidelijk wat dit moet doen? Voorbeeld zou handig geweest zijn.
		}
		 return string;
	 }
	 
	 private void drukTabelAf(String[] overzicht) {
		 for(String bootString: overzicht) {
			 System.out.println(bootString);
		 }
	}
	 
	 private int maakKeuzeUitMenu() {
		 Scanner scanner = new Scanner(System.in);
		 boolean herhalen = true;
		 int keuze = -1;
		 
		 while (herhalen) {
			 System.out.printf("Menu%n1. Voeg boot toe%n2. Voeg zeilboot toe%n3. Voeg woonboot toe%n0. Stoppen%nMaak je keuze: ");
			 try {
				keuze = scanner.nextInt();
				if (keuze >= 0 && keuze <= 3) {
					herhalen = false;
				}

			} catch (InputMismatchException ime) {
				System.err.println("Voer een getal in!");
			} 
		}
		return keuze;
		 
		 
	 }

}

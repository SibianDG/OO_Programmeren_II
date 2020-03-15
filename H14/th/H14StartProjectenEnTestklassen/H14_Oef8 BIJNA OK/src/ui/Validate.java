package ui;

import domein.ValidateInput;
import java.util.Scanner;

public class Validate
{
	public void start()
	{
		Scanner invoer = new Scanner(System.in);
		String email, huisnr, postcode, naam;
		
		do {
			System.out.print("Geef een postcode: ");
			postcode = invoer.next();
		} while (!ValidateInput.validatePostcode(postcode));
		System.out.println("De postcode is ok!");

		do {
			System.out.print("Geef een huisnr: ");
			huisnr = invoer.next();
		} while (!ValidateInput.validateHuisnr(huisnr));
		System.out.println("Het huisnr is ok!");

		invoer.nextLine();
		do {
			System.out.print("Geef een naam: ");
			naam = invoer.nextLine();
		} while (!ValidateInput.validateNaam(naam));
		System.out.println("De naam is ok!");
		
		do {
			System.out.print("Geef een e-mail: ");
			email = invoer.next();
		} while (!ValidateInput.validateEmail(email));
		System.out.println("Het e-mail-adres is ok!");
	}
}

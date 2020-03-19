package domein;

import static java.nio.charset.StandardCharsets.ISO_8859_1;
import static java.nio.charset.StandardCharsets.UTF_8;

public class ValidateInput
{
    //postcode moet uit 4 cijfers bestaan, eerste cijfer mag niet met 0 zijn    

	public static boolean validatePostcode(String postcode)
	{
		return postcode.matches("[1-9]\\d{3}");
	}
  //huisnr moet beginnen met een cijfer. Er mag slechts 1 letter in 
//voorkomen. Een letter mag gevolgd worden door 1 cijfer

//10, 10A, 10a2 zijn geldig
//10zz, 10z34, z2 zijn ongeldig

	public static boolean validateHuisnr(String huisnr)
	{
     	return huisnr.matches("\\d+[a-zA-Z]?");
	}
 //Naam moet beginnen met een letter, van a tot z of van A tot Z	
//Naam mag de volgende letters bevatten: é, è, ç, à (niet beginnen!)  
//Naam mag opgesplitst worden door spaties.	
//Naam moet minstens twee letters bevatten.

//Van dérvèle, vàn çeler, van der velde, vààn zijn geldige namen
//v der, één zijn ongeldige namen
       
	public static boolean validateNaam(String naam)
	{
		String matchNaam;
		matchNaam = "[A-Za-z][a-zéçèà]+(\\s[a-zéçèà]+)*";
		// nodig om ook de letters met accenten goed te verwerken
		byte juistInBytes[] = matchNaam.getBytes(ISO_8859_1);
		String juistMetAccenten = new String(juistInBytes, UTF_8);
		return naam.matches(juistMetAccenten);
	}
 //Email moet beginnen met een letter en moet één @ bevatten
//Voor @: email mag punten bevatten. De punten moet direct gevolgd    				
//worden door één of meerdere letters.

//Na @: @ direct gevolgd door minstens één letter. Email moet minstens 
//één punt of scheidingsteken – bevatten. De . en - moeten direct gevolgd 
//worden door één of meerdere letters. 

// test.test.test@test.punt-streep.punt is geldig
//Test@test.com is geldig
//test@Test.com-be is geldig
//test.test is ongeldig
//test@test.-test is ongeldig

    public static boolean validateEmail(String email)
	{
           return email.matches("[a-zA-Z][a-zA-Z]*[.]?[a-zA-Z]+@[a-zA-Z]+[-.][a-zA-Z]+");
	}

}


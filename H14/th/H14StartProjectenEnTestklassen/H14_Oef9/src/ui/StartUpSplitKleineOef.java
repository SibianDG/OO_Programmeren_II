package ui;

import java.util.Arrays;

public class StartUpSplitKleineOef 
{
	public static void main(String args[]) 
	{
		new StartUpSplitKleineOef();
	}

	public StartUpSplitKleineOef() {
		String zin = "dit 123 is 56 een 1 oefening";
//splits de zin op in woorden; scheidingsteken: getallen
		String[] woorden = zin.split(" \\d+ ");

		System.out.printf("%s%n", zin);
		System.out.printf("%d%n", woorden.length);
		System.out.printf("%s%n", Arrays.toString(woorden));

		zin = "dit . 123 is 56 een!!100 oefening- 677";
//splits de zin op in woorden; scheidingsteken: 
//niet-karakters of spaties
		woorden = zin.split("[^a-zA-Z]+");
		// oplossing woorden = zin.split("\\W+|\\s+");

		System.out.printf("%s%n", zin);
		System.out.printf("%d%n", woorden.length);
		System.out.printf("%s%n", Arrays.toString(woorden));

		zin = "dit is een methode. Verschillende methodes";
//splits de zin op in woorden; scheidingsteken: 
//het woord methode, gevolgd door 1 willekeurig karakter
		woorden = zin.split("methode.");

		System.out.printf("%s%n", zin);
		System.out.printf("%d%n", woorden.length);
		System.out.printf("%s%n", Arrays.toString(woorden));

		zin = "dit. 123 is .       een.  oefening:";
//splits de zin op in woorden; scheidingsteken: 
//een punt, gevolgd door 0, 1 of meerdere spaties
//een punt is een metacharacter.
		System.out.printf("%s%n", zin);
		woorden = zin.split("\\.([01]|[ ]+)"); // -> verkeerd gelezen
		//oplossing woorden = zin.split("\\.\\s*");
		System.out.println(woorden.length);
		System.out.println(Arrays.toString(woorden));
	}
}

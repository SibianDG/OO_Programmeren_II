package persistentie;

import java.util.ArrayList;
import java.util.List;

import domein.Boot;
import domein.WoonBoot;
import domein.ZeilBoot;
import exceptions.FormaatException;

public class BootMapper
{
	//dummy methode om fietsenlijst te vullen
	public List<Boot> geefBoten() throws FormaatException
	{
		List<Boot> lijst = new ArrayList<>();
		lijst.add(new Boot("2005_Arkvannoe", true));
		lijst.add(new Boot("2010_Vaarder", true));
		lijst.add(new ZeilBoot("2015_Zeiljacht", true, 2));
		lijst.add(new ZeilBoot("2018_Windlokker", true, 4));
		lijst.add(new WoonBoot("1990_Mijnhuisje", false, 4, 0));
		lijst.add(new WoonBoot("1995_Rustigwater", false, 6, 1));
		
		return lijst;
	}
}
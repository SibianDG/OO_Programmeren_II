package ui;

import domein.MijnString;

public class Oef2
{
    public static void main(String[] args)
    {
        String voornaam, familienaam;
        voornaam = "Jan";
        familienaam = "Van Vleteren";
        MijnString object = new MijnString( String.format("%s %s", voornaam, familienaam) );
               
        System.out.printf("De initialen: %s%n", object.bepaalInitialen());
    }
}

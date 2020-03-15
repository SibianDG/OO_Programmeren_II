package ui;

import domein.MijnString;

public class Oef1
{
    public static void main(String[] args)
    {
        String woord = "hottentottententoonstelling";
        
        MijnString object = new MijnString(woord);
               
        System.out.printf("Middelste letter = %s%n", object.bepaalMiddelsteKar());
    }
}
